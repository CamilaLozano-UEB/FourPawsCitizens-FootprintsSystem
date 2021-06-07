package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Case;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.CaseRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.CaseRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases.CasePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaseService {

    private CaseRepository caseRepository;


    public String saveCase(CasePOJO casePOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        caseRepository = new CaseRepositoryImpl(entityManager);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date create_at = null;
        try {
            create_at = format.parse(casePOJO.getCreated_at());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Case newcase = new Case(casePOJO.getCase_id(),create_at,casePOJO.getType(),casePOJO.getDescription());
        String message = caseRepository.save(newcase);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

}