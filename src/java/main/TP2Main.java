/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.Clients;
import jpa.ClientsDataManager;
import jpa.Creneaux;
import jpa.Medecins;
import jpa.MedecinsDataManager;
import jpa.Rv;
import jpa.RvDataManager;

/**
 *
 * @author baillif
 */
public class TP2Main {

    public static EntityManager em;

    public TP2Main()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
        em = emf.createEntityManager();
    }

    public String go(Date jour) throws ParseException{
            StringBuilder sb = new StringBuilder();
           Query q =  em.createQuery("select c.nom from Clients c where c.prenom = \'Jules\'");
           sb.append(q.getResultList());

           ClientsDataManager cdm = new ClientsDataManager();
           List<Clients> listClients = cdm.getClients();
           sb.append(cdm.displayClients(listClients));

           Clients c = new Clients("titi", "tata", "Mr");
           cdm.insertClients(c);

           cdm.updateClients(4, "PASSERAT");
          /* System.out.println(jour);*/
/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

           q = em.createQuery("select rdv from Rv rdv  where rdv.jour = '"+df.format(jour)+"'");*/
           //sb.append(q.getResultList());

           cdm.deleteClients(25);

           MedecinsDataManager mdm = new MedecinsDataManager();
           List<Medecins> listMed = mdm.getMedecins();
           sb.append(mdm.displayMedecins(listMed));

           Medecins m = new Medecins("Mr", "Dumou", "absent");
           mdm.insertMedecins(m);

           mdm.updateMedecins(5, "Mme");

           mdm.deleteMedecins(6);

           RvDataManager rdm = new RvDataManager();
           List<Rv> listRdv = rdm.getRvbyAll(jour);
           sb.append(rdm.display(listRdv));

           rdm.deleteRv(7);

           Creneaux crenx = new Creneaux(10,12,10,32);
           Rv rdv = new Rv(jour, c, crenx, m);
           rdm.insertRv(rdv);
           rdm.deleteRv(rdv.getId());
           listRdv = rdm.getRV();
           sb.append(rdm.display(listRdv));

           listRdv = rdm.getRvbyAll2(jour);
           sb.append(rdm.display(listRdv));

		
          return new String(sb);
    }
}
