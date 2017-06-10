package com.apo;

import java.security.NoSuchAlgorithmException;

import com.apo.model.Admin;

public interface AdminMethods {

	void close();

	//addUser
	boolean addUser(String userName, String password) throws NoSuchAlgorithmException;

	// authenticate
	Admin authenticate(String userName, String password) throws NoSuchAlgorithmException;


	//md5 hash
	String encrypt(String password) throws NoSuchAlgorithmException;

}