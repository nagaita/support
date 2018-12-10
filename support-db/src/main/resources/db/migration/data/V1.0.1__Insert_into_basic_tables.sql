insert into board (title) values ('Board A');
insert into board (title) values ('Board B');
insert into board (title) values ('Board C');

insert into list (board_id, title) values ((select max(id) from board where title = 'Board A'), 'Todo');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board A'), 'Doing');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board A'), 'Done');

insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Todo'), 'Card A-1');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Todo'), 'Card A-2');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Todo'), 'Card A-3');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Doing'), 'Card A-4');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Done'), 'Card A-5');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Done'), 'Card A-6');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Done'), 'Card A-7');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Done'), 'Card A-8');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board A' and l.title = 'Done'), 'Card A-9');

insert into list (board_id, title) values ((select max(id) from board where title = 'Board B'), 'Todo');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board B'), 'Doing');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board B'), 'Wait');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board B'), 'Done');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board B'), 'Cancel');

insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Todo'), 'Card B-1');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Todo'), 'Card B-2');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Doing'), 'Card B-3');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Doing'), 'Card B-4');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Wait'), 'Card B-5');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Done'), 'Card B-6');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Done'), 'Card B-7');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Cancel'), 'Card B-8');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board B' and l.title = 'Cancel'), 'Card B-9');

insert into list (board_id, title) values ((select max(id) from board where title = 'Board C'), 'Todo');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board C'), 'Doing');
insert into list (board_id, title) values ((select max(id) from board where title = 'Board C'), 'Done');

insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-1');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-2');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-3');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-4');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-5');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-6');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-7');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-8');
insert into card (list_id, title) values ((select (l.id) from list l inner join board b on l.board_id = b.id where b.title = 'Board C' and l.title = 'Todo'), 'Card C-9');