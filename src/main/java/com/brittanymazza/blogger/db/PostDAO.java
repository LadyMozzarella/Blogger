package com.brittanymazza.blogger.db;

import java.sql.Timestamp;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.brittanymazza.blogger.core.Post;

@RegisterMapper(PostMapper.class)
public interface PostDAO {
  @SqlUpdate("create table posts (id int not null, title varchar(100), content varchar(max), user_id int, timestamp timestamp, primary key (id))")
  void createPostsTable();

  @SqlUpdate("insert into posts (id, title, content, timestamp, user_id) values (:id, :title, :content, :timestamp, :user_id)")
  void insert(@Bind("id") int id, @Bind("title") String title, @Bind("content") String content, @Bind("user_id") int user_id, @Bind("timestamp") Timestamp timestamp);

  @SqlQuery("select * from posts where user_id = :user_id")
  List<Post> findPostsByUserId(@Bind("user_id") int user_id);
  
  @SqlQuery("select * from posts order by timestamp desc")
  List<Post> findAll();
  
  @SqlQuery("select * from posts where id = :id")
  Post findPostById(@Bind("id") int id);
  
  @SqlQuery("select user_id from posts where id = :id")
  int findUserIdByPost(@Bind("id") int id);
}





