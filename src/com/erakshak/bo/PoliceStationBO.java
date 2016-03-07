/**
 * @(#)PoliceStationBO.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2014 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.bo;

import java.util.List;

import com.erakshak.common.ChurnyException;
import com.erakshak.entity.PoliceStation;

/**
 * @author chaitu
 *
 */
public interface PoliceStationBO {
	void create(PoliceStation policeStation) throws ChurnyException;
	PoliceStation retrieveById(Integer policeStationId) throws ChurnyException;
	void delete(Integer policeStationId) throws ChurnyException;
	List<PoliceStation> retrieveList() throws ChurnyException;
}
