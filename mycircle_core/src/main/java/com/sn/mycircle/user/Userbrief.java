package com.sn.mycircle.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sn.mycircle.utils.MyCircleEntity;

@Entity
public class Userbrief implements MyCircleEntity {

	private static final long serialVersionUID = 4656103843455167985L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@OneToOne(mappedBy = "userbrief", cascade = javax.persistence.CascadeType.ALL)
	private Userdetail userdetail;

	@OneToMany
	@JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Role> roles;

	private String login;

	private String password;

	private Boolean active;

	private Boolean registration;

	public boolean compareLoginName(String login) {
		if (this.login.equals(login))
			return true;
		return false;
	}

	public boolean comparePassword(String password) {
		if (this.password.equals(password))
			return true;
		return false;
	}

	/**
	 * Create the UserDto from brief and detail info
	 * 
	 * @return return a complete user data
	 */
	public UserDto createUserDto() {
		UserDto dto = new UserDto();
		UserbriefDto userBrief = createUserBriefDto();
		UserdetailDto userDetail = this.userdetail.createUserDetailDto();
		dto.setUserBriefDto(userBrief);
		dto.setUserDetailDto(userDetail);
		return dto;
	}

	/**
	 * Create userbrief data
	 * 
	 * @return Userbrief data
	 */
	private UserbriefDto createUserBriefDto() {
		UserbriefDto dto = new UserbriefDto();
		dto.setActive(active);
		dto.setId(id);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setRegistration(registration);
		if (roles != null) {
			List<RoleDto> roleDtos = new ArrayList<RoleDto>();
			for (Role role : roles) {
				roleDtos.add(role.createDto());
			}
			dto.setRoles(roleDtos);
		}
		return dto;
	}

}
