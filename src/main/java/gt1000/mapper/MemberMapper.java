package gt1000.mapper;

import gt1000.common.mapper.MapStructMapper;
import gt1000.common.mapper.MapStructMapperConfig;
import gt1000.dto.MemberDto;
import gt1000.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapStructMapperConfig.class)
public interface MemberMapper extends MapStructMapper<MemberDto, Member> {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Override
    @Mapping(target = "id", ignore = true)
    Member toEntity(MemberDto dto);
}
