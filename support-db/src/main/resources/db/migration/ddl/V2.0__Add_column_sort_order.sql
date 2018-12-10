alter table board add column sort_order int not null default 0;
alter table list add column sort_order int not null default 0;
alter table card add column sort_order int not null default 0;