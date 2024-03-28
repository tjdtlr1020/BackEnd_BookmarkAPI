package com.bookmarker.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {
    // @NotBlank = trim() + @NotEmpty
    // @NotBlank는 공백도 허용하지않는다

    @NotEmpty(message = "Title should not be empty")
    private String title;

    @NotBlank(message = "Url should not be empty")
    private String url;
}