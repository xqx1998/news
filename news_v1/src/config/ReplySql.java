package config;

public class ReplySql {
    protected static final String REPLY_ADD1 = "INSERT INTO reply(`reply_news_id`, `reply_user_id`, `reply_level`, `reply_content`, `reply_time`) VALUES (?, ?, ?, ?, ?)";
    protected static final String REPLY_ADD2 = "INSERT INTO reply(`reply_news_id`, `reply_user_id`, `reply_level`, `reply_reply_id`, `reply_content`, `reply_time`) VALUES (?, ?, ?, ?, ?, ?)";
}
