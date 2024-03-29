--
-- mocko数据库管理
--

--
-- 用户信息表
--
create table mocko.m_user
(
    id            int unsigned not null default 0 auto_increment comment 'id',

    nick_name     varchar(32)  not null default '' comment '昵称',
    username      varchar(32)  not null default '' comment '用户名',
    password      varchar(32)  not null default '' comment '密码',

    operator_code varchar(32)  not null default 0 comment '操作人ID',
    deleted       tinyint      not null default 0 comment '删除标记',
    create_time   datetime     not null default now() comment '创建时间',
    update_time   timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id)
) engine = myisam
  character set = utf8mb4
  collate = utf8mb4_bin comment = '用户信息表';

--
-- 应用信息表
--
create table mocko.m_app
(
    id            int unsigned not null default 0 auto_increment comment 'id',

    app_id        varchar(32)  not null default '' comment '应用ID',
    app_name      varchar(32)  not null default '' comment '应用名称',

    operator_code varchar(32)  not null default 0 comment '操作人ID',
    deleted       tinyint      not null default 0 comment '删除标记',
    create_time   datetime     not null default now() comment '创建时间',
    update_time   timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id)
) engine = myisam
  character set = utf8mb4
  collate = utf8mb4_bin comment = '应用信息表';



--
-- 包信息表
--
create table mocko.m_package
(
    id            int unsigned not null default 0 auto_increment comment 'id',

    app_id        varchar(32)  not null default '' comment '应用ID',
    pkg_name      varchar(32)  not null default '' comment '包名',
    parent_name   varchar(32)  not null default '' comment '父级包名',

    operator_code varchar(32)  not null default 0 comment '操作人ID',
    deleted       tinyint      not null default 0 comment '删除标记',
    create_time   datetime     not null default now() comment '创建时间',
    update_time   timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id)
) engine = myisam
  character set = utf8mb4
  collate = utf8mb4_bin comment = '包信息表';


--
-- 组件信息表
--
create table mocko.m_type
(
    id            int unsigned not null default 0 auto_increment comment 'id',

    app_id        varchar(32)  not null default '' comment '应用ID',

    type_id       varchar(32)  not null default '' comment '类ID',
    type_alias    varchar(32)  not null default '' comment '类别名',
    type_name     varchar(32)  not null default '' comment '类名',
    full_name     varchar(64)  not null default '' comment '全限定类名',

    operator_code varchar(32)  not null default 0 comment '操作人ID',
    deleted       tinyint      not null default 0 comment '删除标记',
    create_time   datetime     not null default now() comment '创建时间',
    update_time   timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id)
) engine = myisam
  character set = utf8mb4
  collate = utf8mb4_bin comment = '类信息表';


--
-- 方法信息表
--
create table mocko.m_method
(
    id            int unsigned not null default 0 auto_increment comment 'id',

    type_id       varchar(32)  not null default '' comment '类ID',
    method_id     varchar(32)  not null default '' comment '方法ID',
    method_alias  varchar(32)  not null default '' comment '方法别名',
    method_name   varchar(64)  not null default '' comment '方法名称: 全限定类名#方法名',
    args          varchar(512) not null default '' comment '参数信息',
    response      tinytext     not null default '' comment '响应信息',

    operator_code int          not null default 0 comment '操作人ID',
    deleted       int          not null default 0 comment '删除标记',
    create_time   datetime     not null default now() comment '创建时间',
    update_time   timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id)
) engine = myisam
  character set = utf8mb4
  collate = utf8mb4_bin comment = '方法信息表';


