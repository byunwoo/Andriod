package net.cjcity.mobile.reservation.entity;
import java.util.Date;

public class ReservationReceiptCriteria extends BaseCriteria {
	private static final long serialVersionUID = 3962400720334762641L;

	/**
	*	id
	*/ 
	private Integer reservationReceiptId;
	
	/**
	 * @param reservationReceiptId
	 */
	public void setReservationReceiptId(Integer reservationReceiptId) {
		this.reservationReceiptId = reservationReceiptId;
	}
	/**
	 * @return reservationReceiptId
	 */
	public Integer getReservationReceiptId() {
		return reservationReceiptId;
	}
	
	
		
	/**
	*	명칭
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
	*	카테고리
	*/
	private String category;
	/**
	 * @return category
	 */
	public String getCategory() {
		return this.category;
	}
	/**
	 * @return category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
		
	/**
	*	추가접수인원
	*/
	private Integer extraCount;
	/**
	 * @return extraCount
	 */
	public Integer getExtraCount() {
		return this.extraCount;
	}
	/**
	 * @return extraCount
	 */
	public void setExtraCount(Integer extraCount) {
		this.extraCount = extraCount;
	}
	
		
	/**
	*	단위접수 인원수
	*/
	private Integer seatCount;
	/**
	 * @return seatCount
	 */
	public Integer getSeatCount() {
		return this.seatCount;
	}
	/**
	 * @return seatCount
	 */
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	
		
	/**
	*	접수방법
	*/
	private String acceptingMethod;
	/**
	 * @return acceptingMethod
	 */
	public String getAcceptingMethod() {
		return this.acceptingMethod;
	}
	/**
	 * @return acceptingMethod
	 */
	public void setAcceptingMethod(String acceptingMethod) {
		this.acceptingMethod = acceptingMethod;
	}
	
		
	/**
	*	단체 접수 제외
	*/
	private String includeGroup;
	/**
	 * @return includeGroup
	 */
	public String getIncludeGroup() {
		return this.includeGroup;
	}
	/**
	 * @return includeGroup
	 */
	public void setIncludeGroup(String includeGroup) {
		this.includeGroup = includeGroup;
	}
	
		
	/**
	*	개인접수 제외
	*/
	private String includePersonel;
	/**
	 * @return includePersonel
	 */
	public String getIncludePersonel() {
		return this.includePersonel;
	}
	/**
	 * @return includePersonel
	 */
	public void setIncludePersonel(String includePersonel) {
		this.includePersonel = includePersonel;
	}
	
		
	/**
	*	요금부과단위
	*/
	private String feeUnit;
	/**
	 * @return feeUnit
	 */
	public String getFeeUnit() {
		return this.feeUnit;
	}
	/**
	 * @return feeUnit
	 */
	public void setFeeUnit(String feeUnit) {
		this.feeUnit = feeUnit;
	}
	
		
	/**
	*	요금
	*/
	private Integer fee;
	/**
	 * @return fee
	 */
	public Integer getFee() {
		return this.fee;
	}
	/**
	 * @return fee
	 */
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	
		
	/**
	*	접수시작일시
	*/
	private Date receiptStartDate;
	/**
	 * @return receiptStartDate
	 */
	public Date getReceiptStartDate() {
		return this.receiptStartDate;
	}
	/**
	 * @return receiptStartDate
	 */
	public void setReceiptStartDate(Date receiptStartDate) {
		this.receiptStartDate = receiptStartDate;
	}
	
		
	/**
	*	접수종료일시
	*/
	private Date receiptEndDate;
	/**
	 * @return receiptEndDate
	 */
	public Date getReceiptEndDate() {
		return this.receiptEndDate;
	}
	/**
	 * @return receiptEndDate
	 */
	public void setReceiptEndDate(Date receiptEndDate) {
		this.receiptEndDate = receiptEndDate;
	}
	
		
	/**
	*	사용시작일시
	*/
	private Date attendingStartDate;
	/**
	 * @return attendingStartDate
	 */
	public Date getAttendingStartDate() {
		return this.attendingStartDate;
	}
	/**
	 * @return attendingStartDate
	 */
	public void setAttendingStartDate(Date attendingStartDate) {
		this.attendingStartDate = attendingStartDate;
	}
	
		
	/**
	*	사용종료일시
	*/
	private Date attendingEndDate;
	/**
	 * @return attendingEndDate
	 */
	public Date getAttendingEndDate() {
		return this.attendingEndDate;
	}
	/**
	 * @return attendingEndDate
	 */
	public void setAttendingEndDate(Date attendingEndDate) {
		this.attendingEndDate = attendingEndDate;
	}
	
		
	/**
	*	유료여부
	*/
	private String feeFree;
	/**
	 * @return feeFree
	 */
	public String getFeeFree() {
		return this.feeFree;
	}
	/**
	 * @return feeFree
	 */
	public void setFeeFree(String feeFree) {
		this.feeFree = feeFree;
	}
	
		
	/**
	*	좌석수 제한 여부
	*/
	private String ynSeatLimit;
	/**
	 * @return ynSeatLimit
	 */
	public String getYnSeatLimit() {
		return this.ynSeatLimit;
	}
	/**
	 * @return ynSeatLimit
	 */
	public void setYnSeatLimit(String ynSeatLimit) {
		this.ynSeatLimit = ynSeatLimit;
	}
	
		
	/**
	*	가용 좌석수
	*/
	private Integer useSeatNumber;
	/**
	 * @return useSeatNumber
	 */
	public Integer getUseSeatNumber() {
		return this.useSeatNumber;
	}
	/**
	 * @return useSeatNumber
	 */
	public void setUseSeatNumber(Integer useSeatNumber) {
		this.useSeatNumber = useSeatNumber;
	}
	
		
	/**
	*	최저 신청가능 좌석수
	*/
	private Integer rowSeatNumber;
	/**
	 * @return rowSeatNumber
	 */
	public Integer getRowSeatNumber() {
		return this.rowSeatNumber;
	}
	/**
	 * @return rowSeatNumber
	 */
	public void setRowSeatNumber(Integer rowSeatNumber) {
		this.rowSeatNumber = rowSeatNumber;
	}
	
		
	/**
	*	최대 신청가능 좌석수
	*/
	private Integer highSeatNumber;
	/**
	 * @return highSeatNumber
	 */
	public Integer getHighSeatNumber() {
		return this.highSeatNumber;
	}
	/**
	 * @return highSeatNumber
	 */
	public void setHighSeatNumber(Integer highSeatNumber) {
		this.highSeatNumber = highSeatNumber;
	}
	
		
	/**
	*	현재 신청된 좌석수
	*/
	private Integer appliedSeatNumber;
	/**
	 * @return appliedSeatNumber
	 */
	public Integer getAppliedSeatNumber() {
		return this.appliedSeatNumber;
	}
	/**
	 * @return appliedSeatNumber
	 */
	public void setAppliedSeatNumber(Integer appliedSeatNumber) {
		this.appliedSeatNumber = appliedSeatNumber;
	}
	
		
	/**
	*	프로그램아이디
	*/
	private Integer programId;
	/**
	 * @return programId
	 */
	public Integer getProgramId() {
		return this.programId;
	}
	/**
	 * @return programId
	 */
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	
		
	/**
	*	프로그램타입아이디
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
	
		
	/**
	*	기관아이디
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
	*	중복방지 태그
	*/
	private String preventMultiApply;
	/**
	 * @return preventMultiApply
	 */
	public String getPreventMultiApply() {
		return this.preventMultiApply;
	}
	/**
	 * @return preventMultiApply
	 */
	public void setPreventMultiApply(String preventMultiApply) {
		this.preventMultiApply = preventMultiApply;
	}
	
		
	/**
	*	회차
	*/
	private Integer timeCount;
	/**
	 * @return timeCount
	 */
	public Integer getTimeCount() {
		return this.timeCount;
	}
	/**
	 * @return timeCount
	 */
	public void setTimeCount(Integer timeCount) {
		this.timeCount = timeCount;
	}
	
		
	/**
	*	서브회차
	*/
	private Integer subTimeCount;
	/**
	 * @return subTimeCount
	 */
	public Integer getSubTimeCount() {
		return this.subTimeCount;
	}
	/**
	 * @return subTimeCount
	 */
	public void setSubTimeCount(Integer subTimeCount) {
		this.subTimeCount = subTimeCount;
	}
	
		
	/**
	*	만석시 종료
	*/
	private String closingAtFullSeat;
	/**
	 * @return closingAtFullSeat
	 */
	public String getClosingAtFullSeat() {
		return this.closingAtFullSeat;
	}
	/**
	 * @return closingAtFullSeat
	 */
	public void setClosingAtFullSeat(String closingAtFullSeat) {
		this.closingAtFullSeat = closingAtFullSeat;
	}
	
		
	/**
	*	접수마스터ID
	*/
	private Integer receiptMasterId;
	/**
	 * @return receiptMasterId
	 */
	public Integer getReceiptMasterId() {
		return this.receiptMasterId;
	}
	/**
	 * @return receiptMasterId
	 */
	public void setReceiptMasterId(Integer receiptMasterId) {
		this.receiptMasterId = receiptMasterId;
	}
	
		
	/**
	*	신청건수
	*/
	private Integer appliedCount;
	/**
	 * @return appliedCount
	 */
	public Integer getAppliedCount() {
		return this.appliedCount;
	}
	/**
	 * @return appliedCount
	 */
	public void setAppliedCount(Integer appliedCount) {
		this.appliedCount = appliedCount;
	}
	
		
	/**
	*	수용량
	*/
	private Integer capacity;
	/**
	 * @return capacity
	 */
	public Integer getCapacity() {
		return this.capacity;
	}
	/**
	 * @return capacity
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
		
	/**
	*	최대대관일수
	*/
	private Integer maxRentalDays;
	/**
	 * @return maxRentalDays
	 */
	public Integer getMaxRentalDays() {
		return this.maxRentalDays;
	}
	/**
	 * @return maxRentalDays
	 */
	public void setMaxRentalDays(Integer maxRentalDays) {
		this.maxRentalDays = maxRentalDays;
	}
	
		
	/**
	*	하루당 최대신청건수
	*/
	private Integer maxApplyCountPerDay;
	/**
	 * @return maxApplyCountPerDay
	 */
	public Integer getMaxApplyCountPerDay() {
		return this.maxApplyCountPerDay;
	}
	/**
	 * @return maxApplyCountPerDay
	 */
	public void setMaxApplyCountPerDay(Integer maxApplyCountPerDay) {
		this.maxApplyCountPerDay = maxApplyCountPerDay;
	}
	
		
	/**
	*	1인당 최대신청건수
	*/
	private Integer multiApplyCountPerUser;
	/**
	 * @return multiApplyCountPerUser
	 */
	public Integer getMultiApplyCountPerUser() {
		return this.multiApplyCountPerUser;
	}
	/**
	 * @return multiApplyCountPerUser
	 */
	public void setMultiApplyCountPerUser(Integer multiApplyCountPerUser) {
		this.multiApplyCountPerUser = multiApplyCountPerUser;
	}
	
		
	/**
	*	마감
	*/
	private String selectionEnd;
	/**
	 * @return selectionEnd
	 */
	public String getSelectionEnd() {
		return this.selectionEnd;
	}
	/**
	 * @return selectionEnd
	 */
	public void setSelectionEnd(String selectionEnd) {
		this.selectionEnd = selectionEnd;
	}
	
}