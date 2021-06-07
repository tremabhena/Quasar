/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mabhena
 */
@Component
public class AccountDAImpl implements AccountDA {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public String getUserPasswordHash(String email){
        String hash;
        try{
            hash = jdbcTemplate.queryForObject(
                        "SELECT password_hash FROM qzw_user WHERE email = ?",
                        String.class,
                        email
            );
        }
        catch(IncorrectResultSizeDataAccessException e){
            hash = null;
        }
        return hash;
    }
}
