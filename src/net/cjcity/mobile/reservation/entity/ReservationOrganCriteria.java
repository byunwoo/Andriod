package net.cjcity.mobile.reservation.entity;

public class ReservationOrganCriteria extends BaseCriteria {
	private static final long serialVersionUID = 3962400720334762641L;

	/**
	*	id
	*/ 
	private Integer reservationOrganId;
	
	/**
	 * @param reservationOrganId
	 */
	public void setReservationOrganId(Integer reservationOrganId) {
		this.reservationOrganId = reservationOrganId;
	}
	/**
	 * @return reservationOrganId
	 */
	public Integer getReservationOrganId() {
		return reservationOrganId;
	}
	
	
		
	/**
	*	기관명
	*/
	private String name;
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
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
		return this.zipCode;
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
		return this.location;
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
		return this.locationDetail;
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
		return this.phone;
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
		return this.ozcdId;
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
		return this.ozcdName;
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
		return this.detail;
	}
	/**
	 * @return detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}