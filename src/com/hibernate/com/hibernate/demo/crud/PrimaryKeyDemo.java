package com.hibernate.com.hibernate.demo.crud;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Student student1 = new Student("wer","bby","wer@qqw.cc");
            Student student2 = new Student("oi","koo","weqwr@qqw.cc");
            Student student3 = new Student("mkll","kop","wetyr@qqw.cc");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
        }

        finally {
            factory.close();
        }
    }
}
