package hz.blog.markhub.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserVo implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;
}