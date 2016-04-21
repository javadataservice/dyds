package com.service;

import java.util.Map;

public interface IService {
	// 分词
	public static String SERVICE_FC = "fc";
	// 拼音
	public static String SERVICE_PY = "py";
	// 索引
	public static String SERVICE_INDEX = "sy";
	// 检索策略
	public static String SERVICE_RULE = "rules";

	public String execute(Map<String, String> params);

	public String getType();

}
