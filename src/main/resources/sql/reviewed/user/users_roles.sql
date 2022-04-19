insert into blumen2.users_roles(user_id,role_id)
select :userId, role_id from blumen2.roles where org_id=:orgId and name=:roleName;
