create table users
(
	id int auto_increment,
	name varchar(255) not null,
	email varchar(255) not null,
	password varchar(60) not null,
	constraint users_pk
		primary key (id)
);

create unique index users_email_uindex
	on users (email);

