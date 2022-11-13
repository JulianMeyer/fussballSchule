package de.mmbbs.fussball.service;

import de.mmbbs.fussball.Repository.TrefferRepository;
import de.mmbbs.fussball.model.Treffer;
import org.springframework.stereotype.Service;

@Service
public class TrefferService {
    TrefferRepository trefferRepository;

    public TrefferService(TrefferRepository trefferRepository) {
        this.trefferRepository = trefferRepository;
    }

    public Treffer getById(int id){
        return trefferRepository.findById(id);
    }
}
