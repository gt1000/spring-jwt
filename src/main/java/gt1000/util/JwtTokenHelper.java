package gt1000.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import gt1000.dto.MemberDto;

import java.util.Date;

public class JwtTokenHelper {

    public static String createToken(MemberDto memberDto) {
        // RSA 방식이 아니고 Hash 암호 방식
        String token = JWT.create()
                .withSubject("사용자 토큰")
                // 만료 시간. 10분
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10)))
                .withClaim("id", memberDto.getId())
                .withClaim("name", memberDto.getName())
                .sign(Algorithm.HMAC512("cos"));

        return token;
    }
}
