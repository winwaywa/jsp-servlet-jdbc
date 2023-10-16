use shopDB;

create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
	createdAt timestamp null,
    updatedAt timestamp null,
	createdBy varchar(255) null,
    updatedBy varchar(255) null
);

create table user(
	id bigint not null primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    fullname varchar(255) null,
    status int not null,
    role_id bigint not null,
	createdAt timestamp null,
    updatedAt timestamp null,
	createdBy varchar(255) null,
    updatedBy varchar(255) null
);

alter table user add constraint fk_user_role foreign key (role_id) references role(id);

create table category(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
	createdAt timestamp null,
    updatedAt timestamp null,
	createdBy varchar(255) null,
    updatedBy varchar(255) null
);

create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnail varchar(255) null,
    short_description text null,
    content text null,
    category_id bigint not null,
	createdAt timestamp null,
    updatedAt timestamp null,
	createdBy varchar(255) null,
    updatedBy varchar(255) null
);

alter table news add constraint fk_news_category foreign key (category_id) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
    content varchar(255) not null,
    user_id bigint not null,
    news_id bigint not null,
	createdAt timestamp null,
    updatedAt timestamp null,
	createdBy varchar(255) null,
    updatedBy varchar(255) null
);

alter table comment add constraint fk_comments_news foreign key (news_id) references news(id);
alter table comment add constraint fk_comments_user foreign key (user_id) references user(id);




insert into category(code, name) values('the-thao',"Thể thao");
insert into category(code, name) values('chinh-tri',"Chinh Trị");


insert into news(title,short_description,content,category_id) value("Tieu de 1", "Mo ta ngan 1","Noi dung 1", 1);
insert into news(title,short_description,content,category_id) value("Tieu de 2", "Mo ta ngan 2","Noi dung 2", 1);