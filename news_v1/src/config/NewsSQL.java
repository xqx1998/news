package config;

public class NewsSQL {

    protected static final String NEWS_ADD = "INSERT INTO news (`news_title`, `news_topic_id`, `news_time`, `news_user_id`, `news_username`,`news_content`) VALUES (?, ?, ?, ?, ?, ?)";
    protected static final String NEWS_DETAILS_SELECT = "";
    protected static final String NEWS_SELECT = "SELECT news_id, news_title, news_topic_id, news_time, news_user_id, news_username, news_access, news_content FROM news where news_id = ?";
    protected static final String NEWS_SELECT_ALL = "";
    protected static final String NEWS_SELECT_END = "SELECT news_id, news_title, news_topic_id, news_time, news_user_id, news_username FROM news order by news_id desc LIMIT 1";
    protected static final String NEWS_SELECT_LIST = "";
    protected static final String NEWS_UPDATE = "UPDATE news t SET t.`news_title` = ?, t.`news_topic_id` = ?, t.`news_time` = ?, t.`news_user_id` = ?, t.`news_username` = ?, t.`news_access` = ?, t.`news_content` = ? WHERE t.`news_id` = ?";
    protected static final String NEWS_DELETE = "DELETE FROM news WHERE `news_id` = ?";
    protected static final String NEWS_DELETE_MORE = "";
}
