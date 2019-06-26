package config;

public class TopicSQL {

    protected static final String SELECT = " SELECT topic_id, topic_name FROM topic where topic_id = ? ";

    protected static final String SELECT_ALL = " SELECT topic_id, topic_name FROM topic order by topic_id asc ";
}
