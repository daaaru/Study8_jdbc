package com.daru.s1.department;

import java.util.List;

public class DepartmentView {
	
	public void view(DepartmentDTO departmentDTO) {
		System.out.print(departmentDTO.getDepartment_id()+"\t");
		System.out.print(departmentDTO.getDepartment_name()+"\t");
		System.out.print(departmentDTO.getManager_id()+"\t");
		System.out.println(departmentDTO.getLocation_id());
		System.out.println("--------------------------------------------");
	}

	
	public void view(List<DepartmentDTO> ar) { //16 메인으로
		//모두 출력
		for(int i=0;i<ar.size();i++) { //17
			this.view(ar.get(i));
			System.out.println("--------------------------------------------");
		
//			System.out.print(ar.get(i).getDepartment_id()+"\t");
//			System.out.print(ar.get(i).getDepartment_name()+"\t");
//			System.out.print(ar.get(i).getManager_id()+"\t");
//			System.out.println(ar.get(i).getLocation_id());
//			System.out.println("--------------------------------------------");
		}
		
		
	}
	
}
