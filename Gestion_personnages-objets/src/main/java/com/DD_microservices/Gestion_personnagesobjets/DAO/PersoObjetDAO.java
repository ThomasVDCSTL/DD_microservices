package com.DD_microservices.Gestion_personnagesobjets.DAO;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;


import java.util.List;
public interface PersoObjetDAO {
    List<Personnages>findAll();
    Personnages findById(int id);
    Personnages save(Personnages personnage);
}
