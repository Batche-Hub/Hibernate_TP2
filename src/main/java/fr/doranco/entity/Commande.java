/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.entity;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Boule
 */
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") private int id;
    
    @Column(name="nom")
    private String typeArticle;
    
    @Column(name="prenom")
    private int quantité;
    
   @ManyToOne
   Utilisateur utilisateur;

    public Commande() {
    }

    public Commande(String typeArticle, int quantité) {
        this.typeArticle = typeArticle;
        this.quantité = quantité;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(String typeArticle) {
        this.typeArticle = typeArticle;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
 
}
