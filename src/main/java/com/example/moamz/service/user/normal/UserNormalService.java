package com.example.moamz.service.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalLoginDTO;
import com.example.moamz.domain.dto.user.normal.NormalSessionDTO;
import com.example.moamz.mapper.user.normal.UserNormalMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserNormalService {
    private final UserNormalMapper userNormalMapper;


    // 유저 번호 찾기 메소드
    public Long findId(String fgUserId, String fgUserPassword) {
        return userNormalMapper.selectId(fgUserId, fgUserPassword)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원"));
    }

    public NormalSessionDTO findLoginInfo(String fgUserId, String fgUserPassword) {
        return userNormalMapper.selectLoginInfo(fgUserId, fgUserPassword)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 정보"));
    }

    //아이디, 비밀번호 확인
    public String idPasswordCheck(String fgUserId, String fgUserPassword) {
        return userNormalMapper.idPasswordCheck(fgUserId,fgUserPassword)
                .orElse(null);
    }

}
