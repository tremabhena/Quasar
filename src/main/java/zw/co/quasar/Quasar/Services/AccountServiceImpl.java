/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import zw.co.quasar.Quasar.DbTables;
import zw.co.quasar.Quasar.POJOS.User;


/**
 *
 * @author Mabhena
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private final RowMapper<User> rowMapper = (resultSet, rowNum) ->{
            User user = new User();
            user.setId(resultSet.getInt(DbTables.User.COLUMN_ID));
            user.setFirstNames(resultSet.getString(DbTables.User.COLUMN_FIRST_NAMES));
            user.setLastName(resultSet.getString(DbTables.User.COLUMN_LAST_NAME));
            user.setEmail(resultSet.getString(DbTables.User.COLUMN_EMAIL));
            user.setPhone(resultSet.getString(DbTables.User.COLUMN_PHONE));
            user.setGender(resultSet.getString(DbTables.User.COLUMN_GENDER));
            user.setBirthDay(resultSet.getString(DbTables.User.COLUMN_BIRTHDAY));
            user.setCountry(resultSet.getString(DbTables.User.COLUMN_COUNTRY));
            return user;
            };
    
    @Override
    public String getUserPasswordHash(String email){
        String hash = null;
        String query = "SELECT " + DbTables.User.COLUMN_PASSWORD_HASH + " FROM " + DbTables.User.TABLE_NAME + " WHERE " + DbTables.User.COLUMN_EMAIL + " = ?";
        try{
            hash = jdbcTemplate.queryForObject(
                        query,
                        String.class,
                        email
            );
        }
        catch(Exception e){}
        return hash;
    }
    
    @Override
    public User getUserByEmail(String email){
        String query = "SELECT * FROM " + DbTables.User.TABLE_NAME + " WHERE " + DbTables.User.COLUMN_EMAIL + " = ?";
        User user = jdbcTemplate.queryForObject(query, rowMapper, email);
        
        return user;
    }
}
