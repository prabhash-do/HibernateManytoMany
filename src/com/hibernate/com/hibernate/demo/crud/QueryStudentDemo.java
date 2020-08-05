package com.hibernate.com.hibernate.demo.crud;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student").getResultList();

            for(Student student:studentList)
                System.out.println("Student---"+student);

            studentList = session.createQuery("from Student s where s.name='oi'").getResultList();

            for(Student student:studentList)
                System.out.println("Student where---"+student);

            studentList = session.createQuery("from Student s " +
                    "where s.name='asd' OR s.password='koo'").getResultList();

            for(Student student:studentList)
                System.out.println("Student OR---"+student);

            studentList = session.createQuery("from Student s where " +
                    "s.email LIKE '%qqw.cc'" ).getResultList();
            for(Student student:studentList)
                System.out.println("Student Like---"+student);

            session.getTransaction().commit();
        }

        finally {

        }
    }
}
