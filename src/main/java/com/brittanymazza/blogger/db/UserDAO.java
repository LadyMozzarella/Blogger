package com.brittanymazza.blogger.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.brittanymazza.blogger.core.User;

@RegisterMapper(UserMapper.class)
public interface UserDAO {
  @SqlUpdate("create table users (id int not null, username varchar(100) unique, password varchar(100), primary key (id))")
  void createUsersTable();

  @SqlUpdate("insert into users (id, username, password) values (:id, :username, :password)")
  void insert(@Bind("id") int id, @Bind("username") String username, @Bind("password") String password);

  @SqlQuery("select username from users where id = :id")
  String findNameById(@Bind("id") int id);
  
  @SqlQuery("select * from users")
  List<User> findAll();
}
