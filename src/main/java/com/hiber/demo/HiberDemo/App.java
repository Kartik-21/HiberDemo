package com.hiber.demo.HiberDemo;

import org.hibernate.SQLQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Emp.class)
                .addAnnotatedClass(Project.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        for (int i = 0; i < 3; i++) {
            Emp emp = new Emp();
            emp.setEmpName("Kartik " + i);

            List<Project> projects = new ArrayList<Project>();

            for (int j = 0; j < 2; j++) {
                Project project = new Project();
                project.setpName("Test " + j);
                project.setEmp(emp);
                projects.add(project);
                session.save(project);
            }


            emp.setProject(projects);
            session.save(emp);


        }

        System.out.println("========================App.main=======================");

//        Emp emp = new Emp();
//
//        emp = session.get(Emp.class, 20);
//
//        System.out.println(emp);


        /// get perticuar column
       /* Query query = session.createQuery("select empName from Emp");

        List<Object> list = query.list();

        for (Object e : list) {
            System.out.println(e);
        }*/


        Query query = session.createQuery("from Emp");

        List<Emp> list = query.list();

        for (Emp e : list) {
            System.out.println(e);
        }



     /*   ///native sql
        SQLQuery query = session.createSQLQuery("Select * from Emp");
        query.addEntity(Emp.class);
        List<Emp> list = query.list();

        for (Emp e : list) {
            System.out.println(e);
        }*/


        transaction.commit();
    }
}
