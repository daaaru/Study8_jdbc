package com.daru.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {
	
	private DepartmentDAO departmentDAO;//2
	private DepartmentView departmentView;//3
	private Scanner sc;//7
	
	public DepartmentController() {//4

		departmentDAO = new DepartmentDAO();//5
		departmentView = new DepartmentView();//6
		sc = new Scanner(System.in);//8
	}

	public void start() throws Exception { //1
		boolean flag = true; //9
		
		
		//메뉴만듦
		while(flag) { //10
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번  호 검색");
			System.out.println("3. 종          료");
			int select = sc.nextInt(); //11 번호받기
			
			switch(select) { //12 정수입력
			case 1:
				List<DepartmentDTO> ar = departmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("검색 할 부서 번호를 입력");
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				departmentView.view(departmentDTO);
				break;
			default:
				System.out.println("종료합니다");
				flag = false;
			}
			
		}
		
	}
}
