package net.cjcity.mobile.reservation.entity;

import android.graphics.Bitmap;

/**
*	프로그램 
*/ 
public class ReservationProgram extends BaseEntity

{

	/**
	*	프로그램 constructor with no arguments
	*/ 
	public ReservationProgram(){};
	
	/**
	 * 프로그램 constructor with arguments
	 */
	public ReservationProgram(
		
		String name
	
		,String explain
	
		,Integer organId
	
		,Integer programTypeId
	){
		super();
		
		this.name = name;
	
		this.explain = explain;
	
		this.organId = organId;
	
		this.programTypeId = programTypeId;
	
	
	}
	

	
	/**
	*	이름
	*/
	private String name;
			
	/**
	 * @return name
	 */
	public String getName() {
		
			return name;
		
	}
	/**
	 * @return name
	 */
	public void setName(String name) {
		
			this.name = name;
		
		
	}
	

	
	/**
	*	설명
	*/
	private String explain;
			
	/**
	 * @return explain
	 */
	public String getExplain() {
		
			return explain;
		
	}
	/**
	 * @return explain
	 */
	public void setExplain(String explain) {
		
			this.explain = explain;
		
		
	}
	

	
	/**
	*	기관ID
	*/
	private Integer organId;
			
	/**
	 * @return organId
	 */
	public Integer getOrganId() {
		
			return organId;
		
	}
	/**
	 * @return organId
	 */
	public void setOrganId(Integer organId) {
		
			this.organId = organId;
		
		
	}
	

	
	/**
	*	프로그램타입 ID
	*/
	private Integer programTypeId;
			
	/**
	 * @return programTypeId
	 */
	public Integer getProgramTypeId() {
		
			return programTypeId;
		
	}
	/**
	 * @return programTypeId
	 */
	public void setProgramTypeId(Integer programTypeId) {
		
			this.programTypeId = programTypeId;
		
		
	}
	
	private Bitmap image;

	public Bitmap getImage() {
		return this.image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}
}