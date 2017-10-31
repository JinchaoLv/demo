package com.lvjc.model;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

public class ProjectDataLockerKey extends Model<ProjectDataLocker> {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bim5d_project_data_locker.project_id
     *
     * @mbggenerated
     */
    private String projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bim5d_project_data_locker.locker_id
     *
     * @mbggenerated
     */
    private Long lockerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bim5d_project_data_locker.project_id
     *
     * @return the value of bim5d_project_data_locker.project_id
     *
     * @mbggenerated
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bim5d_project_data_locker.project_id
     *
     * @param projectId the value for bim5d_project_data_locker.project_id
     *
     * @mbggenerated
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bim5d_project_data_locker.locker_id
     *
     * @return the value of bim5d_project_data_locker.locker_id
     *
     * @mbggenerated
     */
    public Long getLockerId() {
        return lockerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bim5d_project_data_locker.locker_id
     *
     * @param lockerId the value for bim5d_project_data_locker.locker_id
     *
     * @mbggenerated
     */
    public void setLockerId(Long lockerId) {
        this.lockerId = lockerId;
    }

    @Override
    protected Serializable pkVal() {
        return projectId;
    }
}