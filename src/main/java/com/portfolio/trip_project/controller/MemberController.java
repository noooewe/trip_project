package com.portfolio.trip_project.controller;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

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
        if (loginResult) {
            session.setAttribute("loginEmail", memberDTO.getMemberUserName());
            return "memberPages/memberMain";
        } else {
            return "memberPages/memberLogin";
        }
    }

    @PostMapping("/login/axios")
    public ResponseEntity memberLoginAxios(@RequestBody MemberDTO memberDTO, HttpSession session) throws Exception {
        memberService.loginAxios(memberDTO);
        session.setAttribute("loginEmail", memberDTO.getMemberUserName());
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PostMapping("/userName-check")
    public ResponseEntity userNameCheck(@RequestBody MemberDTO memberDTO) {
        boolean result = memberService.userNameCheck(memberDTO.getMemberUserName());
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/passPortNum-check")
    public ResponseEntity passPortNumCheck(@RequestBody MemberDTO memberDTO) {
        boolean result = memberService.passPortNumCheck(memberDTO.getMemberPassportNum());
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "memberPages/memberList";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "memberPages/memberDetail";
    }

    @GetMapping("/axios/{id}")
    public ResponseEntity detailAxios(@PathVariable Long id) throws Exception {
        MemberDTO memberDTO = memberService.findById(id);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        String loginUserName = (String) session.getAttribute("loginUserName");
        MemberDTO memberDTO = memberService.findByMemberUserName(loginUserName);
        model.addAttribute("member", memberDTO);
        return "memberPages/memberUpdate";
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model model) {
        String loginUserName = (String) session.getAttribute("loginUserName");
        MemberDTO memberDTO = memberService.findByMemberUserName(loginUserName);
        model.addAttribute("member", memberDTO);
        return "memberPages/memberMyPage";
    }

}
