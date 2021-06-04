package zw.co.quasar.Quasar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class QuasarApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuasarApplication.class, args);
	}
        
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
        String showAccount(){
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
