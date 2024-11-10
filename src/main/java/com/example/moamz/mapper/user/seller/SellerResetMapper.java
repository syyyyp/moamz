package com.example.moamz.mapper.user.seller;


import com.example.moamz.domain.dto.user.seller.SellerResetPasswordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SellerResetMapper {

    Optional<String> selectPassword(@Param("fgUserId") String fgUserId,
                                    @Param("fgSellerPhone") String fgNormalPhone);

    //비밀번호 변경
    int updatePassword(SellerResetPasswordDTO sellerResetPasswordDTO);
}