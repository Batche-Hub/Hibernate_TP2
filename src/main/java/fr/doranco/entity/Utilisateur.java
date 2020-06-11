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
@Entity 
@Table(name = "utilisateur")
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") private int id;
    
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)       
    List <Commande> commande;

    public Utilisateur() {
    }

    
    
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    
    
    
}
