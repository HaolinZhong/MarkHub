package hz.blog.markhub.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class BlogDo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.user_id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.title
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    @NotBlank(message = "Title cannot be blank")
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.description
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    @NotBlank(message = "Abstract cannot be blank")
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.created_at
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.status
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_blog.content
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    @NotBlank(message = "Content cannot be blank")
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.id
     *
     * @return the value of m_blog.id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.id
     *
     * @param id the value for m_blog.id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.user_id
     *
     * @return the value of m_blog.user_id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.user_id
     *
     * @param userId the value for m_blog.user_id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.title
     *
     * @return the value of m_blog.title
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.title
     *
     * @param title the value for m_blog.title
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.description
     *
     * @return the value of m_blog.description
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.description
     *
     * @param description the value for m_blog.description
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.created_at
     *
     * @return the value of m_blog.created_at
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.created_at
     *
     * @param createdAt the value for m_blog.created_at
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.status
     *
     * @return the value of m_blog.status
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.status
     *
     * @param status the value for m_blog.status
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_blog.content
     *
     * @return the value of m_blog.content
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_blog.content
     *
     * @param content the value for m_blog.content
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}