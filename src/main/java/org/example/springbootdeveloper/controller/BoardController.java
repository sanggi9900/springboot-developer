package org.example.springbootdeveloper.controller;


import org.example.springbootdeveloper.dto.BoardDto;
import org.example.springbootdeveloper.service.BoardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 테이블 목록 조회
    @GetMapping
    public List<BoardDto> getAllBoards() {
        return boardService.getAllBoards();
    }

    // 테이블 단건 조회
    @GetMapping("{id}")
    public BoardDto getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    // 테이블 등록
    @PostMapping
    public BoardDto createBoard(@RequestBody BoardDto boardDto) {
    return boardService.createBoard(boardDto);
    }

    // 테이블 수정
    @PutMapping("/{id}")
    public BoardDto updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){
    return boardService.updateBoard(id, boardDto);
    }

    // 테이블 삭제
    @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
    boardService.deleteBoard(id);
    return ResponseEntity.noContent().build();
}
}