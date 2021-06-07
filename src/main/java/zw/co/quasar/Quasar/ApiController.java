/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mabhena
 */
@RestController
@RequestMapping(path = "/api/v1", consumes="application/json")
public class ApiController {
    @RequestMapping("/products")
    String listProducts(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page,
                        @RequestParam("sort_by") String SortBy, @RequestParam("direction") String direction){
        return "Hello";
    }

    @RequestMapping("/products/{productId}")
    String viewProduct(@PathVariable Long productId){
        return "";
    }

    @RequestMapping("/category")
    String listCategories(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page,
                          @RequestParam("sort_by") String SortBy, @RequestParam("direction") String direction){
        return "";
    }

    @RequestMapping("/category/{categoryId}")
    String viewCategory(@PathVariable Long categoryId){
        return "";
    }

    @RequestMapping("/cart")
    String showCart(){
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
    
    String test(HttpServletRequest request){
        return "";
    }
}
