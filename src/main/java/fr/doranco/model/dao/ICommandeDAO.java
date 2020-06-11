/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Commande;
import fr.doranco.entity.Personne;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface ICommandeDAO {
    public Commande getCommande(Integer id) throws Exception;
    
   public Commande addCommande(Commande commande) throws Exception;
    
   public void updateCommande(Commande commande)throws Exception;
    
   public void removeCommande(Commande commande) throws Exception;
   
   public List<Commande> getListeCommandes() throws Exception;
   
   public List<Commande> getListeCommandesByIdPersonne(Integer idPersonne) throws Exception;
   
   public List<Commande> getListeCommandesByName(String nom) throws Exception;
   
    public List<Commande> getListeCommandesAll() throws Exception;
}
