package org.example.springbootdeveloper.dto.response;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootdeveloper.entity.Menu;

@Data
@NoArgsConstructor
public class MenuResponseDto {
    @Nonnull
    private  Long id;
    @Nonnull
    private String name;
    @Nonnull
    private String description;
    @Nonnull
    private int price;
    @Nonnull
    private boolean isAvailable;
    @Nonnull
    private String category;
    private String size;

    public MenuResponseDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.description = menu.getDescription();
        this.price = menu.getPrice();
        this.isAvailable = menu.isAvailable();
        this.category = menu.getCategory();
        this.size = menu.getSize();
    }
}
