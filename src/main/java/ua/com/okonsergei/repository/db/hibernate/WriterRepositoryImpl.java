package ua.com.okonsergei.repository.db.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.okonsergei.repository.WriterRepository;
import ua.com.okonsergei.repository.db.entity.Writer;
import ua.com.okonsergei.utils.HibernateUtil;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public List<Writer> findAll() {
        List<Writer> writerEntities;
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        writerEntities = session.createQuery("FROM Writer ", Writer.class).list();
        transaction.commit();
        return writerEntities;
    }

    @Override
    public Writer findById(Long id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        transaction.commit();
        return writer;

    }

    @Override
    public Writer save(Writer writer) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Long writerId = (Long) session.save(writer);
        writer.setId(writerId);
        transaction.commit();
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);

        if (writer == null) {
            System.out.println("Writer with id " + id + " not found");
        } else {
            session.delete(writer);
            System.out.println("Deleted writer by id " + id);
        }
        transaction.commit();
    }

    @Override
    public void update(Writer writer) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Writer writerForUpdate = session.get(Writer.class, writer.getId());

        writerForUpdate.setName(writer.getName());
        writerForUpdate.setPosts(writer.getPosts());
        session.update(writerForUpdate);
        System.out.println("Update writer with id " + writerForUpdate.getId());

        transaction.commit();
    }
}
