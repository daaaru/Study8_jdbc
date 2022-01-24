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
	
	//부서정보, 부서에 근무하는 사원들의 정보
	public void getDEP_EMPList() throws Exception {
		
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT d.*, e.* "
				+ "	FROM DEPARTMENTS d "
				+ "		INNER JOIN "
				+ "		EMPLOYEES e " 
				+ "		ON (d.DEPARTMENT_ID = e.DEPARTMENT_ID) ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	//부서번호로 조회 가지고오면get으로 시작
	public DepartmentDTO getOne(DepartmentDTO dep) throws Exception {
		DepartmentDTO departmentDTO = null;//초기화해줌
		
		//1. DB에 로그인
		Connection con = dbConnector.getConnect(); //예외처리 throws
		
		//2. SQL query문 작성 부서번호 숫자(변수) 외부에서 받아야함-매개변수로 선언해서 받음
		// 변하는수를 ? 로 표시, 완성된 SQL문이 아님
		String sql = "SELEC * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ? ";
		//인젝션공격 받을수 있음 department_id
				
		//3. 만든 Query문 미리전송해서 DB가 준비시켜줌
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅 집어넣는건 set
		//st.set데이터타입(int index, 값) index는 ?의 순서번호
		//그러나 orcle은 1번부터 시작(쿼리에쓰여져있는 ? 순서대로 본다)
		st.setInt(1, dep.getDepartment_id());
		
		//5. 최종전송 후 결과처리
		ResultSet rs = st.executeQuery();
		
		//전송한 결과가 데이터로옴 데이터가 있는지 없는지 확인 
		//커서가 맨 위에있기때문에 한줄씩 읽어서 확인 next()라는 메서드로 확인
		//결과물을 받았을때 1개의 row가 있거나 없거나
		//메서드 next() 리턴은 데이터가 있으면true, 없으면 false
		if(rs.next()) { //데이터가 있을때 DTO 초기화
			departmentDTO = new DepartmentDTO();
			//조회된결과를 가져와야함
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
		}
		
		//6. 자원 해제
		
		rs.close();
		st.close();
		con.close();
		
		return departmentDTO; //리턴타입확인
		
	}
	
	
	
	//전체조회
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
