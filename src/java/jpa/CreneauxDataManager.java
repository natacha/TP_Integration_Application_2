/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Natacha
 */
public class CreneauxDataManager {

    public static EntityManager em;

    public CreneauxDataManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
        em = emf.createEntityManager();
    }

    public void insertCreneaux(Creneaux cr)
    {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(cr);
        transac.commit();
    }

}
