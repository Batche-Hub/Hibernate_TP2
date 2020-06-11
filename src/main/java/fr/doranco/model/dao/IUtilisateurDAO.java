/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Personne;
import fr.doranco.entity.Utilisateur;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IUtilisateurDAO {
    public Utilisateur getUtilisateur(Integer id) throws Exception;
    
   public Utilisateur addUtilisateur(Utilisateur utilisateur) throws Exception;
    
   public void updateUtilisateur(Utilisateur utilisateur)throws Exception;
    
   public void removeUtilisateur(Utilisateur utilisateur) throws Exception;
   
   public List<Utilisateur> getListeUtilisateur() throws Exception;
   
   public List<Utilisateur> getListeUtilisateurByNom(String nom) throws Exception;
   
}
