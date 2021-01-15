package com.possible.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {
	@Id
	@Column(name="ROOM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roomId;
	
	@Column(name="NAME")
	private String roomName;
	
	@Column(name="ROOM_NUMBER")
	private String roomNunmber;
	
	@Column(name="BED_INFO")
	private String bedInfo;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomNunmber() {
		return roomNunmber;
	}

	public void setRoomNunmber(String roomNunmber) {
		this.roomNunmber = roomNunmber;
	}

	public String getBedInfo() {
		return bedInfo;
	}

	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
	
	



}
