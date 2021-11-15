package com.spacedev.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spacedev.board.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {

}
