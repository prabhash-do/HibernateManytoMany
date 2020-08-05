package com.hibernate.demo.onetoone;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.Instructor_Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Instructor_Detail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {

            Integer id = 14;

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,id);
            System.out.println("Details  "+instructor);
            //This will also delete the instructor object of the use of cascadetype.all
            session.delete(instructor);


            session.getTransaction().commit();
        }
        finally {

            sessionFactory.close();
        }
    }
}
