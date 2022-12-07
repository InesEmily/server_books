create table author
(
    id   integer      not null AUTO_INCREMENT,
    name varchar(255) not null,
    primary key (id)
);

create table book_authors(
    books_id integer not null,
    authors_id integer not null
);
create table book_awards(
                             books_id integer not null,
                             awards_id integer not null
);

/*convert the data that is already in the author-column of the book-table*/
insert into author (name)
select author  from (SELECT distinct author FROM book) as author;

insert into book_authors (books_id, authors_id)
select book.id, author.id FROM book inner join author  on book.author=author.name;

insert into awards (id)
select awards  from (SELECT distinct awards FROM book) as awards;

insert into book_awards (books_id, awards_id)
select book.id, awards.id FROM book inner join awards  on book.awards=awards.id;


