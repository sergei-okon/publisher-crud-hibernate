CREATE TABLE IF NOT EXISTS writers
(
    writer_id bigint      not null auto_increment,
    name      varchar(45) not null,
    CONSTRAINT writers_pkey PRIMARY KEY (writer_id)
)