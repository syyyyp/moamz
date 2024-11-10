package com.example.moamz.mapper.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerSessionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SellerLoginMapper {

    Optional<Long> selectId(@Param("fgUserId")String fgUserId, @Param("fgUserPassword") String fgUserPassword);

    Optional<SellerSessionDTO> selectLoginInfo(@Param("fgUserId") String fgUserId,

                                                   @Param("fgUserPassword") String fgUserPassword);
}