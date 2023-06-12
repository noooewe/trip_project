package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardFileDTO {

    private Long id;
    private String originalFileName;        //원본 파일 이름
    private String storedFileName;          //저장된 파일 이름
    private Long boardId;
}
