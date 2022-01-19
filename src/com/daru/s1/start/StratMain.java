package com.daru.s1.start;

import java.util.List;

import com.daru.s1.department.DepartmentDAO;
import com.daru.s1.department.DepartmentDTO;
import com.daru.s1.department.DepartmentView;
import com.daru.s1.util.DBConnector;

public class StratMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트시작");
		
		
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		DepartmentView departmentView = new DepartmentView();
//		try {
//			List<DepartmentDTO> ar = departmentDAO.getList();
//			departmentView.view(ar);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("DB 연동 테스트 끝");
	}

}
