package com.possible.web;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.possible.helpUtils.DateUtils;
import com.possible.model.dto.RoomReservation;
import com.possible.services.ReservationService;

class RoomReservationWebControllerTest {
	@MockBean
	private ReservationService reservationService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void getReservations() throws Exception {
		String dateString = "2020-01-01";
		Date date = DateUtils.createDateFromDateString(dateString);
		
		List<RoomReservation> roomReservations = new ArrayList<>();
		
		RoomReservation roomReservation = new RoomReservation();
		roomReservation.setRoomId(129L);
		roomReservation.setRoomName("JUnit-5");
		roomReservation.setRoomNumber("J1");
		roomReservation.setGuestId(1L);
		roomReservation.setFirstName("Unit");
		roomReservation.setLastName("JUnit5");
		roomReservation.setBookedDate(date);
		
		roomReservations.add(roomReservation);
		
		 
		
	}

}
