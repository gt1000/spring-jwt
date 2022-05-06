package gt1000.service;

import gt1000.dto.MemberDto;
import gt1000.entity.Member;
import gt1000.mapper.MemberMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberService {

    MemberDto findByMemberId(Long memberId);

    MemberDto findByName(String name);

    Long save(MemberDto memberDto);
}
