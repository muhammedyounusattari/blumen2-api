package com.kastech.blumen.model.student.contacts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "activity_rendered", schema = "blumen2")
public class ActivityRendered {
	
	 public ActivityRendered() {
	    }

	    public ActivityRendered(Long id, String activity, int totalTime) {
	        this.id = id;
	        this.activity = activity;
	        this.totalTime = totalTime;
	    }

	    @Id
	    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="activity_rendered_list_seq_gen")
	    @SequenceGenerator(name="activity_rendered_list_seq_gen", sequenceName="ACTIVITY_RENDERED_LIST_SEQ")
	    private Long id;

//	    @OneToOne(mappedBy = "activityId")
//	    private ActivityList activity;
	    private String activity;
	    private int totalTime;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getActivity() {
	        return activity;
	    }

	    public void setActivity(String activity) {
	        this.activity = activity;
	    }

	    public int getTotalTime() {
	        return totalTime;
	    }

	    public void setTotalTime(int totalTime) {
	        this.totalTime = totalTime;
	    }

	    @Override
	    public String toString() {
	        return "ActivityRendered{" +
	                "id=" + id +
	                ", activity=" + activity +
	                ", totalTime='" + totalTime + '\'' +
	                '}';
	    }

}
