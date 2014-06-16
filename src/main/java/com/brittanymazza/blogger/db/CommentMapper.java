package com.brittanymazza.blogger.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.brittanymazza.blogger.core.User;

public class CommentMapper implements ResultSetMapper<User> {
	public User map(int index, ResultSet r, StatementContext context) throws SQLException {
		return new User(r.getInt("id"), r.getString("content"), r.getString("user_id"));
	}
}
