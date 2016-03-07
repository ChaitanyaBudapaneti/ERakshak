/**
 * @(#)OfficerBO.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2014 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.bo;

import java.util.List;

import com.erakshak.common.ChurnyException;
import com.erakshak.entity.Officer;

/**
 * @author chaitu
 *
 */
public interface OfficerBO {
	void create(Officer officer) throws ChurnyException;
	Officer retrieveById(Integer officerId) throws ChurnyException;
	void delete(Integer officerId) throws ChurnyException;
	List<Officer> retrieveList() throws ChurnyException;
}
