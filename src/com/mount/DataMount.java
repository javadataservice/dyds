package com.mount;

import org.json.JSONObject;

import com.service.RulesService;

import dyna.com.IExe;

public class DataMount implements IExe {

	@Override
	public Object exe(Object arg0) {
		String params = arg0.toString();
		try {
			JSONObject jo = new JSONObject(params);
			String service = jo.getString("service");
			String method = jo.getString("method");
			JSONObject param = jo.getJSONObject("param");
			if (service.equals("ruleservice")) {
				return new RulesService().execute(method, param);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
