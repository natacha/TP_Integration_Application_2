/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author boubilix
 */

package jpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Natacha
 */
@Entity
@Table(name = "RV")
public class Rv {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
        @Column (name="JOUR")@Temporal(javax.persistence.TemporalType.DATE)
        private Date jour;
        @ManyToOne
        @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
        private Clients client;
        @ManyToOne
        @JoinColumn(name = "ID_CRENEAU", referencedColumnName = "ID")
        private Creneaux creneau;
        @ManyToOne
        @JoinColumn(name = "ID_MEDECIN", referencedColumnName = "ID")
        private Medecins medecin;
        @Column (name="CREATEDATE")@Temporal(javax.persistence.TemporalType.DATE)
        private Date createDate;
        @Column (name="MODIFYDATE")@Temporal(javax.persistence.TemporalType.DATE)
        private Date modifyDate;

        public Rv() {
        }

        public Rv(Date jour, Clients client, Creneaux creneau, Medecins medecin) {
            this.jour = jour;
            this.client = client;
            this.creneau = creneau;
            this.medecin = medecin;
            this.createDate = new Date(System.currentTimeMillis());
            this.modifyDate = null;
        }

        
        public int getId ()
        {
                return id;
        }

        public Date getJour ()
        {
                return jour;
        }

        public Clients getClient ()
        {
                return client;
        }

    public Medecins getMedecin() {
        return medecin;
    }


        public Creneaux getCreneau ()
        {
                return creneau;
        }

        public Date getCreateDate ()
        {
                return createDate;
        }

        public Date getModifyDate ()
        {
                return modifyDate;
        }

    public void setClient(Clients client) {
        this.client = client;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCreneau(Creneaux creneau) {
        this.creneau = creneau;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public void setMedecin(Medecins medecin) {
        this.medecin = medecin;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

}
