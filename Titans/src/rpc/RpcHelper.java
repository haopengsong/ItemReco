package rpc;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class RpcHelper {
	//write a JSONObject to http response
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin","*");
			PrintWriter out = response.getWriter();
			//System.out.println(obj.toString());
			out.print(obj);
			out.flush();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//write a JSONArray to http response
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin","*");
			PrintWriter out = response.getWriter();
			out.print(array);
			out.flush();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static JSONObject readJsonObject(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			return new JSONObject(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
