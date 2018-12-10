create table board (
id bigserial primary key,
title varchar(64) not null
);

create table list (
id bigserial primary key,
board_id bigserial references board(id) not null,
title varchar(64) not null
);

create table card (
id bigserial primary key,
list_id bigserial references list(id) not null,
title varchar(64) not null
);