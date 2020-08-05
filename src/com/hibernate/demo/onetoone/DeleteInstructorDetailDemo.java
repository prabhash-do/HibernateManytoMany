package com.hibernate.demo.onetoone;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.Instructor_Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(Instructor_Detail.class)
                                            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Integer id=15;
            Instructor_Detail detail = session.get(Instructor_Detail.class,id);

            //remove the assosciated object refernce
            //break bi-deirectional link
            detail.getInstructor().setInstructorDetail(null);

            session.delete(detail);

            session.getTransaction().commit();

            System.out.println("Instructor Detail___"+detail.toString());
            System.out.println("Instructor----"+detail.getInstructor());

        }
        finally {
            sessionFactory.close();
        }
    }
}
