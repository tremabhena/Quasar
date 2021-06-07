/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zw.co.quasar.Quasar.DA.CategoryDA;
import zw.co.quasar.Quasar.DA.ProductDA;
import zw.co.quasar.Quasar.POJOS.Category;
import zw.co.quasar.Quasar.POJOS.Product;

/**
 *
 * @author Mabhena
 */
@RestController
@RequestMapping(path = "/api/v1", consumes="application/json")
public class ApiController {
    @Autowired
    ProductDA productDA;
    
    @Autowired
    CategoryDA categoryDA;
    
    @RequestMapping("/products")
    List<Product> listProducts(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page,
                        @RequestParam("sort_by") String sortBy, @RequestParam("dir") String direction){
        List<Product> products = productDA.getProducts(page, limit, sortBy, direction);
        return products;
    }

    @RequestMapping("/products/{productId}")
    Product viewProduct(@PathVariable Long productId){
        return productDA.getProduct(productId);
    }

    @RequestMapping("/category")
    List<Category> listCategories(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page,
                          @RequestParam("sort_by") String sortBy, @RequestParam("direction") String direction){
        List<Category> categories = categoryDA.getCategories(page, limit, sortBy, direction);
        return categories;
    }

    @RequestMapping("/category/{categoryId}")
    Category viewCategory(@PathVariable Long categoryId){
        return categoryDA.getCategory(categoryId);
    }

    @RequestMapping("/cart")
    String showCart(){
        Session session;
        return "";
    }

    @RequestMapping("/cart/remove/{itemId}")
    String removeFromCart(@PathVariable Long itemId){
        return "";
    }

    @RequestMapping("/cart/add/{itemId}")
    String addToCart(@PathVariable Long itemId){
        return "";
    }

    @RequestMapping("/cart/empty")
    String emptyCart(){
        return "";
    }

    @RequestMapping("/cart/checkout")
    String checkOut(){
        return "";
    }

    @RequestMapping("/account")
    public String showAccount(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("saturday", "inbed");
        response.addCookie(cookie);
        return "";
    }

    @RequestMapping("/account/sign-in")
    String signIn(){
        return "";
    }

    @RequestMapping("/account/log-out")
    String logOut(){
        return "";
    }
}
