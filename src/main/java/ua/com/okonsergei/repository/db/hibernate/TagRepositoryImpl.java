package ua.com.okonsergei.repository.db.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.okonsergei.repository.TagRepository;
import ua.com.okonsergei.repository.db.entity.Tag;
import ua.com.okonsergei.utils.HibernateUtil;

import java.util.List;

public class TagRepositoryImpl implements TagRepository {

    @Override
    public List<Tag> findAll() {
        List<Tag> tags;
        try (Session session = HibernateUtil.openSession()) {
            tags = session.createQuery("FROM Tag", Tag.class).list();
        }
        return tags;
    }

    @Override
    public Tag findById(Long id) {
        Tag tag;
        try (Session session = HibernateUtil.openSession()) {
            tag = session.get(Tag.class, id);
        }
        return tag;
    }

    @Override
    public Tag save(Tag tag) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long tagId = (Long) session.save(tag);
            tag.setId(tagId);
            transaction.commit();
        }
        return tag;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tag = session.get(Tag.class, id);

            String sql = "SELECT  Post_post_id  from posts_tags where tags_tag_id=" + id;
            int countRowInPostsTagsTable = session.createSQLQuery(sql).getResultList().size();
            if (tag == null || countRowInPostsTagsTable > 0) {
                System.out.println("Unable to delete Tag from database.");
            } else {
                session.delete(tag);
                System.out.println("Deleted Tag by id " + id);
            }
            transaction.commit();
        }
    }

    @Override
    public void update(Tag tag) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tagForUpdate = session.get(Tag.class, tag.getId());

            if (tagForUpdate == null) {
                System.out.println("Unable to update Tag from database. Tag not found");
            } else {
                tagForUpdate.setName(tag.getName());
                session.update(tagForUpdate);
                System.out.println("Update Tag with id " + tagForUpdate.getId());
            }
            transaction.commit();
        }
    }
}