/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Personne;
import java.util.List;


/**
 *
 * @author Boule
 */
public interface IPersonneDAO {
    
   public Personne getPersonne(Integer id) throws Exception;
    
   public Personne addPersonne(Personne personne) throws Exception;
    
   public void updatePersonne(Personne personne)throws Exception;
    
   public void removePersonne(Personne personne) throws Exception;
   
   public List<Personne> getListePersonne() throws Exception;
   
   public List<Personne> getListePersonneByNom(String nom) throws Exception;
   
   public List<Personne> getListePersonneByVille(String ville) throws Exception;
}
