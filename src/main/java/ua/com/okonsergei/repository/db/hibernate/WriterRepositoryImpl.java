package ua.com.okonsergei.repository.db.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.okonsergei.repository.WriterRepository;
import ua.com.okonsergei.repository.entity.Writer;
import ua.com.okonsergei.utils.HibernateUtil;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public List<Writer> findAll() {
        List<Writer> writerEntities;
        try (Session session = HibernateUtil.openSession()) {
            writerEntities = session.createQuery("FROM Writer ", Writer.class).list();
        }
        return writerEntities;
    }

    @Override
    public Writer findById(Long id) {
        Writer writer;
        try (Session session = HibernateUtil.openSession()) {
            writer = session.get(Writer.class, id);
        }
        return writer;
    }

    @Override
    public Writer save(Writer writer) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long writerId = (Long) session.save(writer);
            writer.setId(writerId);
            transaction.commit();
        }
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
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
    }

    @Override
    public void update(Writer writer) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            Writer writerForUpdate = session.get(Writer.class, writer.getId());

            if (writerForUpdate == null) {
                System.out.println("Unable to update Writer from database. Writer not found");
            } else {
                writerForUpdate.setName(writer.getName());
                writerForUpdate.setPosts(writer.getPosts());
                session.update(writerForUpdate);
                System.out.println("Update writer with id " + writerForUpdate.getId());
            }
            transaction.commit();
        }
    }
}