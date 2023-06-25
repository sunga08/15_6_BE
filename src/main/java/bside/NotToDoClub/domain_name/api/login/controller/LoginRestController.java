package bside.NotToDoClub.domain_name.api.login.controller;

import bside.NotToDoClub.config.Constant;
import bside.NotToDoClub.domain_name.api.login.service.LoginService;
import bside.NotToDoClub.domain_name.auth.service.OauthService;
import bside.NotToDoClub.domain_name.user.dto.UserRequestDto;
import bside.NotToDoClub.global.response.ResponseCode;
import bside.NotToDoClub.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginRestController {

    private final OauthService oAuthService;
    private final LoginService loginService;

    @GetMapping("/{socialLoginType}/page") //socialLoginType=naver, google, kakao...
    public void socialLoginRedirect(HttpServletResponse response, @PathVariable(name="socialLoginType") String SocialLoginPath) throws Exception {
        Constant.SocialLoginType socialLoginType= Constant.SocialLoginType.valueOf(SocialLoginPath.toUpperCase());
        response.sendRedirect(oAuthService.getRedirectUrl(socialLoginType));
    }

    @GetMapping("/auth/google-callback")
    public ResultResponse<UserRequestDto> googleCallback(@RequestParam(name="code") String code) throws IOException{
        UserRequestDto userRequestDto = loginService.googleLogin(code);
        return ResultResponse.of(ResponseCode.GET_USER_INFO, userRequestDto);
    }

    @GetMapping("/auth/kakao-callback")
    public ResultResponse<UserRequestDto> kakaoCallback(@RequestParam(name="code") String code) throws IOException{
        UserRequestDto userRequestDto = loginService.kakaoLogin(code);
        return ResultResponse.of(ResponseCode.GET_USER_INFO, userRequestDto);
    }

    @GetMapping("/auth/apple-callback")
    public ResultResponse<UserRequestDto> appleCallback(@RequestParam(name="code") String code) throws Exception {
        UserRequestDto userRequestDto = loginService.appleLogin(code);
        return null;
    }
}
