/**
 * @(#)AdminBO.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2014 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.bo;

import java.util.List;

import com.erakshak.common.ChurnyException;
import com.erakshak.entity.Admin;

/**
 * @author chaitu
 *
 */
public interface AdminBO {
	void create(Admin admin) throws ChurnyException;
	Admin retrieveById(Integer adminId) throws ChurnyException;
	void delete(Integer adminId) throws ChurnyException;
	List<Admin> retrieveList() throws ChurnyException;
}
