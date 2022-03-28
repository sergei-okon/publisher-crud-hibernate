#
# CREATE TABLE IF NOT EXISTS posts_tags
# (
# #     id       bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
#     Post_post_id  bigint NOT NULL,
#     tags_tag_id bigint NOT NULL,
# #     CONSTRAINT posts_labels_pkey PRIMARY KEY (id),
#
#     CONSTRAINT tags_tag_id  FOREIGN KEY (tags_tag_id)
#         REFERENCES tags (tag_id) MATCH SIMPLE,
# #         ON UPDATE CASCADE
# #         ON DELETE CASCADE,
#     CONSTRAINT Post_post_id FOREIGN KEY (Post_post_id)
#         REFERENCES  posts (post_id) MATCH SIMPLE
# #         ON UPDATE CASCADE
# #         ON DELETE CASCADE
# )

CREATE TABLE IF NOT EXISTS posts_tags
(
#     id       bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    Post_post_id  bigint NOT NULL,
    tags_tag_id bigint NOT NULL,
#     CONSTRAINT posts_labels_pkey PRIMARY KEY (id),

    CONSTRAINT Post_post_id  FOREIGN KEY (tags_tag_id)
        REFERENCES tags (tag_id) MATCH SIMPLE,
#         ON UPDATE CASCADE
#         ON DELETE CASCADE,
    CONSTRAINT tags_tag_id FOREIGN KEY (Post_post_id)
        REFERENCES  posts (post_id) MATCH SIMPLE
#         ON UPDATE CASCADE
#         ON DELETE CASCADE
)