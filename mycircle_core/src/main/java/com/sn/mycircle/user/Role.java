package com.sn.mycircle.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sn.mycircle.utils.MyCircleEntity;

@Entity
public class Role implements MyCircleEntity{

	private static final long serialVersionUID = -2492871602893665223L;

	@Id
	@Column(name = "id_role")
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	public RoleDto createDto(){
		RoleDto dto = new RoleDto();
		dto.setName(name);
		return dto;
	}
}
