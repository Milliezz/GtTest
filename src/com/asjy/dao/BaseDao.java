package com.asjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asjy.util.JDBCUtil;

public class BaseDao {

	//主要的Dao，封装增删改的功能
	public static boolean update(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, null);
		}
		return result > 0 ? true : false;
	}
}






