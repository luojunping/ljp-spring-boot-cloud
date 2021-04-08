package com.ljp.test.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 优志愿签名方法
 */
public class SignUtils {

	private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);

	private static final String SIGN_KEY = "&1ebc37b92a8d488fb7e1b44594a340dd";

	/**
	 * 接口列表
	 */
	private static final String SCHOOL_URL = "http://106.75.118.194:5010/ToBIflytek/Users/OauthSchool";//（学校授权）
	private static final String STUDENT_URL = "http://106.75.118.194:5010/ToBIflytek/Users/Batch";//（用户批量操作）
	private static final String TEACHER_URL = "http://106.75.118.194:5010/ToBIflytek/Users/BatchTeacher";//（教员批量操作）
	private static final String SCHOOL_PROVINCE_URL = "http://106.75.118.194:5012/youzy.tog.iflytek.hook.school.province.update";//（批量修改一个学校学生省份操作）
//    private static final String SCHOOL_URL = "https://apigateway.youzy.cn/ToBIflytek/Users/OauthSchool";//（学校授权）
//    private static final String STUDENT_URL = "https://apigateway.youzy.cn/ToBIflytek/Users/Batch";//（用户批量操作）
//    private static final String TEACHER_URL = "https://apigateway.youzy.cn/ToBIflytek/Users/BatchTeacher";//（教员批量操作）
//    private static final String SCHOOL_PROVINCE_URL = "https://apigateway.youzy.cn/youzy.tog.iflytek.hook.school.province.update";//（批量修改一个学校学生省份操作）


	/**
	 * 修改学校所在省份
	 *
	 * @param entity
	 * @return
	 */
	public static JSONObject syncSchoolProvince(String entity) {
		return post(SCHOOL_PROVINCE_URL, entity);
	}

	/**
	 * 学校数据
	 *
	 * @param entity
	 * @return
	 */
	public static JSONObject syncSchoolInfo(String entity) {
		return post(SCHOOL_URL, entity);
	}

	/**
	 * 学校数据
	 *
	 * @param entity
	 * @return
	 */
	public static JSONObject syncStudentInfo(String entity) {
		return post(STUDENT_URL, entity);
	}

	/**
	 * 学校数据
	 *
	 * @param entity
	 * @return
	 */
	public static JSONObject syncTeacherInfo(String entity) {
		return post(TEACHER_URL, entity);
	}

	/**
	 * 发送签名请求
	 *
	 * @param url
	 * @param entity
	 * @return
	 */
	public static JSONObject post(String url, String entity) {

		JSONObject result = null;

		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000) //连接超时时间
					.setConnectionRequestTimeout(1000) //从连接池中取的连接的最长时间
					.setSocketTimeout(1000 * 1000) //数据传输的超时时间
					.build();
			//设置请求配置时间
			post.setConfig(requestConfig);
			ContentType contentType = ContentType.create("application/json", "UTF-8");
			StringEntity postingString = new StringEntity(entity, contentType);
			post.setEntity(postingString);
			post.setHeader("Youzy-Signature", MD5Utils.MD5Encode((entity + SIGN_KEY).toLowerCase(), "UTF-8").toLowerCase());
			HttpResponse response = httpClient.execute(post);
			String content = EntityUtils.toString(response.getEntity());

			result = (JSONObject) JSONObject.parse(content);

		} catch (ParseException | IOException e) {
			logger.error(e.getMessage(), e.getCause(), e);
		}
		logger.info("同步数据结果为:" + result);
		return result;
	}
}
