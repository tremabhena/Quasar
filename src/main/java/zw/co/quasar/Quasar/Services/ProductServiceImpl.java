/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import zw.co.quasar.Quasar.POJOS.Product;

/**
 *
 * @author Mabhena
 */
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    ImageService imageDA;
    
    @Autowired
    CurrencyService currencyDA;
    
    private final RowMapper<Product> rowMapper = (resultSet, rowNum) ->{
                    Product product = new Product();
                    int id = resultSet.getInt("id");
                    product.setId(id);
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setPrice(resultSet.getBigDecimal("price"));
                    product.setName(resultSet.getString("name"));
                    product.setCategory(resultSet.getString("category"));
                    product.setDescription(resultSet.getString("description"));
                    product.setImages(imageDA.getProductImages(id));
                    product.setActive(true);
                    
                    long currencyId = resultSet.getLong("currency");
                    if(currencyId == 0) product.setCurrency(currencyDA.getCurrency(currencyId));
                    
                    return product;
                };
    
    @Override
    public Product getProduct(int id){
        String query = "SELECT id, price, quantity, name, category, description, currency FROM qzw_product WHEREid = ? AND active = TRUE";
        Product newProduct = jdbcTemplate.queryForObject(query,
                rowMapper, id);
        return newProduct;
    }
    
    @Override
    public List<Product> getProducts(int page, int limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Product> products = jdbcTemplate.query("SELECT id, price, quantity, currency, name, category, description FROM qzw_product WHERE active = TRUE ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,sortBy, direction, page, limit);
        
        return products;
    }
    
    @Override
    public List<Product> getCategoryProducts(int categoryId, int page, int limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Product> products = jdbcTemplate.query("SELECT id, price, quantity, currency, name, category, description FROM qzw_product WHERE category = ? AND active = TRUEORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,categoryId, sortBy, direction, page, limit);
        
        return products;
    }
}
