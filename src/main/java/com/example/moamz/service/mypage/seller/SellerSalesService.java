package com.example.moamz.service.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.domain.dto.mypage.seller.SalesDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.SalesListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.mypage.seller.SellerSalesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SellerSalesService {
    private final SellerSalesMapper sellerSalesMapper;

    // 판매 목록 가져오는 메서드 (페이지네이션X)
    public List<SalesListDTO> findCheckOrder(Long businessId) {
        return sellerSalesMapper.selectCheckOrder(businessId);
    }
    public List<SalesListDTO> findReadyToPickUp(Long businessId) {
        return sellerSalesMapper.selectReadyToPickup(businessId);
    }
    public List<SalesListDTO> findCompletePickup(Long businessId) {
        return sellerSalesMapper.selectCompletePickup(businessId);
    }

    // 판매 목록 가져오는 메서드 (페이지네이션O)
    public List<SalesListDTO> findCheckOrderAll(@Param("criteria") Criteria criteria, @Param("businessId") Long businessId) {
        return sellerSalesMapper.selectCheckOrderAll(criteria, businessId);
    }
    public List<SalesListDTO> findReadyToPickUpAll(@Param("criteria") Criteria criteria, @Param("businessId") Long businessId) {
        return sellerSalesMapper.selectReadyToPickupAll(criteria, businessId);
    }
    public List<SalesListDTO> findCompletePickupAll(@Param("criteria") Criteria criteria, @Param("businessId") Long businessId) {
        return sellerSalesMapper.selectCompletePickupAll(criteria, businessId);
    }

    // 픽업 상태별 주문 건수 반환하는 메서드
    public int findCheckOrderTotal(Long businessId) {
        return sellerSalesMapper.selectCheckOrderTotal(businessId);
    }
    public int findReadyToPickupTotal(Long businessId) {
        return sellerSalesMapper.selectReadyToPickupTotal(businessId);
    }
    public int findCompletePickupTotal(Long businessId) {
        return sellerSalesMapper.selectCompletePickupTotal(businessId);
    }

    // 픽업 상태 변경 메서드
    public void updateStatusReadyToPickup(Long orderId) {
        sellerSalesMapper.modifyStatusReadyToPickup(orderId);
    }
    public void updateStatusCompletePickup(Long orderId) {
        sellerSalesMapper.modifyStatusCompletePickup(orderId);
    }

    // 판매 상세내역 메서드
    public SalesDetailDTO findSalesDetail(Long orderId) {
        return sellerSalesMapper.selectSalesDetail(orderId)
                .orElseThrow(() -> new IllegalStateException("❌❌❌유효하지 않은 주문입니다."));
    }
}
