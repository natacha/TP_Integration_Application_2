/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

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

    public List<Rv> getRvbyAll(String jour) {
        List<Rv> listRv = null;
        Query q =  em.createQuery("select rdv from Rv rdv  where rdv.createDate = \'"+jour+"\'");
        return listRv;

    }

    public void insertRv(Rv rv)
    {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(rv);
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
        nRv.setJour(newJour);
        transac.commit();
    }

    public void deleteRv(int rId)
    {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        Rv nRv = em.find(Rv.class, rId);
        em.remove(nRv);
        transac.commit();
    }

    public String display(List<Rv> listRv)
    {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");

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
