package com.lvjc.domain;


import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.util.List;

public class ProjectListener {

	@PreRemove
	public void preRemove(Project project) throws Exception {
		/*AppdataClient client = AppConfig.getBean(AppdataClient.class) ;
		List<FileDTO> fileList = client.list(project.getWorkspaceId(), true, "/");
		if(fileList!=null){
			for (int i = 0; i < fileList.size(); i++){
				FileDTO file = fileList.get(i); 
				client.delete(project.getWorkspaceId(), project.isUseAppdata(), file.getFileId());
			}
		}*/
		
	}

	// BEGIN
	@PrePersist
	public void prePersist(Project project) throws Exception {
		/*ThreadContext context = ThreadContextHolder.ThreadContext.get();
		if(context==null||true!=ThreadContextHolder.ThreadContext.get().isCancelUpdateWorkspaceName()){
			WorkspaceClient workspaceClient = 	AppConfig.getBean(WorkspaceClient.class); 
			workspaceClient.update(project.getWorkspaceId(), project.getName());
		}*/
	}

	@PreUpdate
	public void preUpdate(Project project) throws Exception {
		/*ThreadContext context = ThreadContextHolder.ThreadContext.get();
		if(context==null||true!=ThreadContextHolder.ThreadContext.get().isCancelUpdateWorkspaceName()){
			WorkspaceClient workspaceClient = 	AppConfig.getBean(WorkspaceClient.class); 
			workspaceClient.update(project.getWorkspaceId(), project.getName());
		}*/
	}
	// END
}
