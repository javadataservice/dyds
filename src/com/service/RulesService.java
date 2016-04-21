package com.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.dao.RulesDao;

public class RulesService {

	private static RulesDao ru = new RulesDao();

	public String execute(String method, JSONObject param) {

		if (method.equals("getAllTitle")) {
			return ru.getAllTitle().toString();
		} else if (method.equals("getOne")) {
			try {
				if (param.has("rules_id")) {
					return ru.getOne(param.getString("rules_id")).toString();
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("insert")) {
			ru.insertOne(param);
			return "ok";
		} else if (method.equals("deleteOne")) {
			if (param != null) {
				if (param.has("rules_id")) {
					try {
						return ru.deleteOne(param.getString("rules_id"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return "无可执行方法";
	}

}
