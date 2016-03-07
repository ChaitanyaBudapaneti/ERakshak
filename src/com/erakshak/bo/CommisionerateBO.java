/**
 * @(#)CommisionerateBO.java  1.0   Dec 31, 2015
 * 
 * Copyright (c) 2014 PrimesoftInc.
 * All rights reserved.
 *
 */

package com.erakshak.bo;

import java.util.List;

import com.erakshak.common.ChurnyException;
import com.erakshak.entity.Commisionerate;

/**
 * @author chaitu
 *
 */
public interface CommisionerateBO {
	void create(Commisionerate commisionerate) throws ChurnyException;
	Commisionerate retrieveById(Integer commisionerateId) throws ChurnyException;
	void delete(Integer commisionerateId) throws ChurnyException;
	List<Commisionerate> retrieveList() throws ChurnyException;
}
