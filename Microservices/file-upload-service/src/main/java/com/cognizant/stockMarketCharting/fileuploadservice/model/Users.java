package com.cognizant.stockMarketCharting.fileuploadservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;

@Entity
@Table(name="user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	@NotNull
	private int id;
	
	@Column(name="us_user_name")
	@NotNull
	private String userName;
	
	@Column(name="us_password")
	@NotNull
	private String password;
	
	@Column(name="us_email")
	@NotNull
	private String email;
	
	@Column(name="us_contact_number")
	@NotNull
	private String contactNumber;
	
	@Column(name="us_confirmed")
	@NotNull
	private boolean confirmed;
	

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
    private Set<Role> roleList;

	public Users(@NotNull int id, @NotNull String userName, @NotNull String password, @NotNull String email,
			@NotNull String contactNumber, @NotNull boolean confirmed, Set<Role> roleList) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.confirmed = confirmed;
		this.roleList = roleList;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(@NotNull int id, @NotNull String userName, @NotNull String password, @NotNull String email,
			@NotNull String contactNumber, @NotNull boolean confirmed) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.confirmed = confirmed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", confirmed=" + confirmed + ", roleList=" + roleList + "]";
	}
	
}
