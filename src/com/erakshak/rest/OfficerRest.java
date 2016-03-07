/**
 * @(#)OfficerRest.java  1.0   Dec 31, 2015
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

import com.erakshak.entity.Officer;
import com.erakshak.bo.OfficerBO;

/**
 * @author chaitu
 *
 */
@Path("/officer")
public class OfficerRest {
	private Officer officer;
	@Autowired
	private OfficerBO officerBO;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Officer create(Officer officer) {
		try {
			officerBO.create(officer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return officer;
	}

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public Officer retrieveById() {
		try {
			officer = officerBO.retrieveById(officer.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return officer;
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		try {
			officerBO.delete(officer.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/retrievelist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Officer> retrieveList() {
		List<Officer> officerList = new ArrayList<Officer>();
		try {
			officerList = officerBO.retrieveList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return officerList;
	}
}
