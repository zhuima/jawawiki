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




# 分类
drop table if exists `category`;

create table `category` (
     `id` bigint NOT NULL auto_increment comment 'id',
     `parent` bigint NOT NULL default 0 comment '父id',
     `name` varchar(50)  comment '名称',
     `sort` int comment '顺序',
     primary key (`id`)

) engine=InnoDB default charset=utf8mb4 comment='分类';


insert into `category` (id, parent, name, sort) values (100, 000, '前端开发', 100);
insert into `category` (id, parent, name, sort) values (101, 100, 'Vue', 101);
insert into `category` (id, parent, name, sort) values (102, 000, 'HTML & CSS', 102);
insert into `category` (id, parent, name, sort) values (200, 000, 'JAVA', 200);
insert into `category` (id, parent, name, sort) values (201, 200, '基础应用', 201);
insert into `category` (id, parent, name, sort) values (202, 200, '框架应用', 202);
insert into `category` (id, parent, name, sort) values (300, 000, 'Python', 300);
insert into `category` (id, parent, name, sort) values (301, 300, '爬虫应用', 301);
insert into `category` (id, parent, name, sort) values (302, 300, '进阶方向应用', 302);
insert into `category` (id, parent, name, sort) values (400, 000, '数据库', 400);
insert into `category` (id, parent, name, sort) values (401, 400, 'MySQL应用', 401);
insert into `category` (id, parent, name, sort) values (402, 400, '其他', 402);
insert into `category` (id, parent, name, sort) values (500, 000, '服务器', 500);
insert into `category` (id, parent, name, sort) values (501, 500, '系统应用', 501);
insert into `category` (id, parent, name, sort) values (502, 500, '业务应用', 502);
insert into `category` (id, parent, name, sort) values (503, 500, 'SRE应用', 503);























