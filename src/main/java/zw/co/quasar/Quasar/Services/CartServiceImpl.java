/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.quasar.Quasar.POJOS.Cart;
import zw.co.quasar.Quasar.POJOS.CartItem;
import zw.co.quasar.Quasar.POJOS.Product;
/**
 *
 * @author Mabhena
 */
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    ProductService productDA;
    
    //HashMap<Integer, CartItem> items;
    
    @Override
    public Cart remove(int productId, Cart cart){
        HashMap<Integer, CartItem> items = cart.getItems();
        items.remove(productId);
        return cart;
    }
    
    @Override
    public Cart add(int productId, Cart cart){
        CartItem cartItem;
        Product product = productDA.getProduct(productId);
        //only add available items to cart
        if(product.getQuantity() > 0){
            HashMap<Integer, CartItem> items = cart.getItems();
            if(items.containsKey(productId)){
                cartItem = items.get(productId);
                int quantity = cartItem.getQuantity() + 1;
                //only add quantity available to cart
                cartItem.setQuantity(quantity);
            }
            else {
                cartItem = new CartItem();

                cartItem.setId(product.getId());
                cartItem.setQuantity(1);
                cartItem.setUnitPrice(product.getPrice());
                cartItem.setName(product.getName());
                cartItem.setCurrency(product.getCurrency());

                items.put(productId, cartItem);
            }
        }
        return cart;
    }
    
    @Override
    public Cart subtract(int productId, Cart cart){
        CartItem cartItem;
        HashMap<Integer, CartItem> items = cart.getItems();
        if(items.containsKey(productId)){
            cartItem = items.get(productId);
            int quantity = cartItem.getQuantity() - 1;
            
            if(quantity == 0) this.remove(productId, cart);
            else if(quantity > 0) cartItem.setQuantity(quantity);
        }
        
        return cart;
    }
    
    @Override
    public Cart update(int productId, int quantity, Cart cart){
        HashMap<Integer, CartItem> items = cart.getItems();
        CartItem cartItem = items.get(productId);
        if(cartItem != null) cartItem.setQuantity(quantity);
        return cart;
    }
    
    @Override
    public boolean empty(Cart cart){
        HashMap<Integer, CartItem> items = cart.getItems();
        items.clear();
        return true;
    }
}
