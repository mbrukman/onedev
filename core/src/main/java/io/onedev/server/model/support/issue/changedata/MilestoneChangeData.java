package io.onedev.server.model.support.issue.changedata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.wicket.Component;

import io.onedev.server.model.Group;
import io.onedev.server.model.Issue;
import io.onedev.server.model.IssueAction;
import io.onedev.server.model.Milestone;
import io.onedev.server.model.User;
import io.onedev.server.model.support.CommentSupport;
import io.onedev.server.util.diff.DiffUtils;
import io.onedev.server.web.component.diff.plain.PlainDiffPanel;
import io.onedev.utils.HtmlUtils;

public class MilestoneChangeData implements ActionData {

	private static final long serialVersionUID = 1L;

	private final String oldMilestone;
	
	private final String newMilestone;
	
	public MilestoneChangeData(@Nullable Milestone oldMilestone, @Nullable Milestone newMilestone) {
		this.oldMilestone = oldMilestone!=null?oldMilestone.getName():null;
		this.newMilestone = newMilestone!=null?newMilestone.getName():null;
	}
	
	@Override
	public Component render(String componentId, IssueAction action) {
		return new PlainDiffPanel(componentId, getOldLines(), null, getNewLines(), null, true);
	}
	
	@Override
	public List<String> getOldLines() {
		List<String> oldLines = new ArrayList<>();
		if (oldMilestone != null)
			oldLines.add("Milestone: " + oldMilestone);
		else
			oldLines.add("Milestone: ");
		return oldLines;
	}

	@Override
	public List<String> getNewLines() {
		List<String> newLines = new ArrayList<>();
		if (newMilestone != null)
			newLines.add("Milestone: " + newMilestone);
		else
			newLines.add("Milestone: ");
		return newLines;
	}
	
	public String getOldMilestone() {
		return oldMilestone;
	}

	public String getNewMilestone() {
		return newMilestone;
	}

	@Override
	public String getTitle(IssueAction action, boolean external) {
		Issue issue = action.getIssue();
		if (external) 
			return String.format("[Milestone Changed] Issue #%d: %s", issue.getNumber(), issue.getTitle());  
		else 
			return "changed milestone";
	}

	@Override
	public String describeAsHtml(IssueAction action) {
		String escaped = HtmlUtils.escapeHtml(action.getUser().getDisplayName());
		StringBuilder builder = new StringBuilder(String.format("<b>%s changed milestone</b>", escaped));
		builder.append("<p style='margin: 16px 0;'>");
		builder.append(DiffUtils.diffAsHtml(getOldLines(), null, getNewLines(), null, true));
		return builder.toString();
	}

	@Override
	public CommentSupport getCommentSupport() {
		return null;
	}

	@Override
	public Map<String, User> getNewUsers() {
		return new HashMap<>();
	}

	@Override
	public Map<String, Group> getNewGroups() {
		return new HashMap<>();
	}
	
}
