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
public class ClientsDataManager {

    public static EntityManager em;

    public ClientsDataManager()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
        em = emf.createEntityManager();
    }

    public void insertClients(Clients c) {
        if (em.find(Clients.class, c.getId()) == null) {
            EntityTransaction transac = em.getTransaction();
            transac.begin();
            em.persist(c);
            transac.commit();
        }

    }

    public List<Clients> getClients() {
        List<Clients> listClients = null;
        Query q =  em.createQuery("select c from Clients c");
        listClients = q.getResultList();
        return listClients;
    }

    public void updateClients(int id, String nom) {
        Clients c = em.find(Clients.class, id);
        if (c != null) {
            EntityTransaction transac = em.getTransaction();
            transac.begin();
            c.setNom(nom);
            em.merge(c);
            transac.commit();
        }
    }

    public void deleteClients(int id) {
        Clients c = em.find(Clients.class, id);
        if (c != null) {
            EntityTransaction transac = em.getTransaction();
            transac.begin();
            em.remove(c);
            transac.commit();
        }
    }


    public String displayClients(List<Clients> listClients) {
        StringBuilder sb = new StringBuilder();
        sb.append("<br/>");
        sb.append("<h2>Affichage des clients</h2>");
        for (Clients clt : listClients) {
            sb.append(clt.getTitre());
            sb.append(" ");
            sb.append(clt.getNom());
            sb.append(" ");
            sb. append(clt.getPrenom());
            sb.append("<br/>");
        }
        return new String(sb);
    }

}
