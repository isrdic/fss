package rs.srdic.fss.engine.integration.repository;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rs.srdic.fss.engine.repository.*;
import rs.srdic.fss.engine.utils.HibernateTransactionUtil;
import rs.srdic.fss.model.Igrac;
import rs.srdic.fss.model.Mesto;
import rs.srdic.fss.model.Utakmica;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Ignore
@SpringBootTest
public class IgracRepositoryTest {

    @Autowired
    private HibernateTransactionUtil hibernateTransactionUtil;

    @Autowired
    private IgracRepository igracRepository;

    @Autowired
    private MestoRepository mestoRepository;

    @Autowired
    private UtakmicaRepository utakmicaRepository;

    @Autowired
    private NastupRepository nastupRepository;

    @Autowired
    private KlubRepository klubRepository;

    @Autowired
    private TakmicenjeRepository takmicenjeRepository;

//    @Test
//    public void saveIgracSaMestomTest() {
//        Mesto mesto = new Mesto();
//        mesto.setNaziv("Beograd");
//        mesto.setPtt(11000);
//        mesto = mestoRepository.save(mesto);
//        Igrac igrac = new Igrac();
//        igrac.setIme("Ivan"); //Igrac.builder().ime("Ivan").prezime("Srdic").datumRodjenja(new Date()).build();
//        mesto.addIgrac(igrac);
//        igrac = igracRepository.save(igrac);
//        assertEquals(1, igracRepository.findAll().size());
//        igracRepository.deleteById(igrac.getIgracID());
//        assertEquals(0, igracRepository.findAll().size());
//    }

//    @Test
//    public void saveNastupTest() {
//
//        Mesto mestoDB = hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Mesto mesto = new Mesto();
//            mesto.setNaziv("Beograd");
//            mesto.setPtt(11000);
//            return mestoRepository.save(mesto);
//        });
//
//
//
//        hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Mesto mesto = new Mesto();
//            mesto.setNaziv("Beograd");
//            mesto.setPtt(11000);
//            return mestoRepository.save(mesto);
//        });
//
//        Igrac igracDB = hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Igrac igrac = new Igrac();
//            igrac.setIme("Ivan");
//            return igracRepository.save(igrac);
//        });
//
//        Mesto mestoDB2 = hibernateTransactionUtil.doInTransaction(entityManager -> {
//            mestoDB.addIgrac(igracDB);
//            return mestoRepository.save(mestoDB);
//        });
//
//        hibernateTransactionUtil.doInTransaction(entityManager -> {
//            Utakmica utakmica = new Utakmica();
//            utakmica.setDatumOdigravanja(new Date());
//
//            utakmica.dodajIgraca(igracRepository.findById(igracDB.getIgracID()).get(), 4.11);
//            utakmica = utakmicaRepository.save(utakmica);
//
//            utakmica = utakmicaRepository.findById(utakmica.getUtakmicaID()).get();
//
//            assertEquals(1, nastupRepository.findAll().size());
//        });
//
//    }

//    @AfterEach
//    public void tearDown() {
//        igracRepository.deleteAll();
//        utakmicaRepository.deleteAll();
//        nastupRepository.deleteAll();
//    }

}
