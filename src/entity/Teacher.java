package entity;

import java.io.Serializable;

public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String age;
    private String sex;
    private String position;
    private String address;
    private String phone;
    private String namestr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNamestr() {
        return namestr;
    }

    public void setNamestr(String namestr) {
        this.namestr = namestr;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
