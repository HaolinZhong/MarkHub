package hz.blog.markhub.service.impl;

import hz.blog.markhub.domain.BlogDo;
import hz.blog.markhub.domain.Pager;
import hz.blog.markhub.mapper.BlogDoMapper;
import hz.blog.markhub.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogDoMapper blogDoMapper;

    @Override
    public Pager<BlogDo> listBlogByPager(Integer currentPage, Integer pageSize) {

        Map<String, Object> params = new HashMap<>();

        params.put("currentPage", (currentPage - 1) * pageSize);
        params.put("size", pageSize);

        List<BlogDo> blogDos = blogDoMapper.selectByPager(params);
        Long total = blogDoMapper.count();

        Pager<BlogDo> pager = new Pager<>();
        pager.setCurrentPage(currentPage);
        pager.setPageSize(pageSize);
        pager.setRows(blogDos);
        pager.setTotal(total);

        return pager;
    }

    @Override
    public BlogDo getBlogById(Long blogId) {
        BlogDo blogDo = blogDoMapper.selectByPrimaryKey(blogId);
        return blogDo;
    }

    @Override
    public BlogDo createBlog(BlogDo blogDo) {
        blogDoMapper.insertSelective(blogDo);
        return blogDo;
    }

    @Override
    public Boolean updateBlog(BlogDo blogDo) {
        Integer rowAffected = blogDoMapper.updateByPrimaryKeySelective(blogDo);
        return rowAffected == 1;
    }
}
