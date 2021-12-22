package com.learn.pojo;

import com.learn.validation.ValidationBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NotNull(message = "id cannot be null", groups = ValidationBook.class)
    @Size(message = "id min size must not less than 1", min=1, groups = ValidationBook.class)
    private String id;

    @NotNull(message = "name cannot be null")
    @Size(min=1)
    private String name;

    @NotNull(message = "author cannot be null")
    @Size(min=1)
    private String author;

    @NotNull(message = "email cannot be null")
    @Email
    @Size(min=1)
    private String email;
}
