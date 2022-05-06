package gt1000.dto;

import gt1000.common.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {

    private Long id;

    private String name;

    private String password;

    private String roles;

    private LocalDateTime modifiedDate;

    private LocalDateTime createdDate;

    public void setRoles(String roles) {
        this.roles = roles;
    }
    public void setEncryptPassword(String password) {
        this.password = password;
    }

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
