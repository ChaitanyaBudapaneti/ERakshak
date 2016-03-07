/**
 * @(#)OfficerDAOImpl.java  1.0 Dec 31, 2015
 *
 * Copyright (c) 2013 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.daoimpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erakshak.common.GenericDaoImpl;
import com.erakshak.dao.OfficerDAO;
import com.erakshak.entity.Officer;

/**
 * A data access object (Dao) providing persistence and search support for
 * Officer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.erakshak.entity.Officer
 * @author MyEclipse Persistence Tools
 */

@Component("officerDAO")
@Scope(value="prototype")
public class OfficerDAOImpl extends GenericDaoImpl<Officer> implements OfficerDAO {

}
