/**
 * @(#)ComplaintRest.java  1.0   Dec 31, 2015
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

import com.erakshak.entity.Complaint;
import com.erakshak.bo.ComplaintBO;

/**
 * @author chaitu
 *
 */
@Path("/complaint")
public class ComplaintRest {
	private Complaint complaint;
	@Autowired
	private ComplaintBO complaintBO;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Complaint create(Complaint complaint) {
		try {
			complaintBO.create(complaint);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return complaint;
	}

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public Complaint retrieveById() {
		try {
			complaint = complaintBO.retrieveById(complaint.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return complaint;
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		try {
			complaintBO.delete(complaint.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/retrievelist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Complaint> retrieveList() {
		List<Complaint> complaintList = new ArrayList<Complaint>();
		try {
			complaintList = complaintBO.retrieveList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return complaintList;
	}
}
