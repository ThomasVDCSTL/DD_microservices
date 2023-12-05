package com.DD_microservices.Gestion_personnagesobjets.DAO;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnageDAO extends JpaRepository<Personnage, Integer> {


}
