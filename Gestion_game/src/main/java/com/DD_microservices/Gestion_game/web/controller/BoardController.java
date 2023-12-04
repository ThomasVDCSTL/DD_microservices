package com.DD_microservices.Gestion_game.web.controller;

import com.DD_microservices.Gestion_game.DAO.BoardDAO;
import com.DD_microservices.Gestion_game.model.Board.Board;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private BoardDAO boardList;

    public BoardController(BoardDAO boardList) {
        this.boardList = boardList;
    }

    @GetMapping(value = "/boards")
    public List<Board> getBoardList() {
        return boardList.findAll();
    }

    @GetMapping(value = "/board/{id}")
    public Board getBoard(@PathVariable int id) {
        return boardList.findById(id);
    }

    @PostMapping(value = "/boards")
    public void addBoard(@RequestBody Board board) {
        boardList.save(board);
    }

    @DeleteMapping(value = "/board/{id}")
    public void deleteBoard(@PathVariable int id) {
        if (boardList.findById(id) != null) {
            boardList.deleteById(id);
        }

    }


}
