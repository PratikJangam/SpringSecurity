package com.coddingshutte.SecurityApp.SecurityApplication.dto;

import com.coddingshutte.SecurityApp.SecurityApplication.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long postId;

    private String title;

    private String description;

    private UserDto author;
}
