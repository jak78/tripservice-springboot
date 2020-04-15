package com.octo.legacy.tripservice.tripservice.trip;

import com.octo.legacy.tripservice.tripservice.user.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.List;

public class TripDAO {

    public static DataSource DATABASE;

    public static User getUserById(String id) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);
        User user = new NamedParameterJdbcTemplate(DATABASE)
                .queryForObject("SELECT id,name FROM users WHERE id=:id",
						parameters,
						(resultSet, i) -> new User(resultSet.getString(1), resultSet.getString(2)));
        
        user.setFriends(new NamedParameterJdbcTemplate(DATABASE).query(
				"SELECT id, name FROM users JOIN users_friends ON user_id_2=users.id WHERE user_id_1=:id",
				parameters,
				(resultSet, i) -> new User(resultSet.getString(1), resultSet.getString(2))));
		return user;
    }

    public static List<Trip> findTripsByUser(User user) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", user.getId());
        return new NamedParameterJdbcTemplate(DATABASE)
                .query("SELECT id,destination FROM trips WHERE user_id=:id",
						parameters,
						(resultSet, i) -> new Trip(resultSet.getString(1), resultSet.getString(2)));
    }

}