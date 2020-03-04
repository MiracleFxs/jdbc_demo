package com.wkd.service;

import java.util.Scanner;

import com.wkd.dao.StudentDao;
import com.wkd.entity.Student;

/**
 * 业务类
 * @author fxs
 *
 */
public class StudentService {

	public static void main(String[] args){
		StudentDao stuDao= new StudentDao();
//		Student stu=stuDao.queryStudentById(5);
//		if(stu==null){
//			System.out.println("该学生不存在!");
//		}else{
//			System.out.println(stu);
//		}
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("输入姓名:");
		String sname=sc.next();
		System.out.println("输入年龄:");
		int sage=sc.nextInt();
		
		Student s=new Student(sname,sage);

		boolean flag=stuDao.addStu(s);
		System.out.println(flag?"添加成功":"添加失败");
	}
}
