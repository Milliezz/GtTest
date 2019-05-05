package com.asjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asjy.model.Admin;
import com.asjy.model.Customer;
import com.asjy.util.JDBCUtil;

public class AdminDao {
	public static List<Admin> query(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Admin> list = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			//动态给问号赋值
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			rs = pstm.executeQuery();
			while (rs.next()) {
				Admin admin=new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, rs);
		}
		return list;
	}
}
