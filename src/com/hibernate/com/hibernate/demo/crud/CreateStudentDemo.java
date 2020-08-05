package com.hibernate.com.hibernate.demo.crud;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            Student student = new Student("asd", "123qwe", "qwe@qwe.co");

            session.beginTransaction();

            session.save(student);


            session.getTransaction().commit();
    }
        finally {

            sessionFactory.close();
        }
        }
}
