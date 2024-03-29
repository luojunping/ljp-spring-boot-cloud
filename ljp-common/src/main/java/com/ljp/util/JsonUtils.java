package com.ljp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ljp.security.UserDTO;

import java.time.LocalDateTime;

/**
 * json工具类
 */
public final class JsonUtils {

    private static final JsonMapper JM = new JsonMapper();

    static {
        JM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    private JsonUtils() throws IllegalAccessException {
        throw new IllegalAccessException("JsonUtils can not be created !!!");
    }

    public static String toJSONString(Object object) {
        String content = null;
        try {
            content = JM.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return content;
    }

//    public static <T> T parseObject(String content, Class<T> clazz) {
//        T t = null;
//        try {
//            t = JM.readValue(content, new TypeReference<>() {
//                @Override
//                public Type getType() {
//                    return super.getType();
//                }
//            });
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return t;
//    }

//    public static <T> List<T> parseList(String content) {
//        List<T> l = null;
//        try {
//            l = JM.readValue(content, new TypeReference<>() {
//            });
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return l;
//    }

//    public static <T> T[] parseArray(String content) {
//        T[] array = null;
//        try {
//            array = (T[]) JM.readValue(content, new TypeReference() {
//            });
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return array;
//    }

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLoginName("zhangsan");
        userDTO.setLoginTime(LocalDateTime.now());
        String ss = JsonUtils.toJSONString(userDTO);
        System.out.println("ss = " + ss);
//        UserVO userVO = JsonUtils.parseObject(ss, UserVO.class);
//        System.out.println("userVO = " + userVO);
    }

}
