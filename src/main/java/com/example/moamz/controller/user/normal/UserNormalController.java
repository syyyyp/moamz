package com.example.moamz.controller.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalLoginDTO;
import com.example.moamz.domain.dto.user.normal.NormalSessionDTO;
import com.example.moamz.service.user.normal.UserNormalService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/normal")
public class UserNormalController {
    private final UserNormalService userNormalService;

    //get 요청처리, 로그인 페이지 반환
    @GetMapping("regular/userLogin")
    public String login(){
        return "user/regular/userLogin";
    }

    //post 요청 처리, 로그인 완료되면 메인페이지 반환
    @PostMapping("regular/userLogin")
    public RedirectView login(@RequestParam("fgUserId") String fgUserId,
                              @RequestParam("fgUserPassword") String fgUserPassword,
                              HttpSession session){  // HTTP 세션 객체 (사용자 세션 저장)
        log.info("로그인 시도 : {}", fgUserId);

        // 로그인 정보 확인 (아이디와 비밀번호를 서비스로 검증
        NormalSessionDTO loginInfo = userNormalService.findLoginInfo(fgUserId, fgUserPassword);
//        Long userCodeInfo = userNormalService.findId(fgUserId, fgUserPassword);

        // 로그인 정보가 없으면 (아이디나 비밀번호가 틀리면) 로그인 실패 처리
        if (loginInfo == null) {
            log.warn("로그인 실패 : 잘못된 아이디 또는 비밀번호");
            return new RedirectView("/user/regular/userLogin?error=true");  // 에러 메시지를 URL에 전달
        }

        // 로그인 성공 시 세션에 사용자 정보 저장 (fgUserId, fgUserCode)
        session.setAttribute("fgUserId", loginInfo.getFgUserId());
        session.setAttribute("fgUserCode", loginInfo.getFgUserCode());

        return new RedirectView("/main");
        //RedirectView는 클라이언트에게 HTTP 302 Redirect 응답을 보내고 클라이언트 새로운 URL로 이동하게 된다
        //특정 URL로 리다이렉트 시키기 위해 사용되며 주로 컨트롤러 메소드에서 리다이렉트 응답을 만들 때 사용된다
    }

    // 로그아웃 처리 (세션 무효화)
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate(); // 현재 세션을 무효화 (로그아웃)


        return new RedirectView("/main");   

//        return new RedirectView("/main");


    }
}
