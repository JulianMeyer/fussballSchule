package de.mmbbs.fussball.service;

import de.mmbbs.fussball.Repository.*;
import de.mmbbs.fussball.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void saveTreffer(List<Treffer> trefferList) {
        trefferRepository.saveAll(trefferList);
    }

    public void saveVertrag(Vertrag vertrag) {
        vertragRepository.save(vertrag);
    }

    public List<Spiel> getAllSpiel() {
        return spielRepository.findAll();
    }

    public void saveSpiel(Spiel spiel) {
        spielRepository.save(spiel);
    }

    public Optional<Mannschaft> getMannschaft(Mannschaft mannschaft) {
        return mannschaftRepository.findById((long) mannschaft.getId());
    }

    public void deleteMannschaft(Mannschaft mannschaft) {
        mannschaftRepository.delete(mannschaft);
    }

    public void deleteSchiri(Schiri schiri) {
        schiriRepository.delete(schiri);
    }

    public void deleteVertrag(Vertrag vertrag) {
        vertragRepository.delete(vertrag);
    }

    public void deleteSpieler(Spieler spieler) {
        spielerRepository.delete(spieler);
    }

    public void deleteSpiel(Spiel spiel) {
        spielRepository.delete(spiel);
    }
}
