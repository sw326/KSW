package mvc.domain;

import java.sql.Date;

public class Users {
    private String id;
    private String pwd;
    private String email;
    private String homepage;
    private Date created_at;

    public Users() {}
    public Users(String id, String pwd, String email, String homepage, Date created_at) {
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.homepage = homepage;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHomepage() {
        return homepage;
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
