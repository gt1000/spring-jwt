package gt1000.controller;

import gt1000.dto.MemberDto;
import gt1000.service.MemberService;
import gt1000.util.JwtTokenHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RestApiController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

//    @PostMapping("/join")
//    public String join(@RequestBody MemberDto memberDto) {
//        memberDto.setEncryptPassword(passwordEncoder.encode(memberDto.getPassword()));
//        memberDto.setRoles("ROLE_USER");
//
//        memberService.save(memberDto);
//
//        return "회원 가입 완료";
//    }

    @GetMapping("/members")
    public String members(HttpServletRequest request, HttpServletResponse response) {

        log.info("------------------- 여기 들어 왔어 --------------------");

        return "member";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestBody MemberDto memberDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberDto.getId(), memberDto.getPassword());


        String token = JwtTokenHelper.createToken(memberDto);
        response.addHeader("Authorization", "Bearer:" + token);

        return "login";
    }

    @PostMapping("/token")
    public String token(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = memberService.findByMemberId(1L);
        log.info("====================== member = {}", memberDto);

        String token = JwtTokenHelper.createToken(memberDto);
        response.addHeader("Authorization", "Bearer:" + token);

        return "<h1>Token</h1>";
    }
}
