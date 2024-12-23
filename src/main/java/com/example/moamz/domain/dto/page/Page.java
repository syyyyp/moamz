package com.example.moamz.domain.dto.page;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode
public class Page {
    //페이지 세트 당 표시될 수
    private int pageCount; //3

    //페이지 세트의 시작 숫자
    private int startPage;  //1,4,7..

    //페이지 세트의 마지막 숫자
    private int endPage;

    //실제 가장 마지막 페이지
    private int realEnd;

    //이전 버튼 표시 여부
    private boolean prev;

    //다음 버튼 표시 여부
    private boolean next;

    //전체 게시글 수
    private int total;

    //화면에서 전달받은 page, amount를 저장하는 객체
    private Criteria criteria;

    private SocialCriteria socialCriteria;

    private EcoCertCriteria ecoCertCriteria;

    public Page(EcoCertCriteria ecoCertCriteria, int total) {
        this(ecoCertCriteria, total, 5);
    }

    public Page(EcoCertCriteria ecoCertCriteria, int total, int pageCount) {
        this.ecoCertCriteria = ecoCertCriteria;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(ecoCertCriteria.getPage() / (double)pageCount)) * pageCount;//현재 세트에서의 마지막 페이지
        this.startPage = endPage - pageCount + 1; //현재 세트에서의 첫번째 페이지

        //게시글 전체 수로 실제 마지막 페이지를 구한다
        this.realEnd =(int)(Math.ceil((double) total / ecoCertCriteria.getAmount()));

        //세트의 마지막 번호보다 실제 마지막 페이지가 작다면?
        if(realEnd < endPage){
            //세트의 마지막 번호를 실제 마지막 페이지로 교체한다
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;//현재 세트에서의 첫번째 페이지가 1보다 크면 이전버튼 표시
        this.next = endPage < realEnd;//현재 세트에서의 마지막 페이지가 실제마지막페이지 보다 작으면 다음버튼 표시
    }

    public Page(SocialCriteria socialCriteria, int total) {
        this(socialCriteria, total, 5);
    }

    public Page(SocialCriteria socialCriteria, int total, int pageCount) {
        this.socialCriteria = socialCriteria;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(socialCriteria.getPage() / (double)pageCount)) * pageCount;//현재 세트에서의 마지막 페이지
        this.startPage = endPage - pageCount + 1; //현재 세트에서의 첫번째 페이지

        //게시글 전체 수로 실제 마지막 페이지를 구한다
        this.realEnd =(int)(Math.ceil((double) total / socialCriteria.getAmount()));

        //세트의 마지막 번호보다 실제 마지막 페이지가 작다면?
        if(realEnd < endPage){
            //세트의 마지막 번호를 실제 마지막 페이지로 교체한다
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;//현재 세트에서의 첫번째 페이지가 1보다 크면 이전버튼 표시
        this.next = endPage < realEnd;//현재 세트에서의 마지막 페이지가 실제마지막페이지 보다 작으면 다음버튼 표시
    }
    // 생성자 직접 만든다.
    public Page(Criteria criteria, int total) {
        this(criteria, total, 5);
    }
    // 오버로딩
    public Page(Criteria criteria, int total, int pageCount) {
        this.criteria = criteria;//화면에서 현재 페이지와 페이지당 게시글수( amount)를 받는 객체
        this.total = total; //전체 게시글 수 
        this.pageCount = pageCount;//한세트에 표시될 페이지의 수,3개

        //현재 페이지를 기준으로 세트의 마지막 번호, 시작 번호를 구한다
        //ceil() : 올림 처리
        this.endPage = (int)(Math.ceil(criteria.getPage() / (double)pageCount)) * pageCount;//현재 세트에서의 마지막 페이지
        this.startPage = endPage - pageCount + 1; //현재 세트에서의 첫번째 페이지

        //게시글 전체 수로 실제 마지막 페이지를 구한다
        this.realEnd =(int)(Math.ceil((double) total / criteria.getAmount()));

        //세트의 마지막 번호보다 실제 마지막 페이지가 작다면?
        if(realEnd < endPage){
            //세트의 마지막 번호를 실제 마지막 페이지로 교체한다
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;//현재 세트에서의 첫번째 페이지가 1보다 크면 이전버튼 표시
        this.next = endPage < realEnd;//현재 세트에서의 마지막 페이지가 실제마지막페이지 보다 작으면 다음버튼 표시

    }
}
