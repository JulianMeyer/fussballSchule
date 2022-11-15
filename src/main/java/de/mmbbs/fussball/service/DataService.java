package de.mmbbs.fussball.service;

import de.mmbbs.fussball.Repository.*;
import de.mmbbs.fussball.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    MannschaftRepository mannschaftRepository;
    SchiriRepository schiriRepository;
    SpielerRepository spielerRepository;
    SpielRepository spielRepository;
    TrefferRepository trefferRepository;
    VertragRepository vertragRepository;

    public DataService(MannschaftRepository mannschaftRepository,
                       SchiriRepository schiriRepository,
                       SpielerRepository spielerRepository,
                       SpielRepository spielRepository,
                       TrefferRepository trefferRepository,
                       VertragRepository vertragRepository) {
        this.mannschaftRepository = mannschaftRepository;
        this.schiriRepository = schiriRepository;
        this.spielerRepository = spielerRepository;
        this.spielRepository = spielRepository;
        this.trefferRepository = trefferRepository;
        this.vertragRepository = vertragRepository;
    }

    public Treffer getTrefferById(int id) {
        return trefferRepository.findById(id);
    }

    public void saveTreffer(Treffer treffer) {
        trefferRepository.save(treffer);
    }

    public List<Schiri> getAllSchiri() {
        return schiriRepository.findAll();
    }

    public List<Spieler> getAllSpieler() {
        return spielerRepository.findAll();
    }

    public void saveSchiri(Schiri neuerSchiri) {
        schiriRepository.save(neuerSchiri);
    }

    public void saveSpieler(Spieler spieler) {
        spielerRepository.save(spieler);
    }

    public List<Mannschaft> getAllMannschaft() {
        return mannschaftRepository.findAll();
    }

    public void saveMannschaft(Mannschaft mannschaft) {
        mannschaftRepository.save(mannschaft);
    }

    public List<Vertrag> getAllVertrag() {
        return vertragRepository.findAll();
    }
}
