package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.PostRequestDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Comment;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {


    private final PostRepository postRepository;

    public ResponseDto<PostResponseDto> createPost(PostRequestDto dto) {


        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();
        Post savedPost = postRepository.save(post);
        return ResponseDto.setSuccess("게시글 작성 성공", convertToPostResponseDto(savedPost));

    }



    public ResponseDto<PostResponseDto> getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다" + postId));
        postRepository.findById(postId);

        return ResponseDto.setSuccess("게시글을 성공적으로 찾았습니다.", convertToPostResponseDto(post));
    }

    public ResponseDto<List<PostResponseDto>> getAllPosts() {
        List<Post> post = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = post.stream()
                .map(this::convertToPostResponseDto)
                .collect(Collectors.toList());
        return ResponseDto.setSuccess("게시글 목록을 성공적으로 가져왔습니다.",postResponseDtos);

    }

    public ResponseDto<PostResponseDto> updatePost(Long postId, PostRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을수 없습니다." + postId));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(dto.getAuthor());

        Post updatedPost = postRepository.save(post);
        return ResponseDto.setSuccess("게시글을 성공적으로 수정했습니다.",convertToPostResponseDto(updatedPost));
    }

    public ResponseDto<Void> deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을수 없습니다." + postId));
        postRepository.deleteById(postId);

        return ResponseDto.setSuccess("게시글을 성공적으로 삭제하였습니다.", null);
    }

        private PostResponseDto convertToPostResponseDto (Post post){
        return new PostResponseDto (
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getComments()
                );

    }
}
