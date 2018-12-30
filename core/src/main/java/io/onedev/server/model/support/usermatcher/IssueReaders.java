package io.onedev.server.model.support.usermatcher;

import io.onedev.server.model.Project;
import io.onedev.server.model.User;
import io.onedev.server.security.permission.ProjectPermission;
import io.onedev.server.security.permission.ProjectPrivilege;
import io.onedev.server.web.editable.annotation.Editable;

@Editable(order=100, name="Users allowed to read issues")
public class IssueReaders implements UserMatcher {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean matches(Project project, User user) {
		return user.asSubject().isPermitted(new ProjectPermission(project.getFacade(), ProjectPrivilege.ISSUE_READ));
	}

}
