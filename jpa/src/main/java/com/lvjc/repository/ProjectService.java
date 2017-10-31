package com.lvjc.repository;


import com.lvjc.domain.Project;

public interface ProjectService {

	void use(Project project);
	//使用默认库
	void useMasterCatalog();

	void dropDb(Project project) throws Exception;

	Project findOneAndValidate(String id) throws Exception;

}
