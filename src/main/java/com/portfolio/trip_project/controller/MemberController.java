package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/save")
    public String saveForm() {
        return "memberPages/memberSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "index";
    }

    @PostMapping("/userName-check")
    public ResponseEntity userNameCheck(@RequestBody MemberDTO memberDTO) {
        boolean result = memberService.userNameCheck(memberDTO.getMemberUserName());
        if(result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
