package com.DD_microservices.Gestion_joueurs.Dao;

import org.springframework.stereotype.Repository;
import com.DD_microservices.Gestion_joueurs.Model.JoueurData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface joueurDao extends JpaRepository<JoueurData, Integer> {
    JoueurData findByGamerName(String name);

}
