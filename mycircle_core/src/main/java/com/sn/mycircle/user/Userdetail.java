package com.sn.mycircle.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sn.mycircle.utils.MyCircleEntity;

@Entity
public class Userdetail implements MyCircleEntity{

	private static final long serialVersionUID = 3855238847533025158L;

	@Id
	@Column(name = "idProfil")
	@GeneratedValue
	private Integer id;
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL, fetch =FetchType.EAGER)
	@JoinColumn(name = "idUserBrief")
	private Userbrief userbrief;
	
	private String firstName;
	
	private String lastName;
	
	private Boolean gender;
	
	private Date birthday;
	
	private Date lastModifiedTime;
	
	private Integer language;
	
	private String introduction;
	
	private String address;
	
	private String telephone;

	/**
	 * Create user detail data
	 * @return user detail data
	 */
	public UserdetailDto createUserDetailDto() {
		UserdetailDto dto = new UserdetailDto();
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setGender(gender);
		dto.setBirthday(birthday);
		dto.setLastModifiedTime(lastModifiedTime);
		dto.setLanguage(language);
		dto.setIntroduction(introduction);
		dto.setAddress(address);
		dto.setTelephone(telephone);
		return dto;
	}
	


}
