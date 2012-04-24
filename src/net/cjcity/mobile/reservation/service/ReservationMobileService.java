package net.cjcity.mobile.reservation.service;

import net.cjcity.mobile.reservation.entity.BaseCriteria;
import net.cjcity.mobile.reservation.entity.PageList;
import net.cjcity.mobile.reservation.entity.ReservationOrgan;
import net.cjcity.mobile.reservation.entity.ReservationProgram;
import net.cjcity.mobile.reservation.entity.ReservationReceipt;

public interface ReservationMobileService {
	PageList getOrgans(BaseCriteria criteria);
	ReservationOrgan getOrgan(Integer organId);
	PageList getPrograms(BaseCriteria criteria);
	ReservationProgram getProgram(Integer programId);
	PageList getReceipts(BaseCriteria criteria);
	ReservationReceipt getReceipt(Integer organId);
	ReservationOrgan getNextOrgan(Integer organId);
	ReservationOrgan getPrevOrgan(Integer organId);
	ReservationProgram getNextProgram(Integer programId);
	ReservationProgram getPrevProgram(Integer programId);
}
