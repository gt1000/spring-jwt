package gt1000.service;

import gt1000.dto.MemberDto;
import gt1000.entity.Member;
import gt1000.mapper.MemberMapper;
import gt1000.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberDto findByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(NotFoundMemberException::new);
        log.info("--------------------------- member = {}", member);

        return MemberMapper.INSTANCE.toDto(member);
    }

    @Transactional(readOnly = true)
    public MemberDto findByName(String name) {
        Member member = memberRepository.findByName(name);
        log.info("--------------------------- member = {}", member);

        return MemberMapper.INSTANCE.toDto(member);
    }

    @Transactional
    public Long save(MemberDto memberDto) {
        Member member = MemberMapper.INSTANCE.toEntity(memberDto);
        memberRepository.save(member);
        return member.getId();
    }
}
