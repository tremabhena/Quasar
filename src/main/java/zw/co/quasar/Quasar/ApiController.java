/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

import zw.co.quasar.Quasar.POJOS.Cart;
import zw.co.quasar.Quasar.Services.CartService;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zw.co.quasar.Quasar.POJOS.Category;
import zw.co.quasar.Quasar.POJOS.Product;
import zw.co.quasar.Quasar.POJOS.User;
import zw.co.quasar.Quasar.Services.AccountService;
import zw.co.quasar.Quasar.Services.CategoryService;
import zw.co.quasar.Quasar.Services.ProductService;

/**
 *
 * @author Mabhena
 */
@RestController
@RequestMapping(path = "/api/v1", consumes="application/json")
public class ApiController {
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    AccountService accountService;
    
    @Autowired
    CartService cartService;
    
    Cart cart;
    
    @RequestMapping("/products")
    List<Product> listProducts(@RequestParam("limit") int limit, @RequestParam("page") int page,
                        @RequestParam("sort_by") String sortBy, @RequestParam("dir") String direction){
        List<Product> products = productService.getProducts(page, limit, sortBy, direction);
        return products;
    }

    @RequestMapping("/products/{productId}")
    Product viewProduct(@PathVariable int productId){
        return productService.getProduct(productId);
    }

    @RequestMapping("/category")
    List<Category> listCategories(@RequestParam("limit") int limit, @RequestParam("page") int page,
                          @RequestParam("sort_by") String sortBy, @RequestParam("direction") String direction){
        List<Category> categories = categoryService.getCategories(page, limit, sortBy, direction);
        return categories;
    }

    @RequestMapping("/category/{categoryId}")
    Category viewCategory(@PathVariable long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @RequestMapping("/cart")
    Cart showCart(HttpSession session){
        cart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", cart);
        return cart;
    }

    @RequestMapping("/cart/remove/{itemId}")
    Cart removeFromCart(@PathVariable int itemId, HttpSession session){
        cart = (Cart) session.getAttribute("cart");
        cart = cartService.remove(itemId, cart);
        session.setAttribute("cart", cart);
        return cart;
    }

    @RequestMapping("/cart/add/{itemId}")
    Cart addToCart(@PathVariable int itemId, HttpSession session){
        cart = (Cart) session.getAttribute("cart");
        cart = cartService.add(itemId, cart);
        session.setAttribute("cart", cart);
        return cart;
    }

    @RequestMapping("/cart/empty")
    void emptyCart(HttpSession session){
        cart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", cart);
        cartService.empty(cart);
    }

    @RequestMapping("/cart/checkout")
    String checkOut(){
        return "";
    }

    @RequestMapping("/account")
    public User showAccount(Principal principal){
        if(principal != null) {
            String email = principal.getName();
            User user = accountService.getUserByEmail(email);
            return user;
        }
        else return null;
    }

    @RequestMapping("/account/signin")
    String signIn(){
        return "";
    }

    @RequestMapping("/account/logout")
    void logOut(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }
}
