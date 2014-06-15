package com.brittanymazza.blogger.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.brittanymazza.blogger.core.Post;

public class PostMapper implements ResultSetMapper<Post> {
	public Post map(int index, ResultSet r, StatementContext context) throws SQLException {
		return new Post(r.getInt("id"), r.getString("title"), r.getString("content"), r.getInt("user_id"), r.getTimestamp("timestamp"));
	}
}