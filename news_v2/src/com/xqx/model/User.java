package com.xqx.model;

/**
 * @author xqx
 * @Date 2019/5/13 17:33
 * @Package_Name: com.xqx.Servlet
 * @Description�� �û� ʵ����
 */
public class User {
    private int user_id;    //�û�id
    public String username; //�û���
    private String password; //�û�����
    private String name;    //��ʵ����
    private String sex;     //�Ա�
    private String email;   //��������
    private String phone;   //�绰����
    private String address; //��ַ
    private int level;  //�û�����

    public User() {
    }

    /**
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @param user_id
     * @param username
     * @param password
     * @param level
     */
    public User(int user_id, String username, String password, int level) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.level = level;
    }

    /**
     *
     * @param user_id
     * @param username
     * @param password
     */
    public User(int user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @param username
     * @param password
     * @param email
     * @param phone
     */
    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    /**
     *
     * @param user_id
     * @param username
     * @param name
     * @param sex
     * @param phone
     * @param email
     * @param address
     */
    public User(int user_id, String username, String name, String sex, String phone, String email, String address) {
        this.user_id = user_id;
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     *
     * @return int
     */
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                '}';
    }
}