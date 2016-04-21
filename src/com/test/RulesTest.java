package com.test;

import org.json.JSONObject;
import org.junit.Test;

public class RulesTest extends MountTest {

	// 插入一条数据
	@Test
	public void test1() throws Exception {

		JSONObject jo = new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "insert");
		JSONObject param = new JSONObject();
		jo.put("param", param);
		param.put("name", "名称");
		param.put("desc", "描述");
		param.put("dataNode", "数据节点");
		param.put("datas", "脚本数据");
		param.put("clsid", "4");
		exe(jo);

	}

	// 查询所有脚本
	@Test
	public void test2() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "getAllTitle");
		JSONObject param = new JSONObject();
		jo.put("param", param);
		exe(jo);
	}

	// 根据ID查询某个脚本的数据
	@Test
	public void test3() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "getOne");
		JSONObject param = new JSONObject();
		jo.put("param", param);
		param.put("rules_id", "3");
		exe(jo);
	}

	// 删除一条数据
	@Test
	public void test4() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "deleteOne");
		JSONObject param = new JSONObject();
		jo.put("param", param);
		param.put("rules_id", "3");
		exe(jo);
	}

	// 根据clsid查询所有脚本
	@Test
	public void test5() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("service", "ruleservice");
		jo.put("method", "getAllByClsId");
		JSONObject param = new JSONObject();
		jo.put("param", param);
		param.put("clsid", "1");
		exe(jo);
	}

}
