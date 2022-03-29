package ua.com.okonsergei.repository.db.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.okonsergei.repository.PostRepository;
import ua.com.okonsergei.repository.db.entity.Post;
import ua.com.okonsergei.repository.db.entity.PostStatus;
import ua.com.okonsergei.utils.HibernateUtil;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public List<Post> findAll() {
        List<Post> postEntities;
        try (Session session = HibernateUtil.openSession()) {
            postEntities = session.createQuery("FROM Post p WHERE p.status='ACTIVE'", Post.class).list();
        }
        return postEntities;
    }

    @Override
    public Post findById(Long id) {
        Post post;
        try (Session session = HibernateUtil.openSession()) {
            post = session.get(Post.class, id);
        }
        return post;
    }

    @Override
    public Post save(Post post) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long postId = (Long) session.save(post);
            post.setId(postId);
            transaction.commit();
            System.out.println("Added post with id " + postId);
        }
        return post;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Post post = session.get(Post.class, id);

            if (post == null || post.getStatus().equals(PostStatus.DELETED)) {
                System.out.println("Unable to delete Post from database. Post with id " + id + " not found");
            } else {
                post.setStatus(PostStatus.DELETED);
                session.update(post);
                System.out.println("Deleted Post by id " + id);
            }
            transaction.commit();
        }
    }

    @Override
    public void update(Post post) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Post postForUpdate = session.get(Post.class, post.getId());

            if (postForUpdate == null) {
                System.out.println("Unable to update Post from database. Post not found");
            } else {
                postForUpdate.setContent(post.getContent());
                postForUpdate.setStatus(post.getStatus());
                postForUpdate.setTags(post.getTags());
                session.update(postForUpdate);
                System.out.println("Update Post with id " + postForUpdate.getId());
            }
            transaction.commit();
        }
    }
}
