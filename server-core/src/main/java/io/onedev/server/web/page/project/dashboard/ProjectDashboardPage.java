package io.onedev.server.web.page.project.dashboard;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import io.onedev.server.util.SecurityUtils;
import io.onedev.server.web.page.project.ProjectPage;
import io.onedev.server.web.page.project.blob.ProjectBlobPage;
import io.onedev.server.web.page.project.issues.list.ProjectIssueListPage;

@SuppressWarnings("serial")
public class ProjectDashboardPage extends ProjectPage {

	public ProjectDashboardPage(PageParameters params) {
		super(params);
		
		if (SecurityUtils.canReadCode(getProject()))
			throw new RestartResponseException(ProjectBlobPage.class, ProjectBlobPage.paramsOf(getProject()));
		else 
			throw new RestartResponseException(ProjectIssueListPage.class, ProjectIssueListPage.paramsOf(getProject()));
		
	}

}
