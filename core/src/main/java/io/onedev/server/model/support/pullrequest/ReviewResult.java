package io.onedev.server.model.support.pullrequest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class ReviewResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String commit;
	
	private Boolean approved = false;
	
	@Lob
	@Column(length=65535)
	private String comment;
	
	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
