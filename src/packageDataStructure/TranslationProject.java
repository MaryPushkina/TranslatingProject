/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataStructure;

import java.util.ArrayList;
import java.util.List;
import atom.names.ELanguages;/**
 *
 * @author Maru
 */
//главный класс логики

public class TranslationProject {
   
    private String IDProject="";
    
    private String addressProject="";
   
    // список пакетов - jar project
    private List <TranslationPackage> packagesResources = new ArrayList <TranslationPackage> ();
    
    private  ELanguages IDLangDefault;  
    
    public  List <TranslationPackage> getPackageResources ()
    {
        return packagesResources;
    }
    
    public  String getIDProject ()
    {
        return IDProject;
    }
    
    public String setIDProject (String IDProject)
    {
        return this.IDProject=IDProject;
    }
    
    public  String getAddressProject ()
    {
        return addressProject;
    }
    
    public String setAddressProject (String addressProject)
    {
        return this.addressProject=addressProject;
    }
    
    public  ELanguages getIDLangDefault ()
    {
        return IDLangDefault;
    }
    
    public ELanguages setIDLangDefault (ELanguages IDLangDefau)
    {
        return this.IDLangDefault=IDLangDefau;
    }
    
}
