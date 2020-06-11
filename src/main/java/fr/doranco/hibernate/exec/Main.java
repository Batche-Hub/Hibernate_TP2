/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.hibernate.exec;



import fr.doranco.entity.Commande;
import fr.doranco.entity.Utilisateur;
import fr.doranco.model.dao.CommandeDAO;
import fr.doranco.model.dao.ICommandeDAO;
import fr.doranco.model.dao.UtilisateurDAO;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Boule
 */
public class Main {
    public static void main(String[] args) throws Exception{

        try {

    	UtilisateurDAO utilisateurDao = new UtilisateurDAO();
    	ICommandeDAO commandeDao = new CommandeDAO();

    	Utilisateur utilisateur = new Utilisateur("BADAD", "Cherif");
    	Commande commande1 = new Commande("Livre", 2);
    	Commande commande2 = new Commande("DVD", 3);
        
            Commande commandeAdded = commandeDao.addCommande(commande2);
    	
    	
    	
    	Utilisateur utilisateurAjoute = utilisateurDao.addUtilisateur(utilisateur);
        
            System.err.println(utilisateurAjoute);
    	
//    	List<Commande> listeCommandesByName = 
//    	System.out.println(utilisateurAdded);
//    	System.out.println(utilisateurAdded.getListeCommandes());
    	
    	System.exit(0);
        
        
        
        
        
        
//        System.err.println(personneAjoutee);
//        personneAjoutee.setNom("Gogol");
//        personneDAO.updatePersonne(personneAjoutee);
//        
//        List<Personne> listePersonnes = personneDAO.getListePersonne();
//        
//        for(Personne personne : listePersonnes){
//            System.err.println(personne);
//        }
//        
//        List<Personne> listePersonnesNom = personneDAO.getListePersonneByNom("Gogol");
//        
//        for(Personne personneNom : listePersonnesNom){
//            System.err.println(personneNom);
        
//        personneDAO.removePersonne(personneAjoutee);
        
//        personneDAO.removePersonne(100);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.exit(0);
        }




        
    }
}
