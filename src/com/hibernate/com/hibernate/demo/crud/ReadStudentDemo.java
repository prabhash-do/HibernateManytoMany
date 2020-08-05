package com.hibernate.com.hibernate.demo.crud;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Student student = new Student("qqe","q1234","wwe@ss.cc");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Generated id--"+student.getId());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student mystudent = session.get(Student.class,student.getId());

            System.out.println("Student Deatils__"+mystudent.toString());

        }

        finally {
            sessionFactory.close();
        }
    }
}
