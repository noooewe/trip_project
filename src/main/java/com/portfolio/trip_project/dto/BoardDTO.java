package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardDTO {

    private Long id;
    private String boardTitle;              //게시글 제목
    private String boardPass;               //게시글 비밀번호
    private String boardWriter;             //게시글 작성자
    private String boardContents;           //게시글 제목
    private int boardHits;                  //게시글 조회수
    private int fileAttached;               //게시글 파일 업로드 여부
    private List<MultipartFile> boardFile;  //게시글 파일
    private int commentShow;                //게시글 댓글수
}
