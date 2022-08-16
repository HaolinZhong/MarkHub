package hz.blog.markhub.web.controller;

import hz.blog.markhub.domain.UserDo;
import hz.blog.markhub.mapper.UserDoMapper;
import hz.blog.markhub.web.model.CommonReturnType;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDoMapper userDoMapper;

    @GetMapping("/get")
    @RequiresAuthentication
    @ResponseBody
    public CommonReturnType getUserById(@RequestParam("id") Long userId) {
        UserDo userDo = userDoMapper.selectByPrimaryKey(userId);
        return CommonReturnType.builder().status("success").data(userDo).build();
    }
}
