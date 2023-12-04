package com.DD_microservices.Gestion_game.DAO;

import com.DD_microservices.Gestion_game.model.Board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO extends JpaRepository<Board, Integer> {

    List<Board> findAll();
    Board findById(int id);
    void deleteById(int id);

    Board save(Board board);
}
