package com.DD_microservices.Gestion_personnagesobjets.DAO;

import com.DD_microservices.Gestion_personnagesobjets.Objects.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetDAO extends JpaRepository<Item, Integer> {
}
