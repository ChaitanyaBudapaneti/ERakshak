/**
 * @(#)AdminBOImpl.java  1.0   Dec 31, 2015
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

import com.erakshak.bo.AdminBO;
import com.erakshak.common.ChurnyResourceBundle;
import com.erakshak.common.ChurnyException;
import com.erakshak.dao.AdminDAO;
import com.erakshak.entity.Admin;

/**
 * @author chaitu
 *
 */
@Service("AdminBO")
@Scope(value = "prototype")
public class AdminBOImpl implements AdminBO {
	private static final Log log = LogFactory.getLog(AdminBOImpl.class);

	@Autowired
	private AdminDAO adminDAO;

	public void create(Admin admin) throws ChurnyException {
		try {
			if(admin != null) {
				adminDAO.create(admin);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("AdminSaveFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("AdminSaveFailed"));
		}
	}

	public Admin retrieveById(Integer adminId) throws ChurnyException {
		Admin admin = new Admin();
		try {
			if(adminId == null || adminId.intValue() == 0) {
				throw new ChurnyException(ChurnyResourceBundle.getMessage("InvalidInput"));
			}
			admin = adminDAO.findById(adminId);
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("AdminRetrieveByIdFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("AdminRetrieveByIdFailed"));
		}
		return admin;
	}

	public void delete(Integer adminId) throws ChurnyException {
		try {
			if(adminId != null && adminId.intValue() != 0) {
				adminDAO.delete(adminId);
			}
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("AdminDeleteFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("AdminDeleteFailed"));
		}
	}

	public List<Admin> retrieveList() throws ChurnyException {
		List<Admin> adminList = null;
		try {
			adminList = adminDAO.findAll();
		}
		catch(ChurnyException pcme) {
			throw pcme;
		}
		catch(Exception e) {
			log.error(ChurnyResourceBundle.getMessage("AdminRetrieveListFailed"), e);
			throw new ChurnyException(ChurnyResourceBundle.getMessage("AdminRetrieveListFailed"));
		}
		return adminList;
	}
}
