--**********************************
--Ajuste do NLS_CHARACTERSET
--**********************************

connect sys/oracle as sysdba;
shutdown;
startup restrict;
Alter database character set INTERNAL_USE WE8ISO8859P1;
shutdown immediate;
startup;
connect system/oracle

--**********************************
--Tuning OracleXE
--**********************************

alter system set filesystemio_options=directio scope=spfile;
alter system set disk_asynch_io=false scope=spfile;

--**********************************
--Esquema easyprocess
--**********************************

create tablespace easyprocess datafile '/u01/app/oracle/oradata/XE/easyprocess01.dbf' size 100M online;
create tablespace idx_easyprocess datafile '/u01/app/oracle/oradata/XE/idx_easyprocess01.dbf' size 100M;
create user easyprocess identified by easyprocess default tablespace easyprocess temporary tablespace temp;
grant resource to easyprocess;
grant connect to easyprocess;
grant create view to easyprocess;
grant create procedure to easyprocess;
grant create materialized view to easyprocess;
alter user easyprocess default role connect, resource;

--**********************************
--Disabling 8080-http port
--**********************************

Exec dbms_xdb.sethttpport(0);

exit;
