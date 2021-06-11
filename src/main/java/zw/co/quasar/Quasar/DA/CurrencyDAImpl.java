/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import zw.co.quasar.Quasar.POJOS.Currency;

/**
 *
 * @author Mabhena
 */
@Component
public class CurrencyDAImpl implements CurrencyDA {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public Currency getCurrency(long currencyId){
        String query = "SELECT id, iso_code, symbol, name, rate FROM qzw_currency WHERE id = ? AND active = TRUE";
        Currency currency = jdbcTemplate.queryForObject(query,
                (resultSet, rowNum) ->{
                    Currency newCurrency = new Currency();
                    newCurrency.setId(resultSet.getInt("id"));
                    newCurrency.setIsoCode(resultSet.getString("iso_code"));
                    newCurrency.setActive(true);
                    newCurrency.setRate(resultSet.getFloat("rate"));
                    newCurrency.setSymbol(resultSet.getString("symbol"));
                    newCurrency.setName(resultSet.getString("name"));
                    
                    return newCurrency;
                }
                , currencyId);
        
        return currency;
    }
}
