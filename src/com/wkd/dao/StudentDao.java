package com.wkd.dao;
import java.sql.*;

import com.wkd.entity.Student;
import com.wkd.util.DBUtil;
public class StudentDao {
	// 四个对象
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pStat = null;//PreparedStatement可实现带参数的动态查询
	private ResultSet rs = null;//结果
	
	
	/**
	 * 根据id查询对象
	 * @param i
	 * @return
	 */
	public Student queryStudentById(int sid) {
		Student stu=null;
		try {
			String sql="select * from student where sid="+sid;
			//建立连接
			conn=DBUtil.getConnection();
			//生成语句对象
			stmt=conn.createStatement();
			//执行sql语句,获取结果
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				stu=new Student();
				//参数从1开始
				stu.setSid(rs.getInt(1));
				stu.setSname(rs.getString(2));
				stu.setSage(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库
			DBUtil.closeAll(conn, stmt, null, rs);			
		}
		
		return stu;
	}
	
	/**
	 *添加学生
	 * @param stu
	 * @return
	 */
	public boolean addStu(Student s) {
		
		try {
			String sql="insert into student values(?,?,?)";
			conn = conn=DBUtil.getConnection();
			pStat = conn.prepareStatement(sql);
			
			pStat.setInt(1,s.getSid());
			pStat.setString(2, s.getSname());
			pStat.setInt(3, s.getSage());
			int flag = pStat.executeUpdate();
			if (flag > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			DBUtil.closeAll(conn, null, pStat, rs);
		}
	} // end add

}
