package com.brittanymazza.blogger.db;

import java.sql.Timestamp;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.brittanymazza.blogger.core.Comment;

@RegisterMapper(CommentMapper.class)
public interface CommentDAO {
  @SqlUpdate("create table comments (id int not null, content varchar(max) not null, user_id int, post_id int, timestamp timestamp, primary key (id))")
  void createCommentsTable();

  @SqlUpdate("insert into comments (id, content, user_id, post_id, timestamp) values (:id, :content, :user_id, :post_id, :timestamp)")
  void insert(@Bind("id") int id, @Bind("content") String content, @Bind("user_id") int user_id, @Bind("post_id") int post_id, @Bind("timestamp") Timestamp timestamp);
  
  @SqlQuery("select * from comments where post_id = :post_id")
  List<Comment> findCommentsByPostId(@Bind("post_id") int post_id);
}
