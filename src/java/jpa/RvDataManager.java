/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RvDataManager {

    public static EntityManager em;

    public RvDataManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
        em = emf.createEntityManager();
    }

    public List<Rv> getRvbyAll(Date jour) {
        List<Rv> listRv = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(jour + " " + df.format(jour));
        Query q =  em.createQuery("select rdv from Rv rdv  where rdv.jour = \'"+df.format(jour)+"\'");
        listRv = q.getResultList();
        return listRv;

    }

    public List<Rv> getRvbyAll2(Date jour) {
        List<Rv> listRv = null;
        Query q =  em.createQuery("select rdv from Rv rdv  where rdv.jour = ?1");
        q = q.setParameter(1, jour);
        listRv = q.getResultList();
        return listRv;
    }

    public void insertRv(Rv rv)
    {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(rv);
        em.persist(rv.getCreneau());
        transac.commit();
    }

    public List<Rv> getRV()
    {
        List<Rv> listRv = null;
        Query q = em.createQuery("select rdv from Rv rdv");
        listRv = q.getResultList();
        return listRv;
    }

    public void updateRv(int rId, Date newJour)
    {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        Rv nRv = em.find(Rv.class, rId);
        if (nRv != null) {
            nRv.setJour(newJour);
        }
        transac.commit();
    }

    public void deleteRv(int rId)
    {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        Rv nRv = em.find(Rv.class, rId);
        if (nRv != null) {
            em.remove(nRv);
            Creneaux crenx = em.find(Creneaux.class, nRv.getCreneau().getId());
            if (crenx != null) {
                em.remove(crenx);
            }
        }
        transac.commit();
    }

    public String display(List<Rv> listRv)
    {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");

        sb.append("<h2>Affichage des rendez-vous</h2>");

        for(int i = 0; i < listRv.size(); i++)
        {
            sb.append(listRv.get(i).getClient().getTitre()).append(" ").append(listRv.get(i).getClient().getNom()).append(" ").append(listRv.get(i).getClient().getPrenom());
            sb.append(" a rendez vous le ");
            sb.append(df.format(listRv.get(i).getJour()));
            sb.append(" de ");
            sb.append(listRv.get(i).getCreneau().getHdebut()).append(":").append(listRv.get(i).getCreneau().getMdebut());
            sb.append(" à ");
            sb.append(listRv.get(i).getCreneau().getHfin()).append(":").append(listRv.get(i).getCreneau().getMfin());
            sb.append(" avec ");
            sb.append(listRv.get(i).getMedecin().getTitre()).append(" ").append(listRv.get(i).getMedecin().getNom()).append(" ").append(listRv.get(i).getMedecin().getPrenom());
            sb.append("<br/>");
        }

        return new String(sb);
    }
}
