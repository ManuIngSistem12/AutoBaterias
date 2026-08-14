create table rol(
  id serial primary key,
  name varchar(50) not null unique
);

create table brand(
  id serial primary key,
  name varchar(50) not null unique
);

create table sale(
  id serial primary key,
  total numeric(12,2) not null,
  fecha timestamp not null default now()
);

create table users(
  id serial primary key,
  identity varchar(50) not null unique,
  name varchar(50) not null,
  last_name varchar(50) not null,
  number varchar(50) not null,
  email varchar(100) not null unique,
  rol_id integer not null,
  password varchar(300) not null,
  active boolean not null default true,
  constraint fk_user_rol foreign key (rol_id) references rol(id)
);

create table battery(
  id serial primary key,
  brand_id integer not null,
  battery_detail varchar(100) not null,
  stock integer not null default 0 check(stock >= 0),
  constraint fk_battery_brand foreign key (brand_id) references brand(id)
);

create table sale_detail(
  id serial primary key,
  sale_id integer not null,
  battery_id integer not null,
  quantity integer not null check(quantity > 0),
  unit_price numeric(12,2) not null check(unit_price > 0),
  subtotal numeric(12,2) not null,
  constraint fk_detail_sale foreign key (sale_id) references sale(id),
  constraint fk_detail_battery foreign key (battery_id) references battery(id)
);