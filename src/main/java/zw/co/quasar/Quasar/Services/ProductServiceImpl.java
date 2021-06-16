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
import org.springframework.stereotype.Service;
import zw.co.quasar.Quasar.DbTables;
import zw.co.quasar.Quasar.POJOS.Product;

/**
 *
 * @author Mabhena
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    ImageService imageDA;
    
    @Autowired
    CurrencyService currencyDA;
    
    private final RowMapper<Product> rowMapper = (resultSet, rowNum) ->{
                    Product product = new Product();
                    int id = resultSet.getInt(DbTables.Product.COLUMN_ID);
                    product.setId(id);
                    product.setQuantity(resultSet.getInt(DbTables.Product.COLUMN_QUANTITY));
                    product.setUsdPrice(resultSet.getBigDecimal(DbTables.Product.COLUMN_USD_PRICE));
                    product.setName(resultSet.getString(DbTables.Product.COLUMN_NAME));
                    product.setCategory(resultSet.getString(DbTables.Product.COLUMN_CATEGORY));
                    product.setDescription(resultSet.getString(DbTables.Product.COLUMN_DESCRIPTION));
                    product.setImages(imageDA.getProductImages(id));
                    product.setActive(true);
                    
                    /*long currencyId = resultSet.getLong("currency");
                    if(currencyId == 0) product.setCurrency(currencyDA.getCurrency(currencyId));*/
                    
                    return product;
                };
    
    @Override
    public Product getProduct(int id){
        String query = "SELECT * FROM " + DbTables.Product.TABLE_NAME + " WHERE " + DbTables.Product.COLUMN_ID +" = ? AND " + DbTables.Product.COLUMN_ACTIVE + " = TRUE";
        Product newProduct = jdbcTemplate.queryForObject(query,
                rowMapper, id);
        return newProduct;
    }
    
    @Override
    public List<Product> getProducts(int page, int limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Product> products = jdbcTemplate.query("SELECT * FROM " + DbTables.Product.TABLE_NAME + " WHERE " + DbTables.Product.COLUMN_ACTIVE + " = TRUE ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,sortBy, direction, page, limit);
        
        return products;
    }
    
    @Override
    public List<Product> getCategoryProducts(int categoryId, int page, int limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Product> products = jdbcTemplate.query("SELECT * FROM " + DbTables.Product.TABLE_NAME + " WHERE " + DbTables.Product.COLUMN_ID + " = ? AND " + DbTables.Product.COLUMN_ACTIVE + " = TRUE ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,categoryId, sortBy, direction, page, limit);
        
        return products;
    }
    
    @Override
    public List<Product> searchProducts(String searchTerm, int page, int limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Product> products = jdbcTemplate.query("SELECT * FROM " + DbTables.Product.TABLE_NAME + " WHERE " + DbTables.Product.COLUMN_NAME + " LIKE '%?%' AND " + DbTables.Product.COLUMN_ACTIVE + " = TRUE ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,searchTerm, sortBy, direction, page, limit);
        
        return products;
    }
}
