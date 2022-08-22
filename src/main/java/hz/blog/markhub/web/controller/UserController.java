package hz.blog.markhub.web.controller;

import hz.blog.markhub.converter.UserConverter;
import hz.blog.markhub.domain.UserDo;
import hz.blog.markhub.mapper.UserDoMapper;
import hz.blog.markhub.service.UserService;
import hz.blog.markhub.web.model.CommonReturnType;
import hz.blog.markhub.web.model.UserVo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping("/get")
    @ResponseBody
    public CommonReturnType getUserById(@RequestParam("id") Long userId) {
        UserDo userDo = userService.getUserById(userId);
        UserVo userVo = userConverter.userDoToVo(userDo);
        return CommonReturnType.builder().status("success").data(userVo).build();
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public CommonReturnType createUser(@Validated @RequestBody UserDo userDo) {
        return CommonReturnType.builder().status("success").data(userConverter.userDoToVo(userDo)).build();
    }
}
