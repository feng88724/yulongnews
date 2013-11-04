/*
 *	Copyright (c) 2012, Yulong Information Technologies
 *	All rights reserved.
 *  
 *  @Project: JFinal
 *  @author: Robot	
 */
package com.yulong.news.common.datasource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


/**
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Aug 5, 2012	
 */
public class MyDataSource extends MysqlDataSource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1914822204987757970L;
	@Override
	protected Connection getConnection(Properties arg0) throws SQLException {
		Connection connection = super.getConnection(arg0);
		Statement statement = connection.createStatement();
		statement.execute("set names latin1;");
		statement.close();
		return connection;
	}
}
