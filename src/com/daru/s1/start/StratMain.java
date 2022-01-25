package com.daru.s1.start;

import java.util.List;

import com.daru.s1.department.DepartmentController;
import com.daru.s1.department.DepartmentDAO;
import com.daru.s1.department.DepartmentDTO;
import com.daru.s1.department.DepartmentView;
import com.daru.s1.location.LocationDAO;
import com.daru.s1.location.LocationDTO;
import com.daru.s1.location.LocationView;
import com.daru.s1.regions.RegionDAO;
import com.daru.s1.regions.RegionDTO;
import com.daru.s1.util.DBConnector;

public class StratMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트시작");
		
		
		FrontController frontController = new FrontController();
//		try {
//			//frontController.mainStart();
//			RegionDAO regionDAO = new RegionDAO();
//			RegionDTO regionDTO = new RegionDTO();
//			
//			regionDTO.setRegion_id(5L);
//			regionDTO.setRegion_name("South Pole");
//			
////			int result = regionDAO.setInsert(regionDTO);
////			int result = regionDAO.setDelete(regionDTO);
//			int result = regionDAO.setUpdate(regionDTO);
//			
//			if(result > 0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
//				
//		} catch (Exception e) {
//			// TODOAuto-generated catch block
//			e.printStackTrace();
//		}
		
//		DepartmentControler dc = new DepartmentControler();
//		try {
//			dc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		
//		LocationDAO locationDAO = new LocationDAO();
//		LocationView locationView = new LocationView();
//		try {
//			List<LocationDTO> ar = locationDAO.getList();
//			locationView.view(ar);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//------ department Test-----------
		DepartmentDAO departmentDAO = new DepartmentDAO(); //19
		DepartmentView departmentView = new DepartmentView();
		
		try {
			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(20);
//			departmentDTO = departmentDAO.getOne(departmentDTO);
//			//DepartmentDTO departmentDTO = departmentDAO.getOne(20);
//			System.out.println(departmentDTO.getDepartment_name());
////			List<DepartmentDTO> ar = departmentDAO.getList(); //20
////			departmentView.view(ar);//21
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("DB 연동 테스트 끝");
	}

}
