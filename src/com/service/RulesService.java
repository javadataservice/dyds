package com.service;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.dao.RulesDao;

public class RulesService implements IService{

	private static RulesDao ru=new RulesDao();
	
	public String execute(Map<String, String> params) {

		String method=params.get("method");
		if(method.equals("getAllTitle")){
			return ru.getAllTitle().toString();
		}else if(method.equals("getOne")){
			
			try {
				JSONObject pj=new JSONObject(params.get("params"));
				if(pj.has("id")){
				return ru.getOne(pj.getString("id")).toString();
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("insert")){
			
			String param=params.get("params");
			try {
				JSONObject jo=new JSONObject(param);
				ru.insertOne(jo);
				return "ok";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("deleteOne")){
			String param=params.get("params");
			if(param!=null){
				return ru.deleteOne(param);
			}
		}
		
		return "无可执行方法";
	}

	public String getType() {
		return IService.SERVICE_RULE;
	}

}
