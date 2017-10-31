package com.lvjc.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Cacheable
@EntityListeners(ProjectListener.class)
public class Project extends AbstractAuditable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    String name;

    String guid;

    String rendering;

    String renderingHash;

    String workspaceId;

  
	String dbName;
    float scale;

    float  				   contractMoney; //合同额
    Date    			   contractDate; //合同额日期
	Date    			   startDate; //开始时间
    Date    			   finishDate; //结束时间
    String				   owner;//业主
    String                 buildingStructure;//结构类型
    String				   projectStatus;//项目状态
    String				   projectType;//投资类型
    String				   structureType;//产业结构
    String				   scaleType;//项目规模;
    String				   specialtyType;//专业资质
    String				   remark;//备注
    String				   continents;//大洲
    String				   country;//国家
    String				   province;//省
    String				   city;//城市
    String				   location;//详细地址
    
    int				       blueprintType;//默认图纸 1:楼层,2:流水段
    Integer				   cooperateDataFormat;//0:老数据格式；1：新数据格式
    String				   appVersion;
    int				       upgradFlag = 1; //新老项目升级标记（0老项目1新版本） -- 此代码是新版本代码，老的分支代码不再设置这个值，使用默认值

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id.project", orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OrderBy("name")
    /*@JsonIgnore
    Set<Member> members = new HashSet<Member>();*/

    boolean useAppdata = true;

    int type;

    String orgId;
    public Project() {

    }
    
    public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

    public Project(String id) {
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRendering() {
        return rendering;
    }

    public void setRendering(String rendering) {
        this.rendering = rendering;
    }

    public String getRenderingHash() {
        return renderingHash;
    }

    public void setRenderingHash(String renderingHash) {
        this.renderingHash = renderingHash;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

   /* public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Member getMember(String userId) {
        for (Member member : this.members)
            if (member.getId().equals(new MemberPK(this, userId)))
                return member;

        return null;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }*/

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public boolean isUseAppdata() {
        return useAppdata;
    }

    public void setUseAppdata(boolean useAppdata) {
        this.useAppdata = useAppdata;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
    public float getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(float contractMoney) {
		this.contractMoney = contractMoney;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(String buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public String getScaleType() {
		return scaleType;
	}

	public void setScaleType(String scaleType) {
		this.scaleType = scaleType;
	}

	public String getSpecialtyType() {
		return specialtyType;
	}

	public void setSpecialtyType(String specialtyType) {
		this.specialtyType = specialtyType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContinents() {
		return continents;
	}

	public void setContinents(String continents) {
		this.continents = continents;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCooperateDataFormat() {
		return cooperateDataFormat;
	}

	public void setCooperateDataFormat(Integer cooperateDataFormat) {
		this.cooperateDataFormat = cooperateDataFormat;
	}

	public int getBlueprintType() {
		return blueprintType;
	}

	public void setBlueprintType(int blueprintType) {
		this.blueprintType = blueprintType;
	}

	public int getUpgradFlag() {
		return upgradFlag;
	}

	public void setUpgradFlag(int upgradFlag) {
		this.upgradFlag = upgradFlag;
	}

	/*@Override
    public HashMap<String, Object> toModel() {
        HashMap<String, Object> model = super.toModel();
        model.put("name", this.name);
        model.put("workspaceId", this.workspaceId);
        model.put("type", type);
        model.put("guid", this.guid);
        model.put("rendering", this.rendering);
        model.put("scale", this.scale);
        model.put("org_id", this.orgId);
        model.put("project_status", this.projectStatus);
        model.put("projectStatus", this.projectStatus);
        
        model.put("contractMoney", this.contractMoney);
        model.put("contractDate", this.contractDate);
        model.put("startDate", this.startDate);
        model.put("finishDate", this.finishDate);
        model.put("owner", this.owner);
        model.put("buildingStructure", this.buildingStructure);
        model.put("projectType", this.projectType);
        model.put("structureType", this.structureType);
        model.put("scaleType", this.scaleType);
        model.put("specialtyType", this.specialtyType);
        model.put("remark", this.remark);
        model.put("continents", this.continents);
        model.put("country", this.country);
        model.put("province", this.province);
        model.put("city", this.city);
        model.put("location", this.location);
        model.put("blueprintType", this.blueprintType);
        model.put("cooperateDataFormat", this.cooperateDataFormat);

//        model.put("rendering_download_url", null);
//        if (StringUtils.hasText(this.rendering)) {
//            String root = this.useAppdata ? "appdata" : "file";
//            model.put("rendering_download_url", String.format("https://api.glodon.com/workspace/%s/%s/id/%s?content", this.workspaceId, root, this.rendering));
//        }

        model.put("rendering_hash", this.renderingHash);

        return model;
    }*/
}
