package com.chobo.book.springboot.web;


import com.chobo.book.springboot.service.posts.PostsService;
import com.chobo.book.springboot.web.dto.PostsSaveRequestDto;
import com.chobo.book.springboot.web.dto.PostsResponseDto;
import com.chobo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    
    //게시글을 저장하는 메서드
    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }
    
    //게시글을 수정하는 메서드
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    
    //게시글을 조회하는 메서드
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    //게시글을 삭제하는 메서드
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
