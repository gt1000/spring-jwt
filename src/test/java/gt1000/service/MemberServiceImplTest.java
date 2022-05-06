package gt1000.service;

import gt1000.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("사용자 조회")
    void member() {
        assertThrows(NotFoundMemberException.class, () -> {
            MemberDto memberDto = memberService.findByMemberId(1L);
            log.info("--------- memberDto = {}", memberDto);
        });
    }
}