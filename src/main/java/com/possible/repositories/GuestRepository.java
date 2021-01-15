package com.possible.repositories;

import org.springframework.data.repository.CrudRepository;

import com.possible.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
