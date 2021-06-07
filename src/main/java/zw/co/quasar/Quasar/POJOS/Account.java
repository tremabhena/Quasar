/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.POJOS;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author Mabhena
 */
public class Account {
    String name;
    String surname;
    Integer age;
    Float height;
    Float weight;
    
    interface Ugly{};
    
    @JsonView(Ugly.class)
    public String getName(){
        return this.name;
    }
    
    @JsonView(Ugly.class)
    public String getSurname(){
        return this.surname;
    }
}
