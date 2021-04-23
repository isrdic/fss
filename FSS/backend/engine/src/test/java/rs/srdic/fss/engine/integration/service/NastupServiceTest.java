package rs.srdic.fss.engine.integration.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rs.srdic.fss.engine.dto.NastupDTO;
import rs.srdic.fss.engine.repository.IgracRepository;
import rs.srdic.fss.engine.repository.MestoRepository;
import rs.srdic.fss.engine.repository.UtakmicaRepository;
import rs.srdic.fss.engine.service.NastupService;
import rs.srdic.fss.engine.utils.HibernateTransactionUtil;
import rs.srdic.fss.model.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
public class NastupServiceTest {

//    @Autowired
//    private HibernateTransactionUtil hibernateTransactionUtil;
//
//    @Autowired
//    private NastupService nastupService;
//
//    @Autowired
//    private MestoRepository mestoRepository;
//
//    @Autowired
//    private IgracRepository igracRepository;
//
//    @Autowired
//    private UtakmicaRepository utakmicaRepository;
//
//    Mesto mesto;
//    Mesto mestoDB;
//    Igrac igrac;
//    Utakmica utakmica;
//
//    @BeforeEach
//    public void setUp() {
//
//        mesto = hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Mesto mesto = new Mesto();
//            mesto.setNaziv("Kikinda");
//            mesto.setPtt(23300);
//            return mestoRepository.save(mesto);
//        });
//
//        igrac = hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Igrac igrac = new Igrac();
//            igrac.setIme("Pjotr");
//            return igracRepository.save(igrac);
//        });
//
////        mestoDB = hibernateTransactionUtil.doInTransaction(entityManager -> {
////            mestoDB.addIgrac(igrac);
////            return mestoRepository.save(mestoDB);
////        });
//
//        utakmica = hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Utakmica utakmica = new Utakmica();
//            utakmica.setDatumOdigravanja(new Date());
//
//            return utakmicaRepository.save(utakmica);
//        });
//
//    }
//
//    @Test
//    public void nastupWorkflowTest() {
//
//        Nastup nastup = nastupService.saveOrUpdate(new NastupDTO(igrac.getIgracID(), utakmica.getUtakmicaID(), 1.98));
//        nastup = nastupService.getOne(new NastupID(igrac.getIgracID(), utakmica.getUtakmicaID()));
//        System.out.println();
//
//
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.out.println("Ende");
//    }


}
