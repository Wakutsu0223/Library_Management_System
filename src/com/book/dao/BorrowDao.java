package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.book.model.Book;
import com.book.model.Borrow;
import com.book.model.User;
import com.book.util.StringUtil;

/**
 * 图书借阅Dao类
 * @author sdssy
 *
 */
public class BorrowDao {

	/**
	 * 借阅记录添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Borrow borrow)throws Exception{
		String sql= "insert into t_borrow values(null,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, borrow.getUserId());
		pstmt.setInt(2, borrow.getBookId());
		pstmt.setString(3, borrow.getBookName());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 历史借阅记录添加
	 * @param con
	 * @param borrow
	 * @return
	 * @throws Exception
	 */
	public int addHistory(Connection con, Borrow borrow)throws Exception{
		String sql= "insert into t_history values(null,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, borrow.getUserName());
		pstmt.setString(2, borrow.getBookName());
		pstmt.setString(3, borrow.getBorrow());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 借阅状态删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception{
		String sql = "delete from t_borrow where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 用户历史借阅记录查询
	 * @param con
	 * @return
	 */
	public ResultSet list(Connection con)throws Exception{
		String sql = "select * from t_history where userName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, new UserDao().userName_cc);
		return pstmt.executeQuery();
	}
	
	/**
	 * 全部历史借阅记录查询
	 * @param con
	 * @return
	 */
	public ResultSet listAll(Connection con)throws Exception{
		String sql = "select * from t_history";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	/**
	 * 更新借阅状态
	 * @param con
	 * @param borrow
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Borrow borrow)throws Exception{
		String sql = "update t_history set borrow=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, borrow.getId());
		pstmt.setString(2, borrow.getBorrow());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 指定图书是否正在被借阅
	 * @param con
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByUserId(Connection con, String bookId)throws Exception{
		String sql = "select * from t_borrow where bookId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookId);
		ResultSet rs =  pstmt.executeQuery();
		return rs.next();
	}
}
