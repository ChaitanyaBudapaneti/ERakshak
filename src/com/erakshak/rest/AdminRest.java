/**
 * @(#)AdminRest.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2013 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erakshak.entity.Admin;
import com.erakshak.bo.AdminBO;

/**
 * @author chaitu
 *
 */
@Path("/admin")
public class AdminRest {
	private Admin admin;
	@Autowired
	private AdminBO adminBO;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Admin create(Admin admin) {
		try {
			adminBO.create(admin);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public Admin retrieveById() {
		try {
			admin = adminBO.retrieveById(admin.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		try {
			adminBO.delete(admin.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/retrievelist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> retrieveList() {
		List<Admin> adminList = new ArrayList<Admin>();
		try {
			adminList = adminBO.retrieveList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return adminList;
	}
}
