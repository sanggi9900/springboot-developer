package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.request.PostRequestDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // view로 받지않고 바로 받는다
@RequestMapping("/api/posts")
public class PostController {

    @Autowired // 의존성 주입
    private PostService postService;

    // CRUD 기능 명시
    @PostMapping
    public ResponseDto<PostResponseDto> createPost(@RequestParam PostRequestDto dto){
        return postService.createPost(dto);
    }

    @GetMapping
    public ResponseDto<List<PostResponseDto>> getAllPosts() {
        return postService.getAllPosts();
    }


    @GetMapping("/{postId}")
    public ResponseDto<PostResponseDto> getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseDto<PostResponseDto> updatePost(
            @PathVariable Long postId,
            @RequestBody PostRequestDto dto) {
        return postService.updatePost(postId, dto);
    }

    @DeleteMapping("/{postId}")
    public ResponseDto<Void> deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }

}
