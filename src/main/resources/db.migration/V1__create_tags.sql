CREATE TABLE IF NOT EXISTS  tags
(
    tag_id bigint not null auto_increment,
    name character varying(100)  NOT NULL,
    CONSTRAINT tag_pkey PRIMARY KEY (tag_id),
    CONSTRAINT tags_name_key UNIQUE (name)
)
