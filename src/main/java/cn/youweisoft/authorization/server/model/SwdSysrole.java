package cn.youweisoft.authorization.server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The persistent class for the swd_sysrole database table.
 * 
 */
@Entity
@Table(name="swd_sysrole")
@NamedQuery(name="SwdSysrole.findAll", query="SELECT s FROM SwdSysrole s")
public class SwdSysrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;

	//uni-directional many-to-many association to SwdAuthority
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="swd_sysrole_authority"
		, joinColumns={
			@JoinColumn(name="SYSROLE_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AUTHORITY_ID")
			}
		)
	private List<SwdAuthority> swdAuthorities;


	public SwdSysrole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SwdAuthority> getSwdAuthorities() {
		return this.swdAuthorities;
	}

	public void setSwdAuthorities(List<SwdAuthority> swdAuthorities) {
		this.swdAuthorities = swdAuthorities;
	}
}