package com.test;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import dyna.com.MDU;

public class MountTest {

	@Before
	public void testbefore() {
		MDU.mapStrObject.put("dbPath", "E:/gitdata/eclipse/wk_2/dataservice/dbs/");
	}

//	@Test
//	public void test1() throws Exception {
//		long start = System.currentTimeMillis();
//		
//		JSONObject jo=new JSONObject();
//		jo.put("service", "ruleservice");
//		jo.put("method", "getAllTitle");
//		JSONObject param=new JSONObject();
//		jo.put("param", param);
//		
//		Object retObj = MDU.exePath("com.mount.DataMount", "E:/gitdata/eclipse/wk_2/dataservice/src/com/mount/DataMount.java", jo.toString());
//		if (retObj != null) {
//			System.out.println(retObj);
//		}
//		long end = System.currentTimeMillis();
//		System.out.println();
//		System.out.println("耗时："+(end - start));
//
//	}
	
	protected void exe(JSONObject jo){
		long start = System.currentTimeMillis();
		Object retObj = MDU.exePath("com.mount.DataMount", "E:/gitdata/eclipse/wk_2/dataservice/src/com/mount/DataMount.java", jo.toString());
		if (retObj != null) {
			System.out.println(retObj);
		}
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("耗时："+(end - start));
	

	}
	
}
