package io.reflectoring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARMAGroups", schema = "dbo")
public class Groups {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "source")
	private String source;

	@ManyToOne
	@JoinTable(name = "ARMAUsers_ARMAGroups", schema = "dbo", 
	        joinColumns = {@JoinColumn(name = "ARMAGroups_id", referencedColumnName = "id") }, 
	        inverseJoinColumns = {@JoinColumn(name = "ARMAUser_id", referencedColumnName = "id") })
	private ARMAUser user;

	public Groups() {
	}

	public ARMAUser getUser() {
		return user;
	}

	public void setUser(ARMAUser user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
