package com.lvjc.repository;
import com.lvjc.domain.Project;
import com.lvjc.domain.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ProjectRepositoryImpl implements ProjectService {
	private static final Logger logger = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

	JdbcTemplate jdbcTemplate;

	@Autowired
	void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void use(Project project) {
		/*TenantContextHolder.setContext(new TenantContext(project));

		this.jdbcTemplate.execute("use `" + project.getDbName() + "`;");*/
	}
	@Override
	public void useMasterCatalog() {
		/*TenantContextHolder.setContext(null);

		this.jdbcTemplate.execute("use `" + AppConfig.getBean(TenantDataSource.class).getDefaultCatalog() + "`;");*/
	}

	@Override
	public void dropDb(Project project) throws Exception {
		this.jdbcTemplate.execute("drop schema if exists `" + project.getDbName() + "`;");
	}

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public Project findOneAndValidate(String id) throws Exception {
		System.out.println("------------" + id + "-----------");
		return null;
	}
}
