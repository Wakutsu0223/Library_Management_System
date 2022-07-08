package com.book.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.book.model.Book;
import  com.book.model.User;
import com.book.util.StringUtil;

/**
 * 用户Dao类
 * @ClassName UserDao
 * @Author sdssy
 * @Date 2022/6/1 17:50
 * @Version 1.0
 **/
public class UserDao {
	
	static public int id_cc;
	static public String userName_cc;
	
    /**
    *登陆验证
     */
    public User login(Connection con, User user)throws Exception{
        User resultUser = null;
        String sql = "select * from t_user where userName=? and password=? and classification=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getClassification());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultUser = new User();
            id_cc = rs.getInt("id");
            resultUser.setId(rs.getInt("id"));
            userName_cc = rs.getString("userName");
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
            resultUser.setClassification(rs.getString("classification"));
        }
        return resultUser;
    }
    
    /**
	 * 用户个人信息查询
	 * @param con
	 * @return
	 */
	public ResultSet list(Connection con)throws Exception{
		String sql = "select * from t_user where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id_cc);
		return pstmt.executeQuery();
	}
	
	/**
	 * 全部个人信息查询
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public ResultSet listAll(Connection con)throws Exception{
		String sql = "select * from t_user where classification=1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	/**
	 * 修改个人信息
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, User user)throws Exception{
		String sql = "update t_user set name=?,sex=?,class=?,college=?,studentID=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getSex());
		pstmt.setString(3, user.getClassTxt());
		pstmt.setString(4, user.getCollege());
		pstmt.setString(5, user.getStudentId());
		pstmt.setInt(6, user.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 删除用户
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception{
		String sql = "delete from t_user where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 指定用户下是否存在借阅
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean existUserById(Connection con, String id)throws Exception {
		String sql = "select * from t_borrow where userId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs =  pstmt.executeQuery();
		return rs.next();
	}
}
