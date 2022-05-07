package gt1000.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String authorization = req.getHeader("Authorization");

        log.info("----------- header authorization = {}", authorization);
        if(authorization == null || !authorization.startsWith("Bearer")) {
            chain.doFilter(req, res);
            return;
        }

        authorization = authorization.replace("Bearer:", "");

        String name = JWT.require(Algorithm.HMAC512("cos")).build().verify(authorization).getClaim("name").asString();
        log.info("----------- name = {}", name);
        // 서명이 정상적으로 됨
        if(name != null) {
            // 뭔가 확인?.... select 가 되면 정상 사용자? 이렇게 되면 db 부하가 걸려서... jwt 사용하는 의미가 없어 지는데....
        }

        chain.doFilter(req, res);
    }
}
