CREATE TABLE IF NOT EXISTS  writers_posts
(
    Writer_writer_id bigint NOT NULL,
    posts_post_id bigint NOT NULL,
#     CONSTRAINT writers_posts_pkey PRIMARY KEY (id),
    CONSTRAINT post_id FOREIGN KEY (posts_post_id)
        REFERENCES posts (post_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT writer_id FOREIGN KEY (Writer_writer_id)
        REFERENCES writers (writer_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)