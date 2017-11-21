package com.electricity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.electricity.constants.CounterConstants;
import com.electricity.dataaccessobject.CounterAmountRepository;
import com.electricity.dataaccessobject.CounterRepository;
import com.electricity.domainobject.CounterAmountDO;
import com.electricity.exception.CounterNotFoundException;
import com.electricity.exception.InvalidFormatException;

/**
 * Service to get VillageName, post consumption and get Report.
 * 
 * <p/>
 */
@Service
public class CounterServiceImpl implements CounterService
{

    private final CounterAmountRepository counterAmountRepository;

    private final CounterRepository counterRepository;

    private final Pattern hourPattern = Pattern.compile("^[\\d+]+" + CounterConstants.HOURS + "$");

    private final Pattern minutePattern = Pattern.compile("^[\\d+]+" + CounterConstants.MINUTES + "$");


    public CounterServiceImpl(final CounterAmountRepository counterAmountRepository, final CounterRepository counterRepository)
    {
        this.counterAmountRepository = counterAmountRepository;
        this.counterRepository = counterRepository;
    }


    /**
     * Create a consumption with amount and counterId.
     *
     * @param counterAmountDO
     **/
    @Override
    public CounterAmountDO addConsumption(CounterAmountDO counterAmountDO)
    {
        checkIfCounterExists(counterAmountDO.getCounterId());
        return counterAmountRepository.save(counterAmountDO);
    }


    /**
     * Get the villageName using counterId.
     *
     * @param id
     **/
    @Override
    public String getVillage(long id)
    {
        checkIfCounterExists(id);
        String villageName = (String) counterRepository.findVillage(id);
        return villageName;
    }


    /**
     * Get the consumption report using duration.
     *
     * @param duration
     **/
    @Override
    public List<Object[]> getConsumptionReport(String duration)
    {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime reportRange = getDuration(duration, currentTime);
        List<Object[]> result = counterRepository.findVillagesForReport(reportRange, currentTime);
        return result;
    }


    /**
    * Get the duration value in terms of LocalDateTime.
    *
    * @param duration
    * @param currentTime
    **/
    private LocalDateTime getDuration(String duration, LocalDateTime currentTime)
    {
        final Matcher hourMatcher = hourPattern.matcher(duration);
        final Matcher minuteMatcher = minutePattern.matcher(duration);

        if (hourMatcher.matches())
        {
            Long hours = formatDuration(duration, CounterConstants.HOURS);
            LocalDateTime reportRange = currentTime.minusHours(hours);
            return reportRange;
        }
        else if (minuteMatcher.matches())
        {
            Long minutes = formatDuration(duration, CounterConstants.MINUTES);
            LocalDateTime reportRange = currentTime.minusMinutes(minutes);
            return reportRange;
        }
        else
        {
            throw new InvalidFormatException("Check the format of duration" + duration);
        }
    }


    /**
     * Formats duration on the basis of format ie h or m
     *
     * @param duration
     * @param format
     **/
    private Long formatDuration(String durationValue, String format)
    {
        long duration = 0;
        try
        {
            duration = Long.valueOf(durationValue.split(format)[0]);
        }
        catch (Exception e)
        {
            return duration;
        }
        return duration;
    }


    /**
     * Check if the given counterId exists or not.
     *
     * @param counterId
     * 
     **/
    private void checkIfCounterExists(Long counterId)
    {
        if (!counterRepository.exists(counterId))
        {
            throw new CounterNotFoundException("No such counterId exists" + counterId);
        }
    }
}
