package com.test;

import org.junit.Before;
import org.junit.Test;

import dyna.com.MDU;

public class MountTest {

	@Before
	public void testbefore() {
		MDU.mapStrObject.put("dbPath", "D:/softs/dyn/eclipse/wk_1/dataservice/dbs/");
	}

	@Test
	public void test1() {
		long start = System.currentTimeMillis();
		Object retObj = MDU.exePath("com.mount.DataMount", "D:/softs/dyn/eclipse/wk_1/dataservice/src/com/mount/DataMount.java", "");
		if (retObj != null) {
			System.out.println(retObj);
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end - start));

	}

}
