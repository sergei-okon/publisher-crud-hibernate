alter table posts_tags
    add constraint
        foreign key (tags_tag_id)
            references tags (tag_id);

alter table posts_tags
    add constraint
        foreign key (Post_post_id)
            references posts (post_id);

alter table writers_posts
    add constraint
        foreign key (posts_post_id)
            references posts (post_id);

alter table writers_posts
    add constraint
        foreign key (Writer_writer_id)
            references writers (writer_id);
