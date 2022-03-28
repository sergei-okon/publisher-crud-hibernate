CREATE TABLE IF NOT EXISTS posts
(
    post_id bigint not null auto_increment,
    content character varying(100) NOT NULL,
    status varchar(255),
    CONSTRAINT posts_pkey PRIMARY KEY (post_id)
)