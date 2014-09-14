package com.pmease.gitplex.web.component.comment.event;

import org.apache.wicket.ajax.AjaxRequestTarget;

import com.pmease.gitplex.core.comment.Comment;
import com.pmease.gitplex.web.common.wicket.event.AjaxEvent;

public class CommentRemoved extends AjaxEvent {

	private final Comment comment;
	
	public CommentRemoved(AjaxRequestTarget target, Comment comment) {
		super(target);
		
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}

}