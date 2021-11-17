package com.itboy.domin;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wh
 * @date 2021年10月23日12:13
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private Character sex;
    private String  address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSername() {
        return username;
    }

    public void setSername(String sername) {
        this.username = sername;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sername='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
