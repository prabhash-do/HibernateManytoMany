package com.hibernate.com.hibernate.demo.crud;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Integer id=1;

            session.beginTransaction();

            Student mystudent = session.get(Student.class,id);

            mystudent.setName("Prabhash");
            session.getTransaction().commit();
            System.out.println("Student Deatils__"+mystudent.toString());

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("update Student set password='qwe@123.com'")
                                .executeUpdate();

            session.getTransaction().commit();
        }

        finally {
            sessionFactory.close();
        }
    }
}
