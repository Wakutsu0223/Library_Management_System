package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.book.model.Book;
import com.book.model.User;
import com.book.util.StringUtil;

/**
 * 注册Dao类
 * @author sdssy
 *
 */
public class RegisterDao {

	/**
	 * 添加待审核新用户
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, User user)throws Exception{
		String sql= "insert into t_audit values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, "1");
		pstmt.setString(4, user.getName());
		pstmt.setString(5, user.getSex());
		pstmt.setString(6, user.getClassTxt());
		pstmt.setString(7, user.getCollege());
		pstmt.setString(8, user.getStudentId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 全部新用户信息查询
	 * @param con
	 * @return
	 
	public ResultSet listAll(Connection con)throws Exception{
		String sql = "select * from t_audit";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}*/
	
	/**
	 * 新用户信息查询
	 * @param con
	 * @return
	 */
	public ResultSet list(Connection con, User user)throws Exception{
		/*String sql = "select * from t_audit where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		return pstmt.executeQuery();*/
		
		StringBuffer sb = new StringBuffer("select * from t_audit");
		if(user.getId() != -1) {
			sb.append(" and id="+user.getId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 新用户审核驳回
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception{
		String sql = "delete from t_audit where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 审核通过
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int pass(Connection con, User user)throws Exception{
		String sql= "insert into t_user values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, "1");
		pstmt.setString(4, user.getName());
		pstmt.setString(5, user.getSex());
		pstmt.setString(6, user.getClassTxt());
		pstmt.setString(7, user.getCollege());
		pstmt.setString(8, user.getStudentId());
		return pstmt.executeUpdate();
	}
}
