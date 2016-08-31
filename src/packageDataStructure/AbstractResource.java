/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maru
 */
public class AbstractResource {
   
    private String key;
  
    public void setKey(String key)
    {
        this.key=key;
    }
    
    public String getKey()
    {
        return this.key;
    }
 
    @Override
    public int hashCode()
    {
       return key.hashCode();
    }
    
      /* @Override
    public boolean equals(Object other)
    {
       if (other instanceof AbstractResource)
           return equals((AbstractResource)other);
       return false;
    }
   
    public boolean equals(AbstractResource other)
    {
       if (other == null)
           return false;
       return key.equals(other.key);
   }*/
   
}
