package com.portfolio.trip_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardGoodDTO {

    private Long id;
    private int boardGood;
    private int boardHate;
    private Long boardId;
}
