package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {
    @Mock
    OperateurRepository operateurRepository;
    @InjectMocks
    OperateurServiceImpl operateurService;

    Operateur o = new Operateur("Mrad","Jamel","mot de passe");
    List<Operateur> operateurList =  new ArrayList<Operateur>(){
        {
            add(new Operateur("Mrad","Jamel","mot de passe"));
            add(new Operateur("Mrad","Jamel","mot de passe"));
        }
    };


    @Test()
    public void testRetrieveAll(){
        Mockito.when(operateurRepository.findAll()).thenReturn(operateurList);
        List<Operateur> lo = operateurService.retrieveAllOperateurs();
        assertEquals(2,lo.size());
        log.warn("LIST OF OPERAOTRS : ");
        for (Operateur x:   lo
             ) {
            log.info(x.toString());
        }
    }

    @Test()
    public void testAdd() {
        Mockito.when(operateurRepository.save(o)).thenReturn(o);
        Operateur lf = operateurService.addOperateur(o);
        log.info("OPERATEUR =====> : " + lf.toString());
        assertNotNull(lf);
    }

    @Test()
    public void testDelete(){
        Mockito.doNothing().when(operateurRepository).deleteById(Mockito.anyLong());
        operateurService.deleteOperateur(3L);
        Mockito.verify(operateurRepository, Mockito.times(1)).deleteById(3L);
        log.info("DELETED SUCCFULLY !");
    }

    @Test()
    public void testUpdate(){
        Mockito.when(operateurRepository.save(o)).thenReturn(o);
        Operateur f = operateurService.updateOperateur(o);
        assertNotNull(f);
        log.info(f.toString());
    }

    @Test()
    public void testRetrieve(){
       Mockito.when(operateurRepository.findById(Mockito.anyLong()))
               .thenReturn(Optional.of(o));
       Operateur operateur = operateurService.retrieveOperateur(2L);
       assertNotNull(operateur);
       log.info(operateur.toString());
    }
}
