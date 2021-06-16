/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import zw.co.quasar.Quasar.DbTables;
import zw.co.quasar.Quasar.POJOS.Currency;

/**
 *
 * @author Mabhena
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public Currency getCurrency(long currencyId){
        String query = "SELECT * FROM " + DbTables.Currency.TABLE_NAME + " WHERE " + DbTables.Currency.COLUMN_ID + " = ? AND " + DbTables.Currency.COLUMN_ACTIVE + " = TRUE";
        Currency currency = jdbcTemplate.queryForObject(query,
                (resultSet, rowNum) ->{
                    Currency newCurrency = new Currency();
                    newCurrency.setId(resultSet.getInt(DbTables.Currency.COLUMN_ID));
                    newCurrency.setIsoCode(resultSet.getString(DbTables.Currency.COLUMN_ISO_CODE));
                    newCurrency.setActive(true);
                    newCurrency.setRate(resultSet.getFloat(DbTables.Currency.COLUMN_RATE));
                    newCurrency.setSymbol(resultSet.getLong(DbTables.Currency.COLUMN_SYMBOL));
                    newCurrency.setName(resultSet.getString(DbTables.Currency.COLUMN_NAME));
                    
                    return newCurrency;
                }
                , currencyId);
        
        return currency;
    }
}
