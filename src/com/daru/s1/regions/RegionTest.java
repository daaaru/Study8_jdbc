package com.daru.s1.regions;

public class RegionTest {

	public static void main(String[] args) { //테스트전용
		//Region Package내에 있는것만 Test
		
		RegionController regionController = new RegionController();
		try {
		regionController.start();
		}catch(Exception e) {e.printStackTrace();}
//		RegionDAO regionDAO = new RegionDAO();
//		RegionDTO regionDTO = new RegionDTO();
//		
//		regionDTO.setRegion_id(5L);
//		regionDTO.setRegion_name("SL");
		
//		try {
//		//insert Test
//		int result = regionDAO.setInsert(regionDTO);
//			
//			
//		//delete Test
//		//int result = regionDAO.setDelete(regionDTO);	
//		System.out.println(result);
//		
//		
//		}catch (Exception e) {
//			e.printStackTrace();
		}
	}


