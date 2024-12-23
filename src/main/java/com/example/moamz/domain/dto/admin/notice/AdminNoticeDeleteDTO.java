package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminNoticeDeleteDTO {
//    공지사항 글 삭제하기
    private Long fgPostId; // 게시글 ID
    private Long fgUserCode;    // 글 작성자 회원번호
}
