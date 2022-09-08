drop table if exists `user`;

create table user
(
    `id`       bigint       not null primary key comment 'id',
    `email`    varchar(255) null comment '邮箱',
    `password` varchar(255) null comment '密码',
    `phone`    varchar(255) null comment '手机号',
    `username` varchar(255) null comment '昵称'
) engine=InnoDB default CHARSET=utf8mb4 comment='用户';

