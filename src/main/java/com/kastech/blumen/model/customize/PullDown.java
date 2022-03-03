package com.kastech.blumen.model.customize;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pulldown" ,schema = "blumen2")
public class PullDown {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pulldown_seq_gen")
    @SequenceGenerator(name="pulldown_seq_gen", sequenceName="PULLDOWN_SEQ")
    private long id;
    private String name;
    private String selectionType;
    private int active;
    private String apr;
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean editable;

    @OneToMany(mappedBy = "pulldownId")
    private List<PullDownItem> pullDownItems;
    private String orgId;
    
    @Column(unique = true)
    private String code;

    public PullDown() {
    }

    public PullDown(long id, String name, String selectionType, int active, String apr,  String orgId, String code) {
        this.id = id;
        this.name = name;
        this.selectionType = selectionType;
        this.active = active;
        this.apr = apr;
        this.orgId = orgId;
        this.code = code;
    }
    
    public void addPullDownItems(List<PullDownItem> pullDownItemList) {
    	if(pullDownItems==null)
    		pullDownItems = new ArrayList<PullDownItem>();
    	pullDownItems.addAll(pullDownItemList);
    }
    
    public void deletePullDownItems(List<PullDownItem> pullDownItemList) {
    	if(pullDownItems!=null)
    		pullDownItems.removeAll(pullDownItemList);
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

	public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<PullDownItem> getpullDownItems() {
        return pullDownItems;
    }

    public void setpullDownItems(List<PullDownItem> pullDownItems) {
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

}
