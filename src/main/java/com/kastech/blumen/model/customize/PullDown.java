package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pulldown" ,schema = "blumen2")
public class PullDown {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pulldown_seq_gen")
    @SequenceGenerator(name="pulldown_seq_gen", sequenceName="PULLDOWN_SEQ")
    private Long id;
    private String name;
    private String selectionType;
    private int active;
    private String apr;
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean editable;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> pullDownItems;
    private String orgId;
    
    @Column(unique = true)
    private String code;

    public PullDown() {
    }

    public PullDown(Long id, String name, String selectionType, int active, String apr, List<String> pullDownItems, String orgId, String code) {
        this.id = id;
        this.name = name;
        this.selectionType = selectionType;
        this.active = active;
        this.apr = apr;
        this.pullDownItems = pullDownItems;
        this.orgId = orgId;
        this.code = code;
    }
    
    
    public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

    public String getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(String selectionType) {
        this.selectionType = selectionType;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public List<String> getpullDownItems() {
        return pullDownItems;
    }

    public void setpullDownItems(List<String> pullDownItems) {
        this.pullDownItems = pullDownItems;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "PullDown{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selectionType='" + selectionType + '\'' +
                ", active='" + active + '\'' +
                ", apr='" + apr + '\'' +
                ", pullDownItems=" + pullDownItems +
                ", orgId='" + orgId + '\'' +
                '}';
    }

    public PullDown updateWith(PullDown item) {
        return new PullDown(
                this.id,
                item.name,
                item.selectionType,
                item.active,
                item.apr,
                item.pullDownItems,
                item.orgId,
                item.code
        );
    }
}
