package org.encore.apartment.community.domain.post.service;

import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.*;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.CommentRepository;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private  final UserRepository userRepository;

    @Override
    @Transactional
    public void saveComment(CommentRequestDto commentRequestDto) {

        Optional<Post> optionalPost = postRepository.findById(commentRequestDto.getPostId());
        Optional<User> optionalUser = userRepository.findByUserIdx(commentRequestDto.getUserIdx());

        commentRepository.save(commentRequestDto.ToEntity(optionalPost.get(), optionalUser.get()));
    }

    //전체 댓글
    @Override
    public List<CommentResponseDto> getCommentList() {
        List<Comment> all = commentRepository.findAll();
        List<CommentResponseDto> commentDtoList = new ArrayList<>();
        for(Comment comment : all){
            if(comment.getCommentDeleteYn() == false){
                CommentResponseDto commentDto = CommentResponseDto.builder()
                        .commentIdx(comment.getCommentIdx())
                        .commentId(comment.getCommentId())
//                        .commentWriterId(comment.getCommentWriterId())
//                        .postId(comment.getPost().getPostId())
                        .userIdx(comment.getUser().getUserIdx())
                        .postId(comment.getPost().getPostId())
                        .commentContent(comment.getCommentContent())
                        .commentDate(comment.getCommentDate())
                        .commentDeleteYn(comment.getCommentDeleteYn())
                        .updatedAt(comment.getUpdatedAt())
                        .build();

                commentDtoList.add(commentDto);
            }

        }

        return commentDtoList;
    }

    // POST ID에 속하는 댓글만 출력 필요 (post Id는 long으로 받아온다 가정)
    @Override
    public List<CommentResponseDto> getCommentListByPostId(Long postId){
        List<Comment> all = commentRepository.findAllByPost(postRepository.findById(postId).get());
        List<CommentResponseDto> commentDtoList = new ArrayList<>();
        for(Comment comment : all){
            if(comment.getCommentDeleteYn() == false){
                CommentResponseDto commentDto = CommentResponseDto.builder()
                        .commentIdx(comment.getCommentIdx())
                        .commentId(comment.getCommentId())
//                        .commentWriterId(comment.getCommentWriterId())
//                        .postId(comment.getPost().getPostId())
                        .userIdx(comment.getUser().getUserIdx())
                        .postId(comment.getPost().getPostId())
                        .commentContent(comment.getCommentContent())
                        .commentDate(comment.getCommentDate())
                        .commentDeleteYn(comment.getCommentDeleteYn())
                        .updatedAt(comment.getUpdatedAt())
                        .build();

                commentDtoList.add(commentDto);
            }

        }

        return commentDtoList;
    }

    // userIdx에 해당하는 댓글들 출력
    @Override
    public List<CommentResponseDto> getCommentListByUserIdx(Long userIdx){
        List<Comment> all = commentRepository.findAllByUser(userRepository.findByUserIdx(userIdx).get());
        List<CommentResponseDto> commentDtoList = new ArrayList<>();
        for(Comment comment : all){
            if(comment.getCommentDeleteYn() == false){
                CommentResponseDto commentDto = CommentResponseDto.builder()
                        .commentIdx(comment.getCommentIdx())
                        .commentId(comment.getCommentId())
//                        .commentWriterId(comment.getCommentWriterId())
//                        .postId(comment.getPost().getPostId())
                        .userIdx(comment.getUser().getUserIdx())
                        .postId(comment.getPost().getPostId())
                        .commentContent(comment.getCommentContent())
                        .commentDate(comment.getCommentDate())
                        .commentDeleteYn(comment.getCommentDeleteYn())
                        .updatedAt(comment.getUpdatedAt())
                        .build();

                commentDtoList.add(commentDto);
            }

        }

        return commentDtoList;
    }




    @Transactional
    @Override
    public Long updateComment(Long commentIdx, CommentUpdateDto commentUpdateDto) {
        Optional<Comment> byId = commentRepository.findById(commentIdx);
        Comment comment = byId.get();

        comment.update(commentUpdateDto.getCommentContent());

        return commentIdx;
    }

    @Transactional
    @Override
    public Long deleteComment(Long commentIdx) {
        Optional<Comment> byId = commentRepository.findById(commentIdx);
        Comment comment = byId.get();

        comment.delete();

        return commentIdx;
    }
}
