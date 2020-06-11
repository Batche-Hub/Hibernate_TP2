/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Adresse;
import fr.doranco.entity.Personne;
import fr.doranco.hibernate.util.HibernateUtil;
import fr.doranco.model.datasource.HibernateTP1DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Boule
 */
public class AdresseDAO implements IAdresseDAO{

    
    
    public AdresseDAO() {
    }
    
    @Override
    public Adresse getAdresse(Integer id) throws Exception {
        Session session = null;
        Adresse adresse = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
//            String query = "select personne from Personne personne";
//            session.createQuery(query);
            adresse = session.get(Adresse.class, id);
            System.out.println("L'adresse choisie est  " + adresse);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe AdresseDAO et la méthode getAdresse : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return adresse;
    }

    @Override
    public Adresse addAdresse(Adresse adresse) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(adresse);
            System.out.println("L'adresse a bien été crée " + adresse);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe AdresseDAO et la méthode addAdresse : " + ex);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex) {
                System.err.println("Une erreur est survenue lors de la fermeture de la session : " + ex);
            }
        }
        return adresse;
    }

    @Override
    public void updateAdresse(Adresse adresse) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(adresse);
            System.out.println("L'adresse a bien été crée " + adresse);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe AdresseDAO et la méthode updateAdresse : " + ex);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex) {
                System.err.println("Une erreur est survenue lors de la fermeture de la session : " + ex);
            }
        }
    }

    @Override
    public void removeAdresse(Integer id) throws Exception{
        Adresse adresse = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            adresse = session.get(Adresse.class, id);
            session.delete(adresse);
            System.out.println("L'adresse a bien été effacée.");
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe AdresseDAO et la méthode removeAdresse : " + ex);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex) {
                System.err.println("Une erreur est survenue lors de la fermeture de la session : " + ex);
            }
        }
    }
    
}
