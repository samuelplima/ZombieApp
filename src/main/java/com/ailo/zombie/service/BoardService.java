package com.ailo.zombie.service;

import com.ailo.zombie.model.dto.BoardDTO;

public interface BoardService {

    BoardDTO findBoard();

    void UpdateBoard(final int id, final BoardDTO boardDTO);

}
