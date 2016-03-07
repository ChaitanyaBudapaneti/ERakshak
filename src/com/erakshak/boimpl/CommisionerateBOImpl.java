/**
 * @(#)CommisionerateBOImpl.java  1.0   Dec 31, 2015
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

import com.erakshak.bo.CommisionerateBO;
import com.erakshak.common.ChurnyResourceBundle;
import com.erakshak.common.ChurnyException;
import com.erakshak.dao.CommisionerateDAO;
import com.erakshak.entity.Commisionerate;

/**
 * @author chaitu
 *
 */
@Service("CommisionerateBO")
@Scope(value = "prototype")
public class CommisionerateBOImpl implements CommisionerateBO {
	private static final Log log = LogFactory.getLog(CommisionerateBOImpl.class);

	@Autowired
	private CommisionerateDAO commisionerateDAO;

	public void create(Commisionerate commisionerate) throws ChurnyException {
		try {
			if(commisionerate != null) {
				commisionerateDAO.create(commisionerate);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("CommisionerateSaveFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("CommisionerateSaveFailed"));
		}
	}

	public Commisionerate retrieveById(Integer commisionerateId) throws ChurnyException {
		Commisionerate commisionerate = new Commisionerate();
		try {
			if(commisionerateId == null || commisionerateId.intValue() == 0) {
				throw new ChurnyException(ChurnyResourceBundle.getMessage("InvalidInput"));
			}
			commisionerate = commisionerateDAO.findById(commisionerateId);
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("CommisionerateRetrieveByIdFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("CommisionerateRetrieveByIdFailed"));
		}
		return commisionerate;
	}

	public void delete(Integer commisionerateId) throws ChurnyException {
		try {
			if(commisionerateId != null && commisionerateId.intValue() != 0) {
				commisionerateDAO.delete(commisionerateId);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("CommisionerateDeleteFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("CommisionerateDeleteFailed"));
		}
	}

	public List<Commisionerate> retrieveList() throws ChurnyException {
		List<Commisionerate> commisionerateList = null;
		try {
			commisionerateList = commisionerateDAO.findAll();
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("CommisionerateRetrieveListFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("CommisionerateRetrieveListFailed"));
		}
		return commisionerateList;
	}
}
