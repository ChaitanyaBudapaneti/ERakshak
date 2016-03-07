/**
 * @(#)ComplaintBO.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2014 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.bo;

import java.util.List;

import com.erakshak.common.ChurnyException;
import com.erakshak.entity.Complaint;

/**
 * @author chaitu
 *
 */
public interface ComplaintBO {
	void create(Complaint complaint) throws ChurnyException;
	Complaint retrieveById(Integer complaintId) throws ChurnyException;
	void delete(Integer complaintId) throws ChurnyException;
	List<Complaint> retrieveList() throws ChurnyException;
}
