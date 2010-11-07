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
@Table(name = "Creneaux")
public class Creneaux {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
        @Column (name="HDEBUT") private int hdebut;
        @Column (name="MDEBUT") private int mdebut;
        @Column (name="HFIN") private int hfin;
        @Column (name="MFIN") private int mfin;
        @Column (name="CREATEDATE")@Temporal(javax.persistence.TemporalType.DATE)
        private Date createDate;
        @Column (name="MODIFYDATE")@Temporal(javax.persistence.TemporalType.DATE)
        private Date modifyDate;

        public Creneaux() {
        }

        

        public Creneaux(int hdebut, int mdebut, int hfin, int mfin) {
            this.hdebut = hdebut;
            this.mdebut = mdebut;
            this.hfin = hfin;
            this.mfin = mfin;
            this.createDate = new Date(System.currentTimeMillis());
            this.modifyDate = null;
        }

    public Date getCreateDate() {
        return createDate;
    }

    public int getHdebut() {
        return hdebut;
    }

    public int getHfin() {
        return hfin;
    }

    public int getId() {
        return id;
    }

    public int getMdebut() {
        return mdebut;
    }

    public int getMfin() {
        return mfin;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setHdebut(int hdebut) {
        this.hdebut = hdebut;
    }

    public void setHfin(int hfin) {
        this.hfin = hfin;
    }

    public void setMdebut(int mdebut) {
        this.mdebut = mdebut;
    }

    public void setMfin(int mfin) {
        this.mfin = mfin;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

        

}

