package com.ailo.zombie.service.impl;

import com.ailo.zombie.model.dto.BoardDTO;
import com.ailo.zombie.model.entities.Board;
import com.ailo.zombie.exception.NotFoundException;
import com.ailo.zombie.repository.BoardRepository;
import com.ailo.zombie.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.ailo.zombie.helper.BoardHelper.boardBuilder;
import static com.ailo.zombie.helper.BoardHelper.boardDTOBuilder;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardDTO findBoard() {
        final Board board = boardRepository.findAll().stream().findFirst().orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, " Board Not Found!"));
        return boardDTOBuilder(board);
    }

    @Override
    public void UpdateBoard(final int id, final BoardDTO boardDTO) {
       final Board board = boardRepository.findById(id).orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Id Not Found!"));
       boardRepository.save(boardBuilder(board, boardDTO));
    }
}
