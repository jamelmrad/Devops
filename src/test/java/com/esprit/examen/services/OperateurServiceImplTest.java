package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {

    //maybe delete @SpringBoot test ???? !! check mail or classroom
    /** delete all comments before pushing code into github*/

    @Autowired
    IOperateurService operateurService;

    @Mock
    OperateurRepository operateurRepository;

    Operateur o = new Operateur("Mrad","Jamel","mot de passe");


    @Test
    void contextLoads() {

    }

    public void testRetrieveAll(){
        //List<Operateur>
        Operateur operateurUn = new Operateur("leo","messi","mot de passe");
        Operateur operateurDeux = new Operateur("ricardo","kaka","mot de passe");

        List<Operateur> list = new ArrayList<Operateur>();
        list.add(operateurUn);
        list.add(operateurDeux);

        when(operateurRepository.findAll()).thenReturn(list);

        //test
        //??
    }

    @Test()
    public void testAdd() {
        Operateur operateur = new Operateur("Mrad","Jamel","mot de passe");
        Operateur o = operateurService.addOperateur(operateur);
        log.info("Operatuer :" + o);
        Assertions.assertNotNull(o.getIdOperateur());
    }

    @Test()
    public void testDelete(){
        Operateur ex = mock(Operateur.class);

        /**
         *  Mockito.when(applicationService.removeById(10001L)).thenReturn("SUCCESS");
         *         mockMvc.perform(MockMvcRequestBuilders.delete("/applications", 10001L))
         *                 .andExpect(status().isOk());
         */


    }

    public void testUpdate(){
        //operateur
    }

    @Test()
    public void testRetrieve(){
        Mockito.when(operateurRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(o));
        Operateur operateur = operateurService.retrieveOperateur((long) 2);
        assertNotNull(operateur);
        log.info("get ===> " + operateur.toString());
    }
}
