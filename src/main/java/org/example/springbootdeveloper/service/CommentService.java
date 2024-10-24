package org.example.springbootdeveloper.service;

import org.example.springbootdeveloper.dto.request.CommentRequestDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Comment;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.CommentRepository;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public ResponseDto<CommentResponseDto> createComment(CommentRequestDto dto) {
        Post post = postRepository.findById(dto.getPostId()) //  Post에서 postId를 받아온다
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다" + dto.getPostId()));

        Comment comment = Comment.builder()   // builder 체인으로 받아온다
                .post(post)
                .commenter(dto.getCommenter())
                .content(dto.getContent())
                .build();

        Comment savedComment = commentRepository.save(comment);  // 성공하면 나온다
        return ResponseDto.setSuccess("성공했다",convertToCommentResponseDto(savedComment));
    }

    public ResponseDto<List<CommentResponseDto>> getCommentsByPost(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentResponseDto> responseDtos = comments.stream()
                .map(this::convertToCommentResponseDto)
                .collect(Collectors.toList());
        return ResponseDto.setSuccess("댓글 목록을 성공적으로 가져왔습니다.",responseDtos);
    }



    public ResponseDto<CommentResponseDto> updateComment(Long commentId, String newContent) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다: " + commentId));

       comment.setContent(newContent);

       Comment updatedCommnet = commentRepository.save(comment);

        return ResponseDto.setSuccess("댓글이 성공적으로 업데이트 되었습니다.", convertToCommentResponseDto(updatedCommnet));
    }


    public ResponseDto<Void> deleteComment(Long commentId) {
       Comment comment = commentRepository.findById(commentId)
               .orElseThrow(() -> new IllegalArgumentException("삭제할 댓글을 찾을 수 없습니다" + commentId));
    commentRepository.deleteById(commentId);

    return ResponseDto.setSuccess("댓글이 성곡적으로 삭제하였습니다", null);
    }

    private CommentResponseDto convertToCommentResponseDto(Comment comment){
        return new CommentResponseDto(
                comment.getId(),
                comment.getPost().getId(),
                comment.getCommenter(),
                comment.getContent()
        );
    }


}
