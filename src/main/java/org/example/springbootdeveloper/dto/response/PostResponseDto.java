package org.example.springbootdeveloper.dto.response;

import lombok.*;
import org.example.springbootdeveloper.entity.Comment;

import java.util.List;

@Data
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    // 해당 게시글의 댓글 리스트를 포함
    private List<Comment> comments;


}
