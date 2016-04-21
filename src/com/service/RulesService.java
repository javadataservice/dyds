package com.service;

import org.json.JSONObject;

import com.dao.RulesDao;

public class RulesService {

	private RulesDao ru = new RulesDao();

	public String execute(String method, JSONObject param) {
		
		try {

			if (method.equals("getAllTitle")) {
				return ru.getAllTitle().toString();
			} else if (method.equals("getOne")) {
				return ru.getOne(param.getString("rules_id")).toString();
			} else if (method.equals("insert")) {
				ru.insertOne(param);
				return "ok";
			} else if (method.equals("deleteOne")) {
				return ru.deleteOne(param.getString("rules_id"));
			} else if (method.equals("getAllByClsId")) {
				return ru.getAllByClsId(param.getString("clsid")).toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "无可执行方法";
	}

}
