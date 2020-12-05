package cn.youweisoft.authorization.server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the swd_user database table.
 * 
 */
@Entity
@Table(name="swd_user")
@NamedQuery(name="SwdUser.findAll", query="SELECT s FROM SwdUser s")
public class SwdUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private byte enabled;

	@JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	//uni-directional many-to-many association to SwdAuthority
//	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToMany
	@JoinTable(
		name="swd_user_authority"
		, joinColumns={
			@JoinColumn(name="USERNAME")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AUTHORITY_ID")
			}
		)
	private List<SwdAuthority> swdAuthorities;

	//uni-directional many-to-many association to SwdSysrole
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToMany
	@JoinTable(
		name="swd_user_sysrole"
		, joinColumns={
			@JoinColumn(name="USERNAME")
			}
		, inverseJoinColumns={
			@JoinColumn(name="SYSROLE_ID")
			}
		)
	private List<SwdSysrole> swdSysroles;

	public SwdUser() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SwdAuthority> getSwdAuthorities() {
		return this.swdAuthorities;
	}

	public void setSwdAuthorities(List<SwdAuthority> swdAuthorities) {
		this.swdAuthorities = swdAuthorities;
	}


	public List<SwdSysrole> getSwdSysroles() {
		return this.swdSysroles;
	}

	public void setSwdSysroles(List<SwdSysrole> swdSysroles) {
		this.swdSysroles = swdSysroles;
	}

}