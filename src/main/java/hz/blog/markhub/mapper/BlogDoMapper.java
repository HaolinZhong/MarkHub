package hz.blog.markhub.mapper;

import hz.blog.markhub.domain.BlogDo;

import java.util.List;
import java.util.Map;

public interface BlogDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    int insert(BlogDo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    int insertSelective(BlogDo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    BlogDo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    int updateByPrimaryKeySelective(BlogDo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    int updateByPrimaryKeyWithBLOBs(BlogDo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    int updateByPrimaryKey(BlogDo row);

    List<BlogDo> selectByPager(Map<String, Object> params);

    Long count();
}