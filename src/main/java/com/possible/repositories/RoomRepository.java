package com.possible.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.possible.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
