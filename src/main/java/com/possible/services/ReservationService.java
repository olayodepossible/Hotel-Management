package com.possible.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.possible.model.Guest;
import com.possible.model.Reservation;
import com.possible.model.Room;
import com.possible.model.dto.RoomReservation;
import com.possible.repositories.GuestRepository;
import com.possible.repositories.ReservationRepository;
import com.possible.repositories.RoomRepository;

@Service
public class ReservationService {
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}



	public List<RoomReservation> getRoomReservationForDate(Date date){
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
		
		for(Room room : rooms) {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getRoomName());
			roomReservation.setRoomNumber(room.getRoomNunmber());
			
			roomReservationMap.put(room.getRoomId(), roomReservation);
		}
		
		Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
		
		for(Reservation reservation : reservations) {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setBookedDate(date);
			roomReservation.setGuestId(guest.getGuestId());
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			
		}
		
		List<RoomReservation> roomReservations = new ArrayList<>();
		
		for(Long id : roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		
		// sort function
		roomReservations.sort(new Comparator<RoomReservation>() {

			@Override
			public int compare(RoomReservation o1, RoomReservation o2) {
				if(o1.getRoomName() == o2.getRoomName()) {
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
				}
				return o1.getRoomName().compareTo(o2.getRoomName());
			}
			
		});
		
		
		return roomReservations;
	}

}
