package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminIngEcoListDTO {
//  (진행중) 에코프로젝트 목록 DTO

    // 썸네일 보여주기
    private Long   fgPostFileId;           // 파일 ID
    private String fgPostFileRoot;         // 파일 경로
    private String fgPostFileName;        // 파일 이름
    private String fgPostFileUuid;        // 파일 UUID

    private String fgPostTitle;            // 에코 프로젝트 제목
    private int fgPostLikes;                // 에코 프로젝트 좋아요 수
    private LocalDateTime fgEcoStart;               // 에코 프로젝트 시작일
    private String fgEcoStartToChar;  // 에코 프젝 시작일 변환버전
    private LocalDateTime fgEcoEnd;                 // 에코 프로젝트 종료일
    private String fgEcoEndToChar;    // 에코 프젝 종료일 변화버전
    private String fgEcoPeriod;                    //에코 기간(몇일)
    private int fgEcoPoints;                 // 에코 프로젝트 지급될 포인트
    private String fgEcoInfo;                // 에코 프로젝트 소개
    private String fgCertInfo;              // 에코 프로젝트 인증사항
    private String fgEcoParticipation;        // 에코 프로젝트 참여횟수

    private String fgEcoStatus;             // 에코 프로젝트 종료 여부 (진행중: 1 / 종료: 0)
    private Long fgPostId;                  // 게시글 ID
    private Long fgProjectId;               //프로젝트ID
    private String fgPostType; //글 종류
    private String fgPostCreatedAt; //글 작성시간
    private Long fgUserCode; //작성자 회원번호





}
