/**
 * @(#)OfficerBOImpl.java  1.0   Dec 31, 2015
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

import com.erakshak.bo.OfficerBO;
import com.erakshak.common.ChurnyResourceBundle;
import com.erakshak.common.ChurnyException;
import com.erakshak.dao.OfficerDAO;
import com.erakshak.entity.Officer;

/**
 * @author chaitu
 *
 */
@Service("OfficerBO")
@Scope(value = "prototype")
public class OfficerBOImpl implements OfficerBO {
	private static final Log log = LogFactory.getLog(OfficerBOImpl.class);

	@Autowired
	private OfficerDAO officerDAO;

	public void create(Officer officer) throws ChurnyException {
		try {
			if(officer != null) {
				officerDAO.create(officer);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("OfficerSaveFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("OfficerSaveFailed"));
		}
	}

	public Officer retrieveById(Integer officerId) throws ChurnyException {
		Officer officer = new Officer();
		try {
			if(officerId == null || officerId.intValue() == 0) {
				throw new ChurnyException(ChurnyResourceBundle.getMessage("InvalidInput"));
			}
			officer = officerDAO.findById(officerId);
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("OfficerRetrieveByIdFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("OfficerRetrieveByIdFailed"));
		}
		return officer;
	}

	public void delete(Integer officerId) throws ChurnyException {
		try {
			if(officerId != null && officerId.intValue() != 0) {
				officerDAO.delete(officerId);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("OfficerDeleteFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("OfficerDeleteFailed"));
		}
	}

	public List<Officer> retrieveList() throws ChurnyException {
		List<Officer> officerList = null;
		try {
			officerList = officerDAO.findAll();
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("OfficerRetrieveListFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("OfficerRetrieveListFailed"));
		}
		return officerList;
	}
}
