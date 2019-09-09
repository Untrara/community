package edu.swpu.community.controller;

import edu.swpu.community.dto.AccessTokenDTO;
import edu.swpu.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new  AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("fe2df755d79c513818d5");
        accessTokenDTO.setClient_secret("66df603b2f4f8db04885efe5c2bdb3f292cad312");
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
