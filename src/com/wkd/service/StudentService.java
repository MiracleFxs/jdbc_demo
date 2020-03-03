package com.wkd.service;

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
		Student stu=stuDao.queryStudentById(5);
		if(stu==null){
			System.out.println("该学生不存在!");
		}else{
			System.out.println(stu);
		}
	}
}
