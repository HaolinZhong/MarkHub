package hz.blog.markhub.web.controller;

import hz.blog.markhub.domain.BlogDo;
import hz.blog.markhub.domain.Pager;
import hz.blog.markhub.exception.ServiceException;
import hz.blog.markhub.exception.ServiceExceptionEnum;
import hz.blog.markhub.service.BlogService;
import hz.blog.markhub.utils.ShiroUtils;
import hz.blog.markhub.web.model.CommonReturnType;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final static Integer PAGE_SIZE = 5;

    private final BlogService blogService;

    @GetMapping("/list")
    @ResponseBody
    public CommonReturnType listBlogByPage(@RequestParam(defaultValue = "1") Integer page) {
        Pager<BlogDo> pagedBlogs = blogService.listBlogByPager(page, PAGE_SIZE);
        return CommonReturnType.builder().status("success").data(pagedBlogs).build();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CommonReturnType getBlogDetails(@PathVariable(name = "id") Long id) throws ServiceException {
        BlogDo blogDo = blogService.getBlogById(id);
        if (blogDo == null) throw new ServiceException(ServiceExceptionEnum.ITEM_NOT_FOUND, "Blog not found.");
        return CommonReturnType.builder().status("success").data(blogDo).build();
    }

    @RequiresAuthentication
    @PostMapping("/create")
    @ResponseBody
    public CommonReturnType create(@Validated @RequestBody BlogDo blogDo) throws ServiceException {
        if (blogDo.getId() != null || blogDo.getUserId() != null) {
            throw new ServiceException(ServiceExceptionEnum.INVALID_PARAMETER);
        }

        blogDo.setUserId(ShiroUtils.getProfile().getId());
        blogDo.setCreatedAt(new Date());
        blogDo.setStatus(Byte.valueOf("0"));

        blogService.createBlog(blogDo);

        return CommonReturnType.builder().status("success").data(blogDo).build();
    }


    @RequiresAuthentication
    @PostMapping("/edit")
    @ResponseBody
    public CommonReturnType edit(@Validated @RequestBody BlogDo blogDo) throws ServiceException {

        if (blogDo.getId() == null || blogDo.getUserId() == null) {
            throw new ServiceException(ServiceExceptionEnum.INVALID_PARAMETER);
        }

        BlogDo rawBlog = blogService.getBlogById(blogDo.getId());

        if (rawBlog == null) {
            throw new ServiceException(ServiceExceptionEnum.ITEM_NOT_FOUND, "Original blog missing.");
        }

        if (rawBlog.getUserId() != blogDo.getUserId()) {
            throw new ServiceException(ServiceExceptionEnum.INVALID_PARAMETER, "Not authorized.");
        }

        boolean res = blogService.updateBlog(blogDo);
        if (!res) throw new ServiceException(ServiceExceptionEnum.UNKNOWN_ERROR);

        return CommonReturnType.builder().status("success").build();
    }

}
