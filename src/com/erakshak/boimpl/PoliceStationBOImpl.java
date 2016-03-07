/**
 * @(#)PoliceStationBOImpl.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2014 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.boimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erakshak.bo.PoliceStationBO;
import com.erakshak.common.ChurnyResourceBundle;
import com.erakshak.common.ChurnyException;
import com.erakshak.dao.PoliceStationDAO;
import com.erakshak.entity.PoliceStation;

/**
 * @author chaitu
 *
 */
@Service("PoliceStationBO")
@Scope(value = "prototype")
public class PoliceStationBOImpl implements PoliceStationBO {
	private static final Log log = LogFactory.getLog(PoliceStationBOImpl.class);

	@Autowired
	private PoliceStationDAO policeStationDAO;

	public void create(PoliceStation policeStation) throws ChurnyException {
		try {
			if(policeStation != null) {
				policeStationDAO.create(policeStation);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("PoliceStationSaveFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("PoliceStationSaveFailed"));
		}
	}

	public PoliceStation retrieveById(Integer policeStationId) throws ChurnyException {
		PoliceStation policeStation = new PoliceStation();
		try {
			if(policeStationId == null || policeStationId.intValue() == 0) {
				throw new ChurnyException(ChurnyResourceBundle.getMessage("InvalidInput"));
			}
			policeStation = policeStationDAO.findById(policeStationId);
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("PoliceStationRetrieveByIdFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("PoliceStationRetrieveByIdFailed"));
		}
		return policeStation;
	}

	public void delete(Integer policeStationId) throws ChurnyException {
		try {
			if(policeStationId != null && policeStationId.intValue() != 0) {
				policeStationDAO.delete(policeStationId);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("PoliceStationDeleteFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("PoliceStationDeleteFailed"));
		}
	}

	public List<PoliceStation> retrieveList() throws ChurnyException {
		List<PoliceStation> policeStationList = null;
		try {
			policeStationList = policeStationDAO.findAll();
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("PoliceStationRetrieveListFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("PoliceStationRetrieveListFailed"));
		}
		return policeStationList;
	}
}
