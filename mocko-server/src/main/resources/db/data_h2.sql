--
-- mocko数据库schema
--


--
-- 用户信息
--
insert into m_user (username, password)
select 'admin', 'ea6aa923463acfa94b3aaa37231ee926'
from dual
where not exists(select 1 from m_user where username = 'admin');



--
-- 应用信息
--

insert into m_app (app_id, app_name)
select '22222222', '测试'
from dual
where not exists(select 1 from m_app where app_id = '22222222');