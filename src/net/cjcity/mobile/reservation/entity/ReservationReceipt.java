package net.cjcity.mobile.reservation.entity;
import java.util.Collection;
import java.util.Date;
/**
*	접수 
*/ 
public class ReservationReceipt extends BaseEntity 
{





	/**
	*	접수 constructor with no arguments
	*/ 
	public ReservationReceipt(){};
	
	/**
	 * 접수 constructor with arguments
	 */
	public ReservationReceipt(
		
		String name
	
		,String category
	
		,Integer extraCount
	
		,Integer seatCount
	
		,String acceptingMethod
	
		,String includeGroup
	
		,String includePersonel
	
		,String feeUnit
	
		,Integer fee
	
		,Date receiptStartDate
	
		,Date receiptEndDate
	
		,Date attendingStartDate
	
		,Date attendingEndDate
	
		,String feeFree
	
		,String ynSeatLimit
	
		,Integer useSeatNumber
	
		,Integer rowSeatNumber
	
		,Integer highSeatNumber
	
		,Integer appliedSeatNumber
	
		,Integer programId
	
		,Integer programTypeId
	
		,Integer organId
	
		,String preventMultiApply
	
		,Integer timeCount
	
		,Integer subTimeCount
	
		,String closingAtFullSeat
	
		,Integer receiptMasterId
	
		,Integer appliedCount
	
		,Integer capacity
	
		,Integer maxRentalDays
	
		,Integer maxApplyCountPerDay
	
		,Integer multiApplyCountPerUser
	
		,String selectionEnd
	){
		super();
		
		this.name = name;
	
		this.category = category;
	
		this.extraCount = extraCount;
	
		this.seatCount = seatCount;
	
		this.acceptingMethod = acceptingMethod;
	
		this.includeGroup = includeGroup;
	
		this.includePersonel = includePersonel;
	
		this.feeUnit = feeUnit;
	
		this.fee = fee;
	
		this.receiptStartDate = receiptStartDate;
	
		this.receiptEndDate = receiptEndDate;
	
		this.attendingStartDate = attendingStartDate;
	
		this.attendingEndDate = attendingEndDate;
	
		this.feeFree = feeFree;
	
		this.ynSeatLimit = ynSeatLimit;
	
		this.useSeatNumber = useSeatNumber;
	
		this.rowSeatNumber = rowSeatNumber;
	
		this.highSeatNumber = highSeatNumber;
	
		this.appliedSeatNumber = appliedSeatNumber;
	
		this.programId = programId;
	
		this.programTypeId = programTypeId;
	
		this.organId = organId;
	
		this.preventMultiApply = preventMultiApply;
	
		this.timeCount = timeCount;
	
		this.subTimeCount = subTimeCount;
	
		this.closingAtFullSeat = closingAtFullSeat;
	
		this.receiptMasterId = receiptMasterId;
	
		this.appliedCount = appliedCount;
	
		this.capacity = capacity;
	
		this.maxRentalDays = maxRentalDays;
	
		this.maxApplyCountPerDay = maxApplyCountPerDay;
	
		this.multiApplyCountPerUser = multiApplyCountPerUser;
	
		this.selectionEnd = selectionEnd;
	
	
	}
	

	
	/**
	*	명칭
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
	*	카테고리
	*/
	private String category;
			
	/**
	 * @return category
	 */
	public String getCategory() {
		
			return category;
		
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
		
			return extraCount;
		
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
		
			return seatCount;
		
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
		
			return acceptingMethod;
		
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
		
			return includeGroup;
		
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
		
			return includePersonel;
		
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
		
			return feeUnit;
		
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
		
			return fee;
		
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
		
			return receiptStartDate;
		
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
		
			return receiptEndDate;
		
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
		
			return attendingStartDate;
		
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
		
			return attendingEndDate;
		
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
		
			return feeFree;
		
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
		
			return ynSeatLimit;
		
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
		
			return useSeatNumber;
		
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
		
			return rowSeatNumber;
		
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
		
			return highSeatNumber;
		
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
		
			return appliedSeatNumber;
		
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
		
			return programId;
		
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
		
			return programTypeId;
		
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
		
			return organId;
		
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
		
			return preventMultiApply;
		
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
		
			return timeCount;
		
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
		
			return subTimeCount;
		
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
		
			return closingAtFullSeat;
		
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
		
			return receiptMasterId;
		
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
		
			return appliedCount;
		
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
		
			return capacity;
		
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
		
			return maxRentalDays;
		
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
		
			return maxApplyCountPerDay;
		
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
		
			return multiApplyCountPerUser;
		
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
		
			return selectionEnd;
		
	}
	/**
	 * @return selectionEnd
	 */
	public void setSelectionEnd(String selectionEnd) {
		
			this.selectionEnd = selectionEnd;
		
		
	}
	
}