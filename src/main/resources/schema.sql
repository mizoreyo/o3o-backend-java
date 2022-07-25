create table if not exists t_comment
(
    id           long auto_increment,
    replyTo    long,
    pageId     varchar,
    guestName  varchar,
    guestEmail varchar,
    guestSite  varchar,
    comment     varchar(800),
    date         long,
    constraint T_COMMENT_PK
        primary key (id)
);

create unique index if not exists T_COMMENT_ID_UINDEX
    on t_comment (id);