package com.test;

import org.json.JSONObject;
import org.junit.Test;

public class RulesTest extends MountTest{

	
	//插入一条数据
	@Test
	public void test1() throws Exception{
		
		JSONObject jo=new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "getAllTitle");
		JSONObject param=new JSONObject();
		jo.put("param", param);
		
		
	}
	
	//查询所有脚本
	@Test
	public void test2() throws Exception {
		JSONObject jo=new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "getAllTitle");
		JSONObject param=new JSONObject();
		jo.put("param", param);
		exe(jo);
	}

	
}
