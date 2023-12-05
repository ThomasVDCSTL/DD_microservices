package com.DD_microservices.Gestion_personnagesobjets.DAO;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Enemy.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyDAO extends JpaRepository<Enemy, Integer> {
}
