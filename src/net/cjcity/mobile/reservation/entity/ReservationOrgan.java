package net.cjcity.mobile.reservation.entity;

import android.graphics.Bitmap;

/**
*	기관 
*/ 
public class ReservationOrgan extends BaseEntity {

	/**
	*	기관 constructor with no arguments
	*/ 
	public ReservationOrgan(){};
	
	/**
	 * 기관 constructor with arguments
	 */
	public ReservationOrgan(
		
		String name
	
		,String zipCode
	
		,String location
	
		,String locationDetail
	
		,String phone
	
		,String ozcdId
	
		,String ozcdName
	
		,String detail
	){
		super();
		
		this.name = name;
	
		this.zipCode = zipCode;
	
		this.location = location;
	
		this.locationDetail = locationDetail;
	
		this.phone = phone;
	
		this.ozcdId = ozcdId;
	
		this.ozcdName = ozcdName;
	
		this.detail = detail;
	
	
	}
	

	
	/**
	*	기관명
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
	*	우편번호
	*/
	private String zipCode;
			
	/**
	 * @return zipCode
	 */
	public String getZipCode() {
		
			return zipCode;
		
	}
	/**
	 * @return zipCode
	 */
	public void setZipCode(String zipCode) {
		
			this.zipCode = zipCode;
		
		
	}
	

	
	/**
	*	위치
	*/
	private String location;
			
	/**
	 * @return location
	 */
	public String getLocation() {
		
			return location;
		
	}
	/**
	 * @return location
	 */
	public void setLocation(String location) {
		
			this.location = location;
		
		
	}
	

	
	/**
	*	위치 상세
	*/
	private String locationDetail;
			
	/**
	 * @return locationDetail
	 */
	public String getLocationDetail() {
		
			return locationDetail;
		
	}
	/**
	 * @return locationDetail
	 */
	public void setLocationDetail(String locationDetail) {
		
			this.locationDetail = locationDetail;
		
		
	}
	

	
	/**
	*	연락처
	*/
	private String phone;
			
	/**
	 * @return phone
	 */
	public String getPhone() {
		
			return phone;
		
	}
	/**
	 * @return phone
	 */
	public void setPhone(String phone) {
		
			this.phone = phone;
		
		
	}
	

	
	/**
	*	주관부서아이디
	*/
	private String ozcdId;
			
	/**
	 * @return ozcdId
	 */
	public String getOzcdId() {
		
			return ozcdId;
		
	}
	/**
	 * @return ozcdId
	 */
	public void setOzcdId(String ozcdId) {
		
			this.ozcdId = ozcdId;
		
		
	}
	

	
	/**
	*	주관부서 이름
	*/
	private String ozcdName;
			
	/**
	 * @return ozcdName
	 */
	public String getOzcdName() {
		
			return ozcdName;
		
	}
	/**
	 * @return ozcdName
	 */
	public void setOzcdName(String ozcdName) {
		
			this.ozcdName = ozcdName;
		
		
	}
	

	
	/**
	*	부대설명
	*/
	private String detail;
			
	/**
	 * @return detail
	 */
	public String getDetail() {
		
			return detail;
		
	}
	/**
	 * @return detail
	 */
	public void setDetail(String detail) {
		
			this.detail = detail;
		
		
	}
	
	
	private Bitmap image;

	public Bitmap getImage() {
		return this.image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}
	
}