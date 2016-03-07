/**
 * @(#)ComplaintBOImpl.java  1.0   Dec 31, 2015
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

import com.erakshak.bo.ComplaintBO;
import com.erakshak.common.ChurnyResourceBundle;
import com.erakshak.common.ChurnyException;
import com.erakshak.dao.ComplaintDAO;
import com.erakshak.entity.Complaint;

/**
 * @author chaitu
 *
 */
@Service("ComplaintBO")
@Scope(value = "prototype")
public class ComplaintBOImpl implements ComplaintBO {
	private static final Log log = LogFactory.getLog(ComplaintBOImpl.class);

	@Autowired
	private ComplaintDAO complaintDAO;

	public void create(Complaint complaint) throws ChurnyException {
		try {
			if(complaint != null) {
				complaintDAO.create(complaint);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("ComplaintSaveFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("ComplaintSaveFailed"));
		}
	}

	public Complaint retrieveById(Integer complaintId) throws ChurnyException {
		Complaint complaint = new Complaint();
		try {
			if(complaintId == null || complaintId.intValue() == 0) {
				throw new ChurnyException(ChurnyResourceBundle.getMessage("InvalidInput"));
			}
			complaint = complaintDAO.findById(complaintId);
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("ComplaintRetrieveByIdFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("ComplaintRetrieveByIdFailed"));
		}
		return complaint;
	}

	public void delete(Integer complaintId) throws ChurnyException {
		try {
			if(complaintId != null && complaintId.intValue() != 0) {
				complaintDAO.delete(complaintId);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("ComplaintDeleteFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("ComplaintDeleteFailed"));
		}
	}

	public List<Complaint> retrieveList() throws ChurnyException {
		List<Complaint> complaintList = null;
		try {
			complaintList = complaintDAO.findAll();
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("ComplaintRetrieveListFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("ComplaintRetrieveListFailed"));
		}
		return complaintList;
	}
}
