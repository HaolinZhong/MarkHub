package hz.blog.markerhub.domain;

import java.util.Date;

public class UserDo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.name
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.avatar
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.email
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.password
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.status
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.created_at
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_user.last_login
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    private Date lastLogin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.id
     *
     * @return the value of m_user.id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.id
     *
     * @param id the value for m_user.id
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.name
     *
     * @return the value of m_user.name
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.name
     *
     * @param name the value for m_user.name
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.avatar
     *
     * @return the value of m_user.avatar
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.avatar
     *
     * @param avatar the value for m_user.avatar
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.email
     *
     * @return the value of m_user.email
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.email
     *
     * @param email the value for m_user.email
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.password
     *
     * @return the value of m_user.password
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.password
     *
     * @param password the value for m_user.password
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.status
     *
     * @return the value of m_user.status
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.status
     *
     * @param status the value for m_user.status
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.created_at
     *
     * @return the value of m_user.created_at
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.created_at
     *
     * @param createdAt the value for m_user.created_at
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_user.last_login
     *
     * @return the value of m_user.last_login
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_user.last_login
     *
     * @param lastLogin the value for m_user.last_login
     *
     * @mbg.generated Sun Aug 14 01:04:22 EDT 2022
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}