package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.book.model.Book;
import com.book.model.Borrow;
import com.book.util.StringUtil;

/**
 * 图书归还Dao类
 * @author sdssy
 *
 */
public class BookReturnDao {

	/**
	 * 未归还图书信息查询
	 * @param con
	 * @return
	 */
	public ResultSet list(Connection con, Borrow borrow)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_borrow where userId=");
		if(StringUtil.isNotEmpty(Integer.toString(borrow.getUserId()))) {
			sb.append(borrow.getUserId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
}
