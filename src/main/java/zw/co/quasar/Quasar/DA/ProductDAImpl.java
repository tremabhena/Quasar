/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import zw.co.quasar.Quasar.POJOS.Product;

/**
 *
 * @author Mabhena
 */
public class ProductDAImpl implements ProductDA {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    ImageDA imageDA;
    
    @Autowired
    CurrencyDA currencyDA;
    
    private final RowMapper<Product> rowMapper = (resultSet, rowNum) ->{
                    Product product = new Product();
                    Long id = resultSet.getLong("id");
                    product.setId(id);
                    product.setPrice(resultSet.getFloat("price"));
                    product.setName(resultSet.getString("name"));
                    product.setCategory(resultSet.getString("category"));
                    product.setDescription(resultSet.getString("description"));
                    product.setImages(imageDA.getProductImages(id));
                    
                    Long currencyId = resultSet.getLong("currency");
                    if(currencyId != null) product.setCurrency(currencyDA.getCurrency(currencyId));
                    
                    return product;
                };
    
    @Override
    public Product getProduct(Long id){
        String query = "SELECT id, price, name, category, description, currency FROM qzw_product WHERE id = ?";
        Product newProduct = jdbcTemplate.queryForObject(query,
                rowMapper, id);
        return newProduct;
    }
    
    @Override
    public List<Product> getProducts(Integer page, Integer limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Product> products = jdbcTemplate.query("SELECT id, price, currency, name, category, description FROM qzw_product ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,sortBy, direction, page, limit);
        
        return products;
    }
}
