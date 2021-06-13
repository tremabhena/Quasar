/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.POJOS;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mabhena
 */
@Getter @Setter
public class Order {
    private int id;
    private String phone, dateAdded, country, email, cityTownProvince, address;
    private User user;
}
