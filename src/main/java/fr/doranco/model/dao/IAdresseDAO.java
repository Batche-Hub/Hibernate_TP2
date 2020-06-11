/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.model.dao;

import fr.doranco.entity.Adresse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Boule
 */
public interface IAdresseDAO {
    
   public Adresse getAdresse(Integer id) throws Exception;
    
   public Adresse addAdresse(Adresse adresse) throws Exception;
    
   public void updateAdresse(Adresse adresse) throws Exception;
    
   public void removeAdresse(Integer id) throws Exception;
}
