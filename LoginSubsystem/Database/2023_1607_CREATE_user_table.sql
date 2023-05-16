create table if not exists user_tbl(
id INT generated always as identity not null,
userName VARCHAR not null,
password VARCHAR not null,
primary key (id)
)