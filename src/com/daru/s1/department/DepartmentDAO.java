package com.daru.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.daru.s1.util.DBConnector;

public class DepartmentDAO { //여기서만 DB에 접속
	//DAO: DATA Access Object 데이터에 접근하는 오브젝트
	private DBConnector dbConnector; //여기서만 사용할것이기때문에 1
	
	public DepartmentDAO() { //생성자 2
			dbConnector = new DBConnector();
	
	}
	
	
	
	
	public List<DepartmentDTO> getList() throws Exception { //15 view로넘어감
		ArrayList<DepartmentDTO> ar = new ArrayList(); //11
		
		//SELECT * FROM DEPARTMENTS;
		//1. DB로그인
		Connection con = dbConnector.getConnect(); //3
		
		
		//2. SQL Query 문 작성
		//java에서는 ; 제외
		String sql = "SELECT * FROM DEPARTMENTS"; //4
		
		//3. 작성한 SQL Query 미리 전송
		PreparedStatement st = con.prepareStatement(sql); //5
		
		//4. ? 값을 세팅, 없으면통과 
		
		//5. 최종 전송 후 결과 처리 
		ResultSet rs = st.executeQuery(); //최종쿼리문실행 6
		
		//cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면true, 없으면 false
		//한줄씩 읽어라
		while(rs.next()) { //7
			DepartmentDTO departmentDTO = new DepartmentDTO(); //8 DTO로넘어감
			//String name=rs.getString("department_name");//adminstration
			//departmentDTO.setDepartment_name(name);
			
			departmentDTO.setDepartment_name(rs.getString("department_name")); //10
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
			//데이터 세팅이 다 끝난다음
			//arraylist에 담는방법
			ar.add(departmentDTO); //12
		}
		
		//6. 외부연결 자원 해제
		// 연결된 순서의 역순으로 끊음
		rs.close(); //13
		st.close();
		con.close();
		
		
		return ar; //14
	}
	
}
