/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import zw.co.quasar.Quasar.POJOS.Cart;

/**
 *
 * @author Mabhena
 */
public interface CartService {
    public Cart remove(int productId, Cart cart);
    public Cart subtract(int productId, Cart cart);
    public Cart add(int productId, Cart cart);
    public Cart update(int productId, int quantity, Cart cart);
    public boolean empty(Cart cart);
}
