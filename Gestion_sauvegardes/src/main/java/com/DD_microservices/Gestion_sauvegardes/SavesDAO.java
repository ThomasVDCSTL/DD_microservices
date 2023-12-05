package com.DD_microservices.Gestion_sauvegardes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavesDAO extends JpaRepository<Save,Integer> {
    List<Save> findAllByPlayerOrderByDate(Integer id);
    Save findByPlayerAndSaveOrderByDate(int id_joueur,int id_save);
}
