package config;

public class UserSQL {
   // 用户添加 sql语句
    protected static final String USER_ADD = "INSERT INTO user (username, password) VALUES ( ?, ?)";
    protected static final String USER_ADD_D = "INSERT INTO user_details (user_details_id, username, phone, email) VALUES (?, ?, ?, ?)";
    // 用户查询sql语句
    protected static final String USER_SELECT_NAME = "select user_id, username, password, level from user where username = ?";
    protected static final String USER_SELECT_ID = "select user_id, username, password from user where user_id = ?";
    // 用户详细信息查询sql语句
    protected static final String USER_DETAILES_SELECT = "select user_details_id, username, name, sex, phone, email, address from user_details where user_details_id = ?";

}
