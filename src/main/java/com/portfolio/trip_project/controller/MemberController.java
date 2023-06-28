package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/login")
    public String loginForm() {
        return "memberPages/memberLogin";
    }

    @PostMapping("/login")
    public String memberLogin(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult) {
            session.setAttribute("loginUserName", memberDTO.getMemberUserName());
            return "memberPages/memberMain";
        } else {
            return "memberPages/memberLogin";
        }
    }

    @PostMapping("/login/axios")
    public ResponseEntity memberLoginAxios(@RequestBody MemberDTO memberDTO, HttpSession session) throws Exception {
        memberService.loginAxios(memberDTO);
        session.setAttribute("loginUserName", memberDTO.getMemberUserName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/userName-check", method = RequestMethod.POST)
    public ResponseEntity userNameCheck(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
        String csrfToken = request.getHeader("X-CSRF-TOKEN");
        System.out.println("CSRF Token: " + csrfToken);

        boolean result = memberService.userNameCheck(memberDTO.getMemberUserName());
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/passPortNum-check", method = RequestMethod.POST)
    public ResponseEntity passPortNumCheck(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
        String csrfToken = request.getHeader("X-CSRF-TOKEN");
        System.out.println("CSRF Token: " + csrfToken);

        boolean result = memberService.passPortNumCheck(memberDTO.getMemberPassportNum());
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
