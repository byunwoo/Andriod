package net.cjcity.mobile.reservation.entity;

public class ReservationProgramCriteria extends BaseCriteria {
	private static final long serialVersionUID = 3962400720334762641L;

	/**
	*	id
	*/ 
	private Integer reservationProgramId;
	
	/**
	 * @param reservationProgramId
	 */
	public void setReservationProgramId(Integer reservationProgramId) {
		this.reservationProgramId = reservationProgramId;
	}
	/**
	 * @return reservationProgramId
	 */
	public Integer getReservationProgramId() {
		return reservationProgramId;
	}
	
	
		
	/**
	*	이름
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
	*	설명
	*/
	private String explain;
	/**
	 * @return explain
	 */
	public String getExplain() {
		return this.explain;
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
		return this.organId;
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
		return this.programTypeId;
	}
	/**
	 * @return programTypeId
	 */
	public void setProgramTypeId(Integer programTypeId) {
		this.programTypeId = programTypeId;
	}
}