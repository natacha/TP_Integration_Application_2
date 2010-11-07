/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Natacha
 */
public class MedecinsDataManager {
    
    public static EntityManager em;

    public MedecinsDataManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
        em = emf.createEntityManager();
    }

    public void insertMedecins(Medecins m) {
        if (em.find(Medecins.class, m.getId()) == null) {
           EntityTransaction transac = em.getTransaction();
           transac.begin();
           em.persist(m);
           transac.commit();
        }

    }

    public List<Medecins> getMedecins() {
        List<Medecins> listMedecins = null;
        Query q =  em.createQuery("select m from Medecins m");
        listMedecins = q.getResultList();
        return listMedecins;
    }

    public void updateMedecins(int id, String titre) {
        Medecins m = em.find(Medecins.class, id);
        if (m != null) {
            EntityTransaction transac = em.getTransaction();
            transac.begin();
            m.setTitre(titre);
            em.merge(m);
            transac.commit();
        }
    }

    public void deleteMedecins(int id) {
        Medecins m = em.find(Medecins.class, id);
        if (m != null) {
           EntityTransaction transac = em.getTransaction();
           transac.begin();
           em.remove(m);
           transac.commit();
        }
    }


    public String displayMedecins(List<Medecins> listMedecins) {
        StringBuilder sb = new StringBuilder();
        sb.append("<br/>");
        sb.append("<h2>Affichage des medecins</h2>");
        for (Medecins med : listMedecins) {
            sb.append(med.getTitre());
            sb.append(" ");
            sb.append(med.getNom());
            sb.append(" ");
            sb. append(med.getPrenom());
            sb.append("<br/>");
        }
        return new String(sb);
    }


}
