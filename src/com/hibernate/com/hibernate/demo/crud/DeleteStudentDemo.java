package com.hibernate.com.hibernate.demo.crud;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
           /* Integer id = 1;

            Student mystudent = session.get(Student.class,id);

            session.delete(mystudent);*/
            session.createQuery("delete from Student where id='2'").executeUpdate();
            session.getTransaction().commit();

        }

        finally {
            sessionFactory.close();
        }
    }
}
