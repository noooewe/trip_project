package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.service.MemberService;
import com.portfolio.trip_project.service.UserDetailsServiceImpl;
import com.portfolio.trip_project.util.JwtClass;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtClass jwtClass;

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
    public ResponseEntity memberLogin(@RequestBody MemberDTO memberDTO) {
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(memberDTO.getMemberUserName());
            String token = jwtClass.generateToken(userDetails);
            return ResponseEntity.ok().body(token);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/login/axios")
    public ResponseEntity memberLoginAxios(@RequestBody MemberDTO memberDTO, HttpSession session) throws Exception {
        boolean loginResult = memberService.loginAxios(memberDTO);
        if (loginResult) {
            session.setAttribute("loginUserName", memberDTO.getMemberUserName());
            UserDetails userDetails = userDetailsService.loadUserByUsername(memberDTO.getMemberUserName());
            System.out.println("User Details: " + userDetails); // 로그 추가
            String token = jwtClass.generateToken(userDetails);
            return ResponseEntity.ok().body(token);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
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
