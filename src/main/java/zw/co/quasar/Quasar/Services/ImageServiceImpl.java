/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import zw.co.quasar.Quasar.DbTables;
import zw.co.quasar.Quasar.POJOS.Image;

/**
 *
 * @author Mabhena
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Image> getProductImages(long productId){
        List<Image> images = jdbcTemplate.query("SELECT * FROM " + DbTables.ProductImage.TABLE_NAME + " WHERE " + DbTables.ProductImage.COLUMN_PRODUCT + " = ?",
        (resultSet, rowNum) ->{
            Image image = new Image();
            image.setId(resultSet.getInt(DbTables.ProductImage.COLUMN_ID));
            image.setHeight(resultSet.getShort(DbTables.ProductImage.COLUMN_HEIGHT));
            image.setWidth(resultSet.getShort(DbTables.ProductImage.COLUMN_WIDTH));
            image.setUrl(resultSet.getString(DbTables.ProductImage.COLUMN_URL));
            
            return image;
        }, productId);
        
        return images;
    }
}
