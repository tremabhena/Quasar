/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import zw.co.quasar.Quasar.POJOS.Image;
import java.util.List;

/**
 *
 * @author Mabhena
 */
public interface ImageService {
    //Image getImage();
    List<Image> getProductImages(long productId);
    /*Boolean addImage();
    Boolean removeImage();
    Boolean updateImage();*/
}
