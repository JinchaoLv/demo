package com.lvjc.domain;


import com.lvjc.domain.Project;
import com.lvjc.repository.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String>, ProjectService {


	@Query("select p from Project p where delete_flag <> 1 and p.workspaceId in ?1")
    Page<Project> findByUser(List<String> workspaces, Pageable pageable);
	
	@Query("select p from Project p where delete_flag <> 1 and p.workspaceId in ?1")
	List<Project> findByUser(List<String> workspaces);


    List<Project> findByCreatedBy(String createdBy);

    Page<Project> findByCreatedBy(String createdBy, Pageable pageable);

    @Query("select p from Project p where delete_flag <> 1")
    Page<Project> findByAll(Pageable pageable);
}
