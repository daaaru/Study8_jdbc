package com.daru.s1.start;

import java.util.Scanner;

import com.daru.s1.department.DepartmentControler;

public class FrontController { //모든 컨트롤러 연결

	private Scanner sc;
	private DepartmentControler departmentControler;
	//location controller
	//employcontroller
	
	private void front() {
		sc = new Scanner(System.in);
		departmentControler = new DepartmentControler();
		
		// lo, em
	}

	public void mainStart() throws Exception{
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직원관리");
			System.out.println("2. 부서관리");
			System.out.println("3. 지역관리");
			System.out.println("4. 프로그램 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				//employeecontroller의 start 메서드 호출
				break;
			case 2:
				departmentControler.start();
				break;
			case 3:
				//locationcontroller의 start메서드 호출
				break;
			default:
				flag = false;
			}
			
	
	
	
}}}
