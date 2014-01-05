package com.sn.mycircle.jpa;

import org.springframework.stereotype.Repository;

import com.sn.mycircle.dao.GenericDaoJpa;
import com.sn.mycircle.user.Userbrief;
import com.sn.mycircle.user.UserbriefDao;

@Repository("userbriefDao")
public class UserbriefDaoJpa extends GenericDaoJpa<Userbrief> implements UserbriefDao{

	public UserbriefDaoJpa() {
		super(Userbrief.class);		
	}

}
