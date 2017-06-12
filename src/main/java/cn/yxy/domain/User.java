package cn.yxy.domain;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 为了给xmemcached序列化
     */
    private static final long serialVersionUID = 3152556859380568274L;

    private Long id;
    private String name;
    private String password;
    private String email;
    private Long phoneNumble;
    private String avatarLink;

    private Long createAt;
    private Long updateAt;


    public Long getId() {
        return id;
    }

    public void setId(long i) {
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public long getPhoneNumble() {
        return phoneNumble;
    }

    public void setPhoneNumble(long phoneNumble) {
        this.phoneNumble = phoneNumble;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phoneNumble="
                + phoneNumble + ", avatarLink=" + avatarLink + ", createAt=" + createAt + ", updateAt=" + updateAt
                + "]";
    }
}