package com.daru.s1.employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {

	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private Scanner sc = null;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while (flag) {
			System.out.println("1. 사원리스트출력");
			System.out.println("2. 사원번호검색");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				List<EmployeeDTO> ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("검색할 사원번호입력");
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(sc.nextInt());
				employeeDTO = employeeDAO.getOne(employeeDTO);
				employeeView.view(employeeDTO);
				break;
			default:
				System.out.println("종료합니다");
				flag = false;
				break;
			}
			
		}
	}
	
}
