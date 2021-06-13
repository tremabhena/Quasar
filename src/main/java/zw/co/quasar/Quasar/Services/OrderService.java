/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import zw.co.quasar.Quasar.POJOS.Order;
import java.util.List;

/**
 *
 * @author Mabhena
 */
public interface OrderService {
    Order getOrder();
    List<Order> getOrders();
    boolean addOrder();
    boolean removeOrder();
    boolean updateOrtder();
}
