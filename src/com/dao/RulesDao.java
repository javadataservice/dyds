package com.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import com.dao.basedao.BaseDao;

public class RulesDao extends BaseDao {

	// 插入一条检索策略
	public void insertOne(JSONObject jobj) {
		Connection con = null;
		PreparedStatement statement = null;
		Statement statement2 = null;
		String sql = "";
		try {
			String name = jobj.getString("name");
			String desc = jobj.getString("desc");
			String dataNode = jobj.getString("dataNode");
			String datas = jobj.getString("datas");
			String clsid = jobj.getString("clsid");
			con = getCon("oth");
			if (jobj.has("id") && !jobj.getString("id").isEmpty()) {
				sql = "update rules set name=?,desc=?,datanode=?,upt=?,datas=?,clsid=? where rules_id='"
						+ jobj.getString("rules_id") + "';";
			} else {
				sql = "insert into rules(name,desc,datanode,upt,datas,clsid) values(?,?,?,?,?,?)";
			}

			statement = con.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, desc);
			statement.setString(3, dataNode);
			statement.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			statement.setBlob(5, new ByteArrayInputStream(datas.getBytes()));
			statement.setString(6, clsid);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, statement2, statement, null);
		}

	}

	// 返回ID和name信息
	public JSONArray getAllTitle() {
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		JSONArray jsonArray = new JSONArray();
		try {
			con = getCon("oth");
			sta = con.createStatement();
			rs = sta.executeQuery("select rules_id, name from rules");
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("rules_id", rs.getString("rules_id"));
				jo.put("name", rs.getString("name"));
				jsonArray.put(jo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, sta, null, rs);
		}
		return jsonArray;
	}

	// 根据ID查询一条策略
	public JSONObject getOne(String id) {
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		JSONObject jo = new JSONObject();
		try {
			con = getCon("oth");
			sta = con.createStatement();
			rs = sta.executeQuery("select * from rules where rules_id='" + id + "'");
			while (rs.next()) {

				jo.put("rules_id", rs.getString("rules_id"));
				jo.put("name", rs.getString("name"));
				jo.put("desc", rs.getString("desc"));
				jo.put("dataNode", rs.getString("datanode"));
				jo.put("upt", rs.getString("upt"));
				jo.put("clsid", rs.getString("clsid"));

				InputStream inputStream = rs.getBlob("datas").getBinaryStream();
				byte[] by = new byte[inputStream.available()];
				inputStream.read(by);

				jo.put("datas", new String(by, "UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, sta, null, rs);
		}
		return jo;
	}

	// 根据ID删除一条记录
	public String deleteOne(String id) {
		Connection con = null;
		Statement sta = null;
		try {
			con = getCon("oth");
			sta = con.createStatement();
			sta.execute("delete from rules where rules_id='" + id + "';");
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	// 根据clsid查询多条记录
	public JSONArray getAllByClsId(String clsid) {
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		JSONArray ja = new JSONArray();
		try {
			con = getCon("oth");
			sta = con.createStatement();
			rs = sta.executeQuery("select * from rules where clsid='" + clsid + "'");
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("rules_id", rs.getString("rules_id"));
				jo.put("name", rs.getString("name"));
				ja.put(jo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(con, sta, null, rs);
		}
		return ja;
	}

}
