package com.DD_microservices.Gestion_personnagesobjets.DAO;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
public interface PersoObjetDAO extends JpaRepository<Personnages , Integer> {
    /*List<Personnages>findAll();
    Personnages findById(int id);
    Personnages save(Personnages personnage);
    Personnages delete(int id );*/
}
