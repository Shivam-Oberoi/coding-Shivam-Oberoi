# coding-Shivam-Oberoi

### Business Requirement 
You have to design and build the system that allows to receive and collect data about energy consumption from different villages. As a result, your system should, on demand, give out the consumption report per village for the last 24h. As a result of your work, we expect the end-to-end design of the system (a model, system architecture, technology, and frameworks choice, testing strategy, etc.). We would also like to see your code for the whole system or reasonable part of it.

### To Start

Clone the repo: git clone https://github.com/Shivam-Oberoi/coding-Shivam-Oberoi.git Fork the repo Prerequisites
This is a spring boot application. Run mvn clean install in the root directory 

*To run:  `mvn spring-boot:run`

### Framework

1. Spring Boot
2. Entity Frameowrk to be used with H2(in-memory) for all database operation.
3. Mockito for testing.

### Architecture Design:

MVC(Model, View and Controller)
1.	Controller:- For all incoming request.
2.	Mapper for DTO TO DO and DO to DTO.
3.	Service:-Business Logic to handle all the processing.
4.	DAO:-All for the database operation(save, delete).

### API

1. to add consumption
POST /counter/callback
{
    "counter_id": "1",
    "amount": 10000.123
}

2. To get information additional information about the counter you have to call the following API:
GET /counter?id=1
{
    "id": "1",
    "village_name": "gurgaon"
}
3. To get the consumption report:
GET /consumption_report?duration=24h
{
    "villages": [
        {
            "consumption": 400,
            "villageName": "gurgaon"
        },
        {
            "consumption": 800,
            "villageName": "delhi"
        }
    ]
} 

