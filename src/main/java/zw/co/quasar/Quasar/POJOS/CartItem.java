/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.POJOS;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Mabhena
 */
@Getter @Setter
public class CartItem {
    int id, quantity;
    BigDecimal unitPrice;
    String name;
    Currency currency;
}
