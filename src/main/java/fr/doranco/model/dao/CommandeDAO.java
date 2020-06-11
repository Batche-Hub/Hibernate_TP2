/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Commande;
import fr.doranco.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Boule
 */
public class CommandeDAO implements ICommandeDAO{

    @Override
    public Commande getCommande(Integer id) throws Exception {
       Session session = null;
        Commande commande = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            commande = session.get(Commande.class, id);
            System.out.println("La commande choisie est  " + commande);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode getCommande : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return commande;
    }

    @Override
    public Commande addCommande(Commande commande) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(commande);
            System.out.println("La commande a bien été enregistrée " + commande);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode addCommande : " + ex);
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
        return commande;
    }

    @Override
    public void updateCommande(Commande commande) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(commande);
            System.out.println("La commande a bien été mise à jour " + commande);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode updateCommande : " + ex);
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
    public void removeCommande(Commande commande) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(commande);
            System.out.println("La commande a bien été annulée.");
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
    public List<Commande> getListeCommandes() throws Exception {
         Session session = null;
        List<Commande> listeCommandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr = "from Commande";
            listeCommandes = session.createQuery(queryStr, Commande.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode getListCommande : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listeCommandes;
    }

    @Override
    public List<Commande> getListeCommandesByIdPersonne(Integer idPersonne) throws Exception {
        Session session = null;
        List<Commande> listeCommandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr = "from Commande c where c.utilisateur.id = :id";
            Query query = session.createQuery(queryStr);
            query.setParameter("id", idPersonne);
            listeCommandes = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode getListCommande : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listeCommandes;
    }

    @Override
    public List<Commande> getListeCommandesByName(String nom) throws Exception {
        Session session = null;
        List<Commande> listeCommandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String QueryStr = "from Commande c where c.utilisateur.nom = :nom";
            Query query = session.createQuery(QueryStr);
            query.setParameter("nom", nom);
            listeCommandes = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode getListCommande : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listeCommandes;
    }

//    @Override
//    public List<Commande> getListeCommandesAll() throws Exception {
//        Session session = null;
//        List<Commande> listeCommandes = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            Query query = session.createQuery("from Commande c where c.utilisateur.id = :id");
//            query.setParameter("id", idPersonne);
//            listeCommandes = query.list();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.err.println("Une erreur est survenue dans la classe CommandeDAO et la méthode getListCommande : " + ex);
//            if (session != null) {
//                session.close();
//            }
//        }
//        return listeCommandes;
//    }

    @Override
    public List<Commande> getListeCommandesAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
