package com.web.seek.domain;

import com.web.seek.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Entity
@Table
public class Board extends BaseTimeEntity{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    private BoardType boardType;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(Long id, String title, String subTitle, String content, BoardType boardType, User user){
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.user = user;
    }

    public void update(Board board){
        this.title = board.getTitle();
        this.subTitle = board.getSubTitle();
        this.content = board.getContent();
        this.boardType = board.getBoardType();
    }
}
