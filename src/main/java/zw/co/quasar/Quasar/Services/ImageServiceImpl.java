/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import zw.co.quasar.Quasar.POJOS.Image;

/**
 *
 * @author Mabhena
 */
@Component
public class ImageServiceImpl implements ImageService{
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Image> getProductImages(long productId){
        List<Image> images = jdbcTemplate.query("SELECT id, url, width, height FROM qzw_product_image WHERE product = ?",
        (resultSet, rowNum) ->{
            Image image = new Image();
            image.setId(resultSet.getInt("id"));
            image.setHeight(resultSet.getShort("height"));
            image.setWidth(resultSet.getShort("width"));
            image.setUrl(resultSet.getString("url"));
            
            return image;
        }, productId);
        
        return images;
    }
}
