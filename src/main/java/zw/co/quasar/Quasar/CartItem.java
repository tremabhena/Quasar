/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import zw.co.quasar.Quasar.POJOS.Currency;

/**
 *
 * @author Mabhena
 */
@Getter @Setter
public class CartItem {
    int id;
    int quantity;
    BigDecimal unitPrice;
    String name;
    Currency currency;
}
