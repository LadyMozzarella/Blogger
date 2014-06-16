package com.brittanymazza.blogger.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.brittanymazza.blogger.core.Comment;

public class CommentMapper implements ResultSetMapper<Comment> {
	public Comment map(int index, ResultSet r, StatementContext context) throws SQLException {
		return new Comment(r.getInt("id"), r.getString("content"), r.getInt("user_id"), r.getInt("post_id"), r.getTimestamp("timestamp"));
	}
}
