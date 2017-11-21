/**
 * CREATE Script for init of DB
 */

-- Create village 
insert into village (id, name) values (1,'gurgaon');
insert into village (id, name) values (2,'delhi');
insert into village (id, name) values (3,'noida');

-- Create counter
insert into counter (id, VILLAGE_ID) values (1, 1);
insert into counter (id, VILLAGE_ID) values (2, 2);







