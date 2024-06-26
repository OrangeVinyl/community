package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostDeleteDto {

    private Long postId;

    private String postTitle;

    private String postContent;

    private Boolean postDeleteYn;

    private LocalDateTime updatedAt;

    @Builder
    public PostDeleteDto(Long postId, String postTitle, String postContent,Boolean postDeleteYn , LocalDateTime updatedAt) {
        this.postId = postId;
        this.postTitle= postTitle;
        this.postContent = postContent;
        this.postDeleteYn = postDeleteYn;
        this.updatedAt = updatedAt;

    }
}
