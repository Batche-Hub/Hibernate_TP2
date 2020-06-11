/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.entity;


import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Boule
 */
@Entity
@Table(name="adresse")
@XmlRootElement
public class Adresse implements Serializable {

    private static final long serialVersionUID = -7748759835143391762L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")  private Integer id;
    
    
    @Column(name="numero")
    private Integer numero;
    
    
    @Column(name="rue")
    private String rue;
    
    
    @Column(name="ville")
    private String ville;
    
    
    @Column(name="code_postal")
    private Integer codePostal;
    

    
    //Constructeurs
    public Adresse() {
    }

    public Adresse(Integer numero, String rue, String ville, Integer codePostal) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    
    
    //to string
    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + '}';
    }

    
    
    
    //Get set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
    
    
    
    
}
