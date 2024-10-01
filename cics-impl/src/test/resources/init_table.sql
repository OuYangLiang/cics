create table if not exists `user_profile` (
    `id`        bigint      not null    auto_increment comment '主键',
    `username`  varchar(32) not null    comment '登录账号',
    `password`  varchar(32) not null    comment '密码',
    primary key ( `id` ),
    unique key ( `username` )
) engine=innodb default charset=utf8;

create table if not exists `employee` (
    `id`                bigint          not null    auto_increment comment '主键',
    `phone`             varchar(32)     not null    comment '电话',
    `employee_name`     varchar(32)     not null    comment '姓名',
    `department`        varchar(32)     not null    comment '部门',
    `salary`            bigint          not null    comment '薪水',
    primary key ( `id` ),
    unique key ( `phone` ),
    key (`department`)
) engine=innodb default charset=utf8;