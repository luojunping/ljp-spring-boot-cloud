package com.ljp.test.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "youzhiyuan_data_sync_school_province")
public class DataSyncSchoolProvince extends BaseInfo {

	private String schoolId;
	private String schoolName;
	private String schoolType;
	private String provinceName;
	/**
	 * 0：无变化；1：修改学校所在的省份；
	 */
	private String operate;
	private String createTime;
	private String updateTime;

}
