/**
 * 
 */
package com.kastech.blumen.model.customize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author aamir.khan
 *
 */

@Entity
@Table(name = "pulldownitem" ,schema = "blumen2")
public class PullDownItem {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private Integer pullId;
	private long pulldownId;
	private Integer displayId;
    @Column(columnDefinition="boolean default true")
    private boolean active;
	private String name;

	public Integer getPullId() {
		return pullId;
	}

	public void setPullId(Integer pullId) {
		this.pullId = pullId;
	}

	public long getPulldownId() {
		return pulldownId;
	}
	public void setPulldownId(long pulldownId) {
		this.pulldownId = pulldownId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDisplayId() {
		return displayId;
	}
	public void setDisplayId(Integer displayId) {
		this.displayId = displayId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
}
