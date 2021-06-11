/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import zw.co.quasar.Quasar.POJOS.User;

/**
 *
 * @author Mabhena
 */
public interface AccountDA {
    public String getUserPasswordHash(String email);
    public User getUserByEmail(String email);
}
