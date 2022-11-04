package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {

    @Autowired
    IOperateurService operateurService;

    public void testAdd() {
        Operateur operateur = new Operateur("Mrad","Jamel","mot de passe");
        Operateur o = operateurService.addOperateur(operateur);
        log.info("Operatuer :" + o);
    }
}
