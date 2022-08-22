package com.ailo.zombie.controller;


import com.ailo.zombie.model.dto.BoardDTO;
import com.ailo.zombie.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/getBoard")
    ResponseEntity<BoardDTO> getBoard(){
        final BoardDTO boardDTO = boardService.findBoard();
        return new ResponseEntity<>(boardDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/editBoard/{id}")
    ResponseEntity<Void> updateBoard(@PathVariable int id, @RequestBody BoardDTO boardDTO){
        boardService.UpdateBoard(id, boardDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
