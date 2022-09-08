drop table if exists `user`;

create table user
(
    `id`       bigint       not null primary key comment 'id',
    `email`    varchar(255) null comment '邮箱',
    `password` varchar(255) null comment '密码',
    `phone`    varchar(255) null comment '手机号',
    `username` varchar(255) null comment '昵称'
) engine=InnoDB default CHARSET=utf8mb4 comment='用户';

drop table if exists `ebook`;


create table `ebook` (
    `id` bigint NOT NULL auto_increment comment 'id',
    `name` varchar(50)  comment '名称',
    `category1_id`  bigint comment '分类1',
    `category2_id`  bigint comment '分类2',
    `description` varchar(255)  comment '描述',
    `cover` varchar(255) comment '封面',
    `doc_count` int comment '文档数',
    `view_count` int  comment '阅读数',
    `vote_count` int  comment '点赞数',
    primary key (`id`)

) engine=InnoDB default charset=utf8mb4 comment='电子书';

insert into `ebook` (id, name, description) values (1, 'Spring Boot 入门教程', '零基础入门Java开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (2, 'Vue 入门教程', '零基础入门Vue开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (3, 'Python 入门教程', '零基础入门Python开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (4, 'MySQL 入门教程', '零基础入门MySQL开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (5, 'Nodejs 入门教程', '零基础入门Nodejs开发，企业级应用开发最佳首选框架');






































