/**
 * @(#)CommisionerateRest.java  1.0   Dec 31, 2015
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

import com.erakshak.entity.Commisionerate;
import com.erakshak.bo.CommisionerateBO;

/**
 * @author chaitu
 *
 */
@Path("/commisionerate")
public class CommisionerateRest {
	private Commisionerate commisionerate;
	@Autowired
	private CommisionerateBO commisionerateBO;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Commisionerate create(Commisionerate commisionerate) {
		try {
			commisionerateBO.create(commisionerate);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return commisionerate;
	}

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public Commisionerate retrieveById() {
		try {
			commisionerate = commisionerateBO.retrieveById(commisionerate.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return commisionerate;
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		try {
			commisionerateBO.delete(commisionerate.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/retrievelist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commisionerate> retrieveList() {
		List<Commisionerate> commisionerateList = new ArrayList<Commisionerate>();
		try {
			commisionerateList = commisionerateBO.retrieveList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return commisionerateList;
	}
}
