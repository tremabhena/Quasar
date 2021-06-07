/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import zw.co.quasar.Quasar.POJOS.Currency;
import java.util.List;

/**
 *
 * @author Mabhena
 */
public interface CurrencyDA {
    Currency getCurrency();
    List<Currency> getCurrencies();
    Boolean addCurrency();
    Boolean removeCurrency();
    Boolean activateCurrency();
    Boolean deactivateCurrency();
    Boolean updateCurrency();
}
