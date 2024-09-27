create table if not exists `user_profile` (
    `id`        bigint          auto_increment comment '主键',
    `username`  varchar(32) not null    comment '登录账号',
    `password`  varchar(32) not null    comment '密码',
    primary key ( `id` ),
    unique key ( `username` )
) engine=innodb default charset=utf8;
