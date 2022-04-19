--delete existing data for new org_id if any
delete from blumen2.security_question_list where org_id=:org_id;
delete from blumen2.pulldown where org_id=:org_id;
delete from blumen2.config_setting where org_id=:org_id;
delete from  blumen2.roles_privileges where (role_id, privilege_id) in (
    select role_id, privilege_id from blumen2.privileges p, blumen2.roles r
    where p.org_id=:org_id and r.org_id=:org_id  and p.role_code = r.code);
delete from blumen2.privileges where org_id=:org_id;

delete from blumen2.users_roles where role_id in (select role_id from  blumen2.roles where org_id=:org_id);
delete from blumen2.roles where org_id=:org_id;

--copy security questions from org0
insert into blumen2.security_question_list(name,org_id,question_type)
select name,:org_id,question_type from  blumen2.security_question_list where org_id=0;

--copy pulldown questions from org0
insert into blumen2.pulldown(active,code,name,org_id)
select active,code,name,:org_id from  blumen2.pulldown where org_id=0;

--copy config_setting questions from org0
insert into blumen2.config_setting(config_id,config_type,config_value,description,organisation_type,org_id)
select config_id,config_type,config_value,description,organisation_type,:org_id from  blumen2.config_setting where org_id='0';

--copy roles  from org0
insert into blumen2.roles(name,code,is_default,org_id)
select name,code,is_default,:org_id  from  blumen2.roles where org_id=0;

--copy privileges  from org0
insert into blumen2.privileges(name,org_id, access_type,parent_code, code, role_code)
select name, :org_id, access_type,parent_code, code, role_code  from  blumen2.privileges where org_id=0;

--copy privileges_id, role_id into  from org0
insert into blumen2.roles_privileges
select role_id, privilege_id from blumen2.privileges p, blumen2.roles r
where p.org_id=:org_id and r.org_id=:org_id  and p.role_code = r.code;
