

-- Migrations will appear here as you chat with AI

create table area (
  id serial primary key,
  nombre varchar(500) not null,
  descripcion text
);

create table estado (
  id serial primary key,
  nombre varchar(50) not null,
  descripcion text 
);

create table director (
  id serial primary key,
  nombre varchar(100) not null,
  email varchar(100) not null
);

create table proyecto (
  id serial primary key,
  nombre text not null,
  area_id int references area (id),
  estado_id int references estado (id),
  resumen text,
  archivo_pdf varchar(1000),
  director_id int references director (id)
);

alter table proyecto
add column fecha_registro timestamp with time zone default now();

create table alumno (
  id serial primary key,
  nombre varchar(100) not null,
  email varchar(100) not null
);

create table proyecto_alumno (
  proyecto_id int references proyecto (id),
  alumno_id int references alumno (id),
  primary key (proyecto_id, alumno_id)
);

create table programa (
  id serial primary key,
  nombre varchar(200) not null
);

alter table alumno
add column telefono varchar(20),
add column codigo varchar(10) not null,
add column programa_id int references programa (id);

create table jurado (
  id serial primary key,
  nombre varchar(100) not null,
  email varchar(100) not null,
  telefono varchar(20)
);

create table proyectos_jurado (
  proyecto_id int references proyecto (id),
  jurado_id int references jurado (id),
  primary key (proyecto_id, jurado_id)
);

create table historial_estado (
  id serial primary key,
  proyecto_id int references proyecto (id),
  estado_id int references estado (id),
  fecha_cambio timestamp with time zone default now(),
  observacion text
);

alter table proyectos_jurado
add column nota numeric(3, 2),
add column observaciones text;
