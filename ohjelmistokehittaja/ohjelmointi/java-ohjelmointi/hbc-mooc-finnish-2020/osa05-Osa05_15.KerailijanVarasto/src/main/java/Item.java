
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s2100631
 */
public class Item {
    private String tunnus;
    private String nimi;
    
    public Item(String tunnus, String nimi) {
        this.tunnus = tunnus;
        this.nimi = nimi;
         
    }

    public String getTunnus() {
        return this.tunnus;
    }

    public String getNimi() {
        return this.nimi;
    }

    @Override
    public String toString() {
        return this.tunnus + ": " + this.nimi;
    }

  

    @Override
    public boolean equals(Object verrattava) {
        if (this == verrattava) {
            return true;
        }
        
        if (!(verrattava instanceof Item)) {
            return false;
        }
        Item itemVerrattava = (Item) verrattava;
        
        if (this.tunnus.equals(itemVerrattava.tunnus)) {
            return true;
        }
        
        return false;
    }
    
    
}
