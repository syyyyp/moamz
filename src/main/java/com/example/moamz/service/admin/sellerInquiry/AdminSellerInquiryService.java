package com.example.moamz.service.admin.sellerInquiry;

import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryListDTO;
import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.admin.sellerInquiry.AdminSellerInquiryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AdminSellerInquiryService {
    private final AdminSellerInquiryMapper adminSellerInquiryMapper;

    //판매자 문의 목록 보여주기
    public List<AdminSellerInquiryListDTO> findInquiryList(){
        return adminSellerInquiryMapper.selectInquiryList();
    }

    //판매자회원 특정 문의글 상세보기
    public AdminSellerInquiryDetailDTO findInquiryDetail(Long fgPostId, Long fgUserCode){
        return adminSellerInquiryMapper.selectUserInquiryDetailById(fgPostId).orElseThrow(()-> new IllegalStateException("유효하지 않은 게시물입니다."));
    }

    //판매자 문의글 답변상태 변경시키기
    public void updateStatusBtn(Long fgPostId){
        adminSellerInquiryMapper.changeStatusBtn(fgPostId);
    }

    //판매자문의 글 총갯수 구하기
    public int findSellerInquiryTotal(){
        return adminSellerInquiryMapper.selectSellerInquiryTotal();
    }

    //모든 판매자문의 목록 페이지 보기 (페이지네이션 o)
    public List<AdminSellerInquiryListDTO> findAllSellerInquiryPage(Criteria criteria){
        return adminSellerInquiryMapper.selectAllSellerInquiryPage(criteria);
    }

}
