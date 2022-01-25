package com.daru.s1.start;

import java.util.Scanner;

import com.daru.s1.department.DepartmentController;
import com.daru.s1.employee.EmployeeController;
import com.daru.s1.location.LocationController;
import com.daru.s1.regions.RegionController;

public class FrontController { // 모든 컨트롤러 연결

	private Scanner sc;
	private DepartmentController departmentControler;
	private LocationController locationController;
	private EmployeeController employeeController;
	private RegionController regionController;
	// location controller
	// employcontroller

	private void FrontController() {
		sc = new Scanner(System.in);
		departmentControler = new DepartmentController();
		locationController = new LocationController();
		employeeController = new EmployeeController();
		regionController = new RegionController();
		// lo, em
	}

	public void mainStart() throws Exception {
		boolean flag = true;

		while (flag) {
			System.out.println("1. 직원관리");
			System.out.println("2. 부서관리");
			System.out.println("3. 지역관리");
			System.out.println("4. 대륙관리");
			System.out.println("5. 종   료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				employeeController.start();
				// employeecontroller의 start 메서드 호출
				break;
			case 2:
				departmentControler.start();
				break;
			case 3:
				locationController.start();
				// locationcontroller의 start메서드 호출
				break;
			case 4:
				regionController.start();
				break;
			default:
				flag = false;
			}

		}
	}
}
