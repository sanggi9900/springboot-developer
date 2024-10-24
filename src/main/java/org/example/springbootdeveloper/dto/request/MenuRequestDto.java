package org.example.springbootdeveloper.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class MenuRequestDto {
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private int price;
    @NonNull
    private boolean isAvailable;
    @NonNull
    private String category;
    private String size;
}
