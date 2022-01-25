package com.daru.s1.regions;

public class RegionDTO {
	
	//DTO 기본
	//멤버변수의 접근지정자는 모두 private으로 선언 
	//setter getter 필수
	//멤버변수의 Data type과 변수명은 DB의 table의 컬럼과 일치
	
	//생성자는 여러개 만들어도 상관없으나 기본생성자는 있어야함
	//클래스에는 생성자가 1개이상 있어야함
	//생성자가 하나라도 없으면 컴파일러가 기본생성자 만들어줌 
	
	private Long region_id; //1
	private String region_name;
	
	public Long getRegion_id() { //2
		return region_id;
	}
	public void setRegion_id(Long region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
	

}
