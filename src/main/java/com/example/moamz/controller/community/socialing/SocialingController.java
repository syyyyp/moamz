package com.example.moamz.controller.community.socialing;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingDetailDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingListDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.community.PostService;
import com.example.moamz.service.community.socialing.SocialingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/socialing")
@RequiredArgsConstructor
public class SocialingController {

    private final SocialingService socialingService;
    private final PostService postService;

    @GetMapping("/list")
    public String soclialingList(Model model, Criteria criteria) {
        criteria.setAmount(8);
        List<SocialingListDTO> socialList = socialingService.showSocialingPage(criteria);
        int total = socialingService.totalSocialing();

        Page page = new Page(criteria, total);

        model.addAttribute("page", page);
        model.addAttribute("socialList", socialList);
        System.out.println("socialList = " + socialList);
        return "/community/socialing/socialingList";
    }

    @GetMapping("/socialingDetail/{fgPostId}")
    public String socialingDetail(@PathVariable("fgPostId") Long fgPostId, Model model) {

        SocialingDetailDTO socialingDetail = socialingService.socialingDeatil(fgPostId);

        model.addAttribute("socialingDetail", socialingDetail);
        model.addAttribute("fgPostId", fgPostId);
        return "/community/socialing/socialingDetail";
    }

    @GetMapping("/socialingWrite")
    public String socialingWrite() {
        return "/community/socialing/socialingWrite";
    }

    @PostMapping("/socialingWrite")
    public String socialingWritePost(@ModelAttribute SocialingWriteDTO socialingWriteDTO,
                                     @RequestParam("postFile") MultipartFile postFile) throws IOException {

        Long sampleUser = 1L;

        PostDTO postDTO = new PostDTO();
        postDTO.setFgPostType("socialing");
        postDTO.setFgPostTitle(socialingWriteDTO.getFgPostTitle());
        postDTO.setFgUserCode(sampleUser);


        postService.writePost(postDTO);


        socialingWriteDTO.setFgPostId(postDTO.getFgPostId());
        socialingService.writeSocialing(socialingWriteDTO, postFile);


        return "redirect:/socialing/socialingDetail/" + postDTO.getFgPostId();
    }


}









