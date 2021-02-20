insert into Archetype (id,name) values (1,'Melee');
insert into Archetype (id,name) values (2,'Ranged');
insert into Archetype (id,name) values (3,'Cavalry');

insert into Tier (id,name,color) values (0,'Rustic Era','#bbbdbd');
insert into Tier (id,name,color) values (1,'Feudal Era','#bbbdbd');
insert into Tier (id,name,color) values (2,'Chivalric Era','#5fca6f');
insert into Tier (id,name,color) values (3,'Silver Era','#39a1e2');
insert into Tier (id,name,color) values (4,'Heroic Era','#b461cc');
insert into Tier (id,name,color) values (5,'Golden Era','#dc9c43');

insert into Unit (id,name,arch_id,tier_id) values (1,'Winged Hussars',3,5);
insert into Unit (id,name,arch_id,tier_id) values (2,'Monastic Knights',3,5);
insert into Unit (id,name,arch_id,tier_id) values (3,'Spearman Sargeants',1,4);
insert into Unit (id,name,arch_id,tier_id) values (4,'Condottieri',1,3);
insert into Unit (id,name,arch_id,tier_id) values (5,'Prefecture Archers',2,3);
insert into Unit (id,name,arch_id,tier_id) values (6,'Vassal Longbowmen',2,4);
insert into Unit (id,name,arch_id,tier_id) values (7,'Pike Militia',1,2);
insert into Unit (id,name,arch_id,tier_id) values (8,'Serfs',1,0);