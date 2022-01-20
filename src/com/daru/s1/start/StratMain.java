package com.daru.s1.start;

import java.util.List;

import com.daru.s1.department.DepartmentDAO;
import com.daru.s1.department.DepartmentDTO;
import com.daru.s1.department.DepartmentView;
import com.daru.s1.location.LocationDAO;
import com.daru.s1.location.LocationDTO;
import com.daru.s1.location.LocationView;
import com.daru.s1.util.DBConnector;

public class StratMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트시작");
		
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();
		try {
			List<LocationDTO> ar = locationDAO.getList();
			locationView.view(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		DepartmentDAO departmentDAO = new DepartmentDAO(); //19
//		DepartmentView departmentView = new DepartmentView();
//		try {
//			List<DepartmentDTO> ar = departmentDAO.getList(); //20
//			departmentView.view(ar);//21
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("DB 연동 테스트 끝");
	}

}
