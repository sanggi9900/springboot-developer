package org.example.springbootdeveloper.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
}
