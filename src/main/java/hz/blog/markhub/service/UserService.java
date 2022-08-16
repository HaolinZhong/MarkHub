package hz.blog.markhub.service;

import hz.blog.markhub.domain.UserDo;

public interface UserService {
    UserDo getUserById(Long userId);

    UserDo getUserByName(String name);
}
