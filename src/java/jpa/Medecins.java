/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Natacha
 */
@Entity
@Table(name = "Medecins")
public class Medecins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Column(name = "TITRE") private String titre;
    @Column(name = "NOM") private String nom;
    @Column(name = "PRENOM") private String prenom;
    @Column(name = "CREATEDATE")@Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;
    @Column(name = "MODIFYDATE")@Temporal(javax.persistence.TemporalType.DATE)
    private Date modifyDate;

    public Medecins() {
        this.titre = "";
        this.nom = "";
        this.prenom = "";
        this.createDate = new Date(System.currentTimeMillis());
        this.modifyDate = null;
    }

    public Medecins(String titre, String nom, String prenom) {
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.createDate = new Date(System.currentTimeMillis());
        this.modifyDate = null;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getId() {
        return id;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTitre() {
        return titre;
    }




}
