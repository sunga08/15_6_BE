package bside.NotToDoClub.global.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse<T> {
    private String appAccessToken;
    private String appRefreshToken;
    private String email;
    private String nickname;
    //private String isNew;
}
