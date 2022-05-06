package gt1000.controller;

import gt1000.dto.MemberDto;
import gt1000.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestApiController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody MemberDto memberDto) {
        memberDto.setEncryptPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberDto.setRoles("ROLE_USER");

        memberService.save(memberDto);

        return "회원 가입 완료";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>Token</h1>";
    }
}
