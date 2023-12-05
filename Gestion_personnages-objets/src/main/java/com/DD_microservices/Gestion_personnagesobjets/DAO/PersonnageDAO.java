package com.DD_microservices.Gestion_personnagesobjets.DAO;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnageDAO extends JpaRepository<Personnage, Integer> {

    List<Personnage> findByTypeIn(String[] types);

}
