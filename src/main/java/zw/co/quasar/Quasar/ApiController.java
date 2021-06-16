/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

import zw.co.quasar.Quasar.POJOS.Cart;
import zw.co.quasar.Quasar.Services.CartService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zw.co.quasar.Quasar.POJOS.CartItem;
import zw.co.quasar.Quasar.POJOS.Category;
import zw.co.quasar.Quasar.POJOS.DeliveryDetails;
import zw.co.quasar.Quasar.POJOS.PaymentMethod;
import zw.co.quasar.Quasar.POJOS.Product;
import zw.co.quasar.Quasar.POJOS.User;
import zw.co.quasar.Quasar.Services.AccountService;
import zw.co.quasar.Quasar.Services.CategoryService;
import zw.co.quasar.Quasar.Services.PaymentService;
import zw.co.quasar.Quasar.Services.ProductService;

/**
 *
 * @author Mabhena
 */
@RestController
@RequestMapping(path = "/api/v1"/*, consumes="application/json"*/)
public class ApiController {
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    AccountService accountService;
    
    @Autowired
    CartService cartService;
    
    @Autowired
    PaymentService paymentService;
    
    //get product list
    @RequestMapping("/products")
    List<Product> listProducts(@RequestParam("limit") int limit, @RequestParam("page") int page,
                        @RequestParam("sort_by") String sortBy, @RequestParam("dir") String direction){
        List<Product> products = productService.getProducts(page, limit, sortBy, direction);
        return products;
    }
    
    //retrieve specific product
    @RequestMapping("/products/{productId}")
    Product viewProduct(@PathVariable int productId){
        return productService.getProduct(productId);
    }
    
    //search for product by name
    @RequestMapping("/search")
    List<Product> searchProducts(@RequestParam("q") String searchTerm, @RequestParam("limit") int limit, @RequestParam("page") int page,
                        @RequestParam("sort_by") String sortBy, @RequestParam("dir") String direction){
        List<Product> products = productService.searchProducts(searchTerm, page, limit, sortBy, direction);
        return products;
    }
    
    //get list of product categories
    @RequestMapping("/category")
    List<Category> listCategories(@RequestParam("limit") int limit, @RequestParam("page") int page,
                          @RequestParam("sort_by") String sortBy, @RequestParam("direction") String direction){
        List<Category> categories = categoryService.getCategories(page, limit, sortBy, direction);
        return categories;
    }
    
    //get specific category
    @RequestMapping("/category/{categoryId}")
    Category viewCategory(@PathVariable long categoryId){
        return categoryService.getCategory(categoryId);
    }
    
    //get products under specific category
    @RequestMapping("/category/{categoryId}/products")
    List<Product> listCategoryProducts(@PathVariable int categoryId, @RequestParam("limit") int limit, @RequestParam("page") int page,
                        @RequestParam("sort_by") String sortBy, @RequestParam("dir") String direction){
        List<Product> products = productService.getCategoryProducts(categoryId, page, limit, sortBy, direction);
        return products;
    }
    
    //show cart
    @RequestMapping("/cart")
    Cart showCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", cart);
        return cart;
    }
    
    //completely remove product from cart
    @PostMapping("/cart/remove/{itemId}")
    Cart removeFromCart(@PathVariable int itemId, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart = cartService.remove(itemId, cart);
        session.setAttribute("cart", cart);
        return cart;
    }
    
    //add (1) item to cart
    @PostMapping("/cart/add/{itemId}")
    Cart addToCart(@PathVariable int itemId, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart = cartService.add(itemId, cart);
        session.setAttribute("cart", cart);
        return cart;
    }
    
    //empty cart
    @PostMapping("/cart/empty")
    void emptyCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", cart);
        cartService.empty(cart);
    }
    /*
    @GetMapping("/cart/checkout/address")
    void getAddressOptions(){
    }
    
    @PostMapping("/cart/checkout/address")
    void addDeliveryAddress(){
    }
    
    @GetMapping("/cart/checkout/delivery")
    void getDeliveryOptions(){
    }
    */
    @PostMapping("/cart/checkout/delivery-details")
    void addDeliveryDetails(@RequestBody DeliveryDetails deliveryDetails, HttpSession session){
    }
    
    @GetMapping("/cart/checkout/payment")
    List<PaymentMethod> viewPaymentOptions(){
        return paymentService.getPaymentMethods();
    }
    
    @PostMapping("/cart/checkout/payment")
    String choosePaymentOptions(@RequestParam("payment_method") String paymentMethod, HttpSession session){
        return paymentMethod;
    }
    
    @PostMapping("/cart/checkout/finalize")
    ResponseEntity<String> finalizeCheckout(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null ) return ResponseEntity.badRequest().body("There is no cart in the session");
        HashMap<Integer, CartItem> items = cart.getItems();
        if(!items.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Cart is not empty");
        }
        else return ResponseEntity.badRequest().body("Cart is empty!!!");
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

    @RequestMapping("/account/logout")
    void logOut(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }
}
