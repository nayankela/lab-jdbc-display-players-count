package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {
	TreeMap<Skill, Integer> map = new TreeMap<Skill, Integer>();

	public TreeMap<Skill, Integer> skillCount() {

		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT S.ID, S.NAME, COUNT(P.NAME) FROM SKILL S JOIN PLAYER P ON P.SKILL_ID = S.ID  GROUP BY S.NAME, S.ID";

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (resultSet.next()) {

				Long skillId = resultSet.getLong(1);
				String skillName = resultSet.getString(2);
				int count = resultSet.getInt(3);
				Skill skill = new Skill(skillId, skillName);
				map.put(skill, count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;

	}

}
