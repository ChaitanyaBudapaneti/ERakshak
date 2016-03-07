/**
 * @(#)ComplaintDAOImpl.java  1.0 Dec 31, 2015
 *
 * Copyright (c) 2013 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.daoimpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erakshak.common.GenericDaoImpl;
import com.erakshak.dao.ComplaintDAO;
import com.erakshak.entity.Complaint;

/**
 * A data access object (Dao) providing persistence and search support for
 * Complaint entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.erakshak.entity.Complaint
 * @author MyEclipse Persistence Tools
 */

@Component("complaintDAO")
@Scope(value="prototype")
public class ComplaintDAOImpl extends GenericDaoImpl<Complaint> implements ComplaintDAO {

}
