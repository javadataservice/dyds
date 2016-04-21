package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dao.basedao.BaseDao;

public class CLSDao extends BaseDao {

	// 保存或者更新
	public String insertOne(JSONObject jsonobject) {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = getCon("oth");
			boolean haveCls = jsonobject.has("cls_id");
			String name = jsonobject.getString("name");
			String desc = jsonobject.getString("desc");
			if (haveCls) {
				String cls_id = jsonobject.getString("cls_id");
				preparedStatement = con.prepareStatement("update cls set name=?,desc=? where cls_id=?");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, desc);
				preparedStatement.setString(3, cls_id);
				preparedStatement.execute();
			} else {
				preparedStatement = con.prepareStatement("insert into cls(name,desc) values(?,?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, desc);
				preparedStatement.execute();
			}
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, null, preparedStatement, null);
		}
		return "no";
	}

	// 查询所有
	public String selectAllCLSIDS() {

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		JSONArray jsonArray = new JSONArray();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select cls_id from cls");
			while (resultSet.next()) {
				jsonArray.put(resultSet.getString("cls_id"));
			}
			return jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, statement, null, resultSet);
		}
		return "";
	}

	// 根据ID查询
	public String selectOneByCLSID(JSONObject jsonObject) {

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		JSONObject jo = new JSONObject();
		try {
			String cls_id = jsonObject.getString("cls_id");
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from cls where cls_id='" + cls_id + "'");
			while (resultSet.next()) {
				jo.put("cls_id", cls_id);
				jo.put("name", resultSet.getString("name"));
				jo.put("desc", resultSet.getString("desc"));
			}
			return jo.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, statement, null, resultSet);
		}
		return "";
	}

	// 根据ID删除
	public String deleteOneByCLSID(JSONObject jsonObject) {
		Connection con = null;
		Statement statement = null;
		try {
			String cls_id = jsonObject.getString("cls_id");
			statement = con.createStatement();
			statement.executeQuery("delete from cls where cls_id='" + cls_id + "'");
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, statement, null, null);
		}
		return "";
	}

}
