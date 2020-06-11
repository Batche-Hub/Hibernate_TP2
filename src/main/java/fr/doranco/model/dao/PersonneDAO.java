/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;
import fr.doranco.entity.Personne;
import fr.doranco.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Boule
 */
public class PersonneDAO implements IPersonneDAO {

    public PersonneDAO() {
    }

    @Override
    public Personne getPersonne(Integer id) throws Exception {
        Session session = null;
        Personne personne = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
//            String query = "select personne from Personne personne";
//            session.createQuery(query);
            personne = session.get(Personne.class, id);
            System.out.println("La personne choisie est  " + personne);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getPersonne : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return personne;
    }

    @Override
    public Personne addPersonne(Personne personne) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(personne);
            System.out.println("La personne a bien été crée " + personne);
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
        return personne;
    }

    @Override
    public void updatePersonne(Personne personne) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(personne);
            System.out.println("La personne a bien été crée " + personne);
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
    public void removePersonne(Personne personne) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(personne);
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
    public List<Personne> getListePersonne() throws Exception {
        Session session = null;
        List<Personne> listePersonnes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            listePersonnes = session.createQuery("from Personne", Personne.class).list();
            System.out.println("Les personnes choisies sont  " + listePersonnes);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getPersonne : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listePersonnes;

    }

    @Override
    public List<Personne> getListePersonneByNom(String nom) throws Exception {
        Session session = null;
        List<Personne> listePersonnes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String queryString = "from Personne p where p.nom= :nom";

            Query query = session.createQuery(queryString);
            query.setParameter("nom", nom);

            listePersonnes = query.list();

            System.out.println("Les personnes choisies avec le nom "+nom+" sont  " + listePersonnes);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getListPersonneByNom : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listePersonnes;
    }

    @Override
    public List<Personne> getListePersonneByVille(String ville) throws Exception {
        Session session = null;
        List<Personne> listePersonnes = null;
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            String queryString = "from Personne p where p.adresse.ville = :ville";
            Query query = session.createQuery(queryString);
            query.setParameter("ville", ville);

            listePersonnes = query.list();

            System.out.println("Les personnes dans la ville "+ville+" sont  " + listePersonnes);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Une erreur est survenue dans la classe PersonneDAO et la méthode getListPersonneByVille : " + ex);
            if (session != null) {
                session.close();
            }
        }
        return listePersonnes;
    }
    
    
}
