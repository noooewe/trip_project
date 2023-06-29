package com.portfolio.trip_project.util;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CsrfClass {

    @GetMapping("/csrf-token")
    @ResponseBody
    public CsrfResponse getCsrfToken(HttpServletRequest request) {
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrf != null) {
            return new CsrfResponse(csrf.getToken());
        }
        return null;
    }

    private static class CsrfResponse {
        private final String csrfToken;

        public CsrfResponse(String csrfToken) {
            this.csrfToken = csrfToken;
        }

        public String getCsrfToken() {
            return csrfToken;
        }
    }
}
