/**
 * @(#)PoliceStationRest.java  1.0   Dec 31, 2015
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

import com.erakshak.entity.PoliceStation;
import com.erakshak.bo.PoliceStationBO;

/**
 * @author chaitu
 *
 */
@Path("/policeStation")
public class PoliceStationRest {
	private PoliceStation policeStation;
	@Autowired
	private PoliceStationBO policeStationBO;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PoliceStation create(PoliceStation policeStation) {
		try {
			policeStationBO.create(policeStation);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return policeStation;
	}

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public PoliceStation retrieveById() {
		try {
			policeStation = policeStationBO.retrieveById(policeStation.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return policeStation;
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		try {
			policeStationBO.delete(policeStation.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/retrievelist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PoliceStation> retrieveList() {
		List<PoliceStation> policeStationList = new ArrayList<PoliceStation>();
		try {
			policeStationList = policeStationBO.retrieveList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return policeStationList;
	}
}
