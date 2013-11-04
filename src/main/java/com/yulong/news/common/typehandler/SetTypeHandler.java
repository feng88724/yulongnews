package com.yulong.news.common.typehandler;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(String.class)
public class SetTypeHandler implements TypeHandler<Object> {
	@Override
	public Object getResult(ResultSet resSet, String arg1) throws SQLException {
		String res = "";
		try {
			res = resSet.getString(arg1) == null ? "" : new String(
					resSet.getBytes(arg1), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Object getResult(ResultSet resSet, int arg1) throws SQLException {
		String res = "";
		try {
			res = resSet.getString(arg1) == null ? "" : new String(
					resSet.getBytes(arg1), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter,
			JdbcType jdbcType) throws SQLException {
		try {
			String paras = (String) parameter;
			if(paras != null){
				ps.setString(i, new String(paras.getBytes("UTF-8"), "latin1"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String res = "";
		try {
			res = cs.getString(columnIndex);
			res = res != null ? new String(res.getBytes(), "UTF-8"):"";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}
}
