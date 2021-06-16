/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.List;
import zw.co.quasar.Quasar.POJOS.Product;

/**
 *
 * @author Mabhena
 */
public interface ProductService {
    Product getProduct(int id);
    List<Product> getProducts(int page, int limit, String sortBy, String direction);
    List<Product> getCategoryProducts(int categoryId, int page, int limit, String sortBy, String direction);
    List<Product> searchProducts(String searchTerm, int page, int limit, String sortBy, String direction);
    /*List<Product> searchProduct();
    Boolean addProduct();
    Boolean removeProduct();
    Boolean updateProduct();
    Boolean activateProduct();
    Boolean deactivateProduct();*/
}
