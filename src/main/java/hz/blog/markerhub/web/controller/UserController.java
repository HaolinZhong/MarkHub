package hz.blog.markerhub.web.controller;

import hz.blog.markerhub.domain.UserDo;
import hz.blog.markerhub.mapper.UserDoMapper;
import hz.blog.markerhub.web.model.CommonReturnType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDoMapper userDoMapper;

    @GetMapping("/get")
    @ResponseBody
    public CommonReturnType getUserById(@RequestParam("id") Long userId) {
        UserDo userDo = userDoMapper.selectByPrimaryKey(userId);
        return CommonReturnType.builder().status("success").data(userDo).build();
    }
}
