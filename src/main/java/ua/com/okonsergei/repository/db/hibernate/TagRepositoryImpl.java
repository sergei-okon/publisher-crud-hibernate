package ua.com.okonsergei.repository.db.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ua.com.okonsergei.repository.TagRepository;
import ua.com.okonsergei.repository.db.entity.Tag;
import ua.com.okonsergei.utils.HibernateUtil;

import java.util.List;

public class TagRepositoryImpl implements TagRepository {

    @Override
    public List<Tag> findAll() {
        List<Tag> tags;
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        tags = session.createQuery("FROM Tag", Tag.class).list();
        transaction.commit();
        return tags;
    }

    @Override
    public Tag findById(Long id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Tag tag = session.get(Tag.class, id);
        transaction.commit();
        return tag;
    }

    @Override
    public Tag save(Tag tag) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Long tagId = (Long) session.save(tag);
        tag.setId(tagId);
        transaction.commit();
        return tag;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Tag tag = session.get(Tag.class, id);

        String sql = "SELECT  Post_post_id  from posts_tags where tags_tag_id=" + id;
        int size = session.createSQLQuery(sql).getResultList().size();
        if (tag == null || size > 1) {
            System.out.println("Unable to delete Tag from database. Tag with id " + id + " not found");
        } else {
            session.delete(tag);
            System.out.println("Deleted Tag by id " + id);
        }
        transaction.commit();
    }

    @Override
    public void update(Tag tag) {
        Session session = HibernateUtil.getCurrentSession();
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
