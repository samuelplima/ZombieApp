package com.ailo.zombie.helper;

import com.ailo.zombie.model.dto.BoardDTO;
import com.ailo.zombie.model.entities.Board;

public class BoardHelper {

    public static Board boardBuilder (final Board board, final BoardDTO boardDTO){
        return Board.builder()
                .id(board.getId())
                .gridPositionY(boardDTO.getGridPositionY())
                .gridPositionX(boardDTO.getGridPositionX())
                .build();
    }

    public static BoardDTO boardDTOBuilder (final Board board){
        return BoardDTO.builder()
                .gridPositionY(board.getGridPositionY())
                .gridPositionX(board.getGridPositionX())
                .build();
    }

}
