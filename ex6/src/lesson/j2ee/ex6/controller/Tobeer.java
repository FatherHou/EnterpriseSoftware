package lesson.j2ee.ex6.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lesson.j2ee.ex6.model.AccessJDBCUtil;
import lesson.j2ee.ex6.model.Beer;

public class Tobeer {
	public List<Beer> list() {
		return list(0, Short.MAX_VALUE);
	}
	public static List<Beer> list(int start, int count){
		Connection c = null;
		List<Beer> beers = new ArrayList<Beer>();
		try {
			c = AccessJDBCUtil.getConnection();
			String sql = "select * from beer limit ?,?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Beer beer=new Beer();
				beer.setColor(rs.getString("color"));
				beer.setId(rs.getInt("id"));
				beer.setManufacturer(rs.getString("manufacturer"));
				beer.setName(rs.getString("name"));
				beers.add(beer);
			}
			AccessJDBCUtil.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beers;
	}
	public static List<Beer> listByColor(int start, int count, String color){
		Connection c = null;
		List<Beer> beers = new ArrayList<Beer>();
		try {
			c = AccessJDBCUtil.getConnection();
			String sql = "select * from beer where color=? limit ?,?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, color);
			ps.setInt(2, start);
			ps.setInt(3, count);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Beer beer=new Beer();
				beer.setColor(rs.getString("color"));
				beer.setId(rs.getInt("id"));
				beer.setManufacturer(rs.getString("manufacturer"));
				beer.setName(rs.getString("name"));
				beers.add(beer);
			}
			
			AccessJDBCUtil.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beers;
		
	}
}
