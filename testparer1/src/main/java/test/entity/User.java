package test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liu
 * @date 2023/11/17 9:22
 */

public class User {
    private Integer id;
    private String username;
    private String password;
    public String toString(){
        return "User{id="+this.id+",username="+this.username+",password="+this.password+"}\r\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
