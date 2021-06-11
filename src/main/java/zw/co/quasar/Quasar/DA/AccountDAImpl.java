/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import zw.co.quasar.Quasar.POJOS.User;

/**
 *
 * @author Mabhena
 */
@Component
public class AccountDAImpl implements AccountDA {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private final RowMapper<User> rowMapper = (resultSet, rowNum) ->{
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFirstNames(resultSet.getString("first_names"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDay(resultSet.getString("birth_day"));
            user.setCountry(resultSet.getString("country"));
            return user;
            };
    
    @Override
    public String getUserPasswordHash(String email){
        String hash = null;
        try{
            hash = jdbcTemplate.queryForObject(
                        "SELECT password_hash FROM qzw_user WHERE email = ?",
                        String.class,
                        email
            );
        }
        catch(Exception e){}
        return hash;
    }
    
    public User getUserByEmail(String email){
        User user = jdbcTemplate.queryForObject("SELECT id, first_names, last_name, email, phone, gender, birthday, country FROM qzw_user WHERE email = ?", rowMapper, email);
        return user;
    }
}
