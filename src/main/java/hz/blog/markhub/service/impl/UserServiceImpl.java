package hz.blog.markhub.service.impl;

import hz.blog.markhub.domain.UserDo;
import hz.blog.markhub.mapper.UserDoMapper;
import hz.blog.markhub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDoMapper userDoMapper;

    @Override
    public UserDo getUserById(Long userId) {

        UserDo userDo = userDoMapper.selectByPrimaryKey(userId);

        return userDo;
    }
}
