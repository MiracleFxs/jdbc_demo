package com.wkd.entity;
/**
 * 学生实体类，与数据库表中字段对应
 * @author fxs
 *
 */
public class Student {
	private int sid;
	private String sname;
	private int sage;
	public Student(){}
	public Student(String sname2, int sage2) {
		// TODO Auto-generated constructor stub
		this.sname=sname2;
		this.sage=sage2;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage
				+ "]";
	}

}
