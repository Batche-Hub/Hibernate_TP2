/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Personne;
import fr.doranco.entity.Utilisateur;
import fr.doranco.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Boule
 */

public class UtilisateurDAO implements IUtilisateurDAO {

    public UtilisateurDAO() {
    }

    
    @Override
    public Utilisateur getUtilisateur(Integer id) throws Exception {
        Session session = null;
        Utilisateur utilisateur = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            utilisateur = session.get(Utilisateur.class, id);
            System.out.println("L'utilisateurice choisi.e est  " + utilisateur);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getPersonne : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return utilisateur;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(utilisateur);
            System.out.println("La personne a bien été crée " + utilisateur);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode addPersonne : " + ex);
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
        return utilisateur;
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(utilisateur);
            System.out.println("La personne a bien été crée " + utilisateur);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode updatePersonne : " + ex);
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
    public void removeUtilisateur(Utilisateur utilisateur) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(utilisateur);
            System.out.println("La personne a bien été effacée.");
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode removePersonne : " + ex);
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
    public List<Utilisateur> getListeUtilisateur() throws Exception {
        Session session = null;
        List<Utilisateur> listeUtilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            listeUtilisateurs = session.createQuery("from Utilisateur", Utilisateur.class).list();
//            System.out.println("Les personnes choisies sont  " + listeUtilisateurs);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getPersonne : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listeUtilisateurs;
    }

    @Override
    public List<Utilisateur> getListeUtilisateurByNom(String nom) throws Exception {
        Session session = null;
        List<Utilisateur> listeUtilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String queryString = "from Utilisateur u where u.nom= :nom";

            Query query = session.createQuery(queryString);
            query.setParameter("nom", nom);

            listeUtilisateurs = query.list();

            System.out.println("Les personnes choisies avec le nom "+nom+" sont  " + listeUtilisateurs);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getListPersonneByNom : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listeUtilisateurs;
    }
    
}
