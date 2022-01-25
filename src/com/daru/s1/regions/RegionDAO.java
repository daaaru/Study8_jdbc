package com.daru.s1.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.daru.s1.util.DBConnector;

public class RegionDAO {

	//1 접속 및로그인해야함
	private DBConnector dbConnector;
	
	//2 
	public RegionDAO() { 
		dbConnector = new DBConnector();
	}
	
	
	//대륙 정보 수정 setUpdate, name수정 5번의 이름을 South pole로 바꿈
	public int setUpdate(RegionDTO regionDTO) throws Exception{
		
		//1 연결
		Connection con = dbConnector.getConnect();
		
		//2 SQL문생성
		String sql = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
		
		//3 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4 ?
		st.setString(1, regionDTO.getRegion_name());
		st.setLong(2, regionDTO.getRegion_id());
		
		//5
		int result = st.executeUpdate();
		
		//6
		st.close();
		con.close();
		
		return result;
	}
	
	
	
	
	
	//대륙 삭제 setDelete
	public int setDelete(RegionDTO regionDTO) throws Exception{
		//1연결
		Connection con = dbConnector.getConnect();
		
		//2 SQL문 생성
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		//3 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4 ?
		st.setLong(1, regionDTO.getRegion_id());
		//5
		int result = st.executeUpdate();
		
		//6
		st.close();
		con.close();
		
		return result;
	}
	
	
	
	
	//대력 추가
	//3
	//대륙정보 추가 집어넣으려고하니까 set 가져오려면 get -()에id,name을 넣어야하니까
	public int setInsert(RegionDTO regionDTO) throws Exception { //미리 exception던짐
		//-1 DB연결
		Connection con = dbConnector.getConnect();
		
		//java는 기본적으로 auto commit임

		//-2 SQL Query문 생성 - 바뀌면 물음표로 처리함
		String sql = "INSERT INTO REGIONS(REGION_ID, REGION_NAME) VALUES (?, ?)";
		//-3 query 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//-4 ?세팅 - 매개변수
		st.setDouble(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		//-5 최종전송 후 결과처리
		int result = st.executeUpdate();
		
		
		//-6 자원해제
		st.close();
		con.close();
		
		return result; //숫자로 성공인지 아닌지 판단
	}
	
	//전체조회, 검색조회
	
}
