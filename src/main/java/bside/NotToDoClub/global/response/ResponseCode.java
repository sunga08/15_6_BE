package bside.NotToDoClub.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    GET_USER_INFO(OK, "사용자 정보 조회 성공"),
    PROVIDE_APP_TOKEN(OK, "토큰 발급 성공"),

    TOS_AGREE(OK, "이용약관 동의 완료");

    private HttpStatus status;
    private final String message;
}
