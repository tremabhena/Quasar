/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.POJOS;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mabhena
 */
@Getter @Setter
public class Product {
    int id, quantity;
    BigDecimal price;
    String name, category, description;
    Currency currency;
    List<Image> images;
}
