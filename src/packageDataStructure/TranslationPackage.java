/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.tree.*;
import atom.names.ATOMStringResource;
import atom.names.ELanguages;

/**
 *
 * @author Maru
 */
//пакет ресурсов. узел дерева

public class TranslationPackage 
{
    //статус пакета
    private StatusPackage pcStatus = StatusPackage.startPackage;
    
    private DefaultMutableTreeNode dfNode = new  DefaultMutableTreeNode(this);
    
    // список ресурсов
    private List<ResourceString> packageTranslateResourcesStr = new ArrayList<ResourceString>();
    
    private String _PackageName;
    
    //список дочерних пакетов-узлов
    private List<TranslationPackage> subPakage = new ArrayList<TranslationPackage>();
   
    //родитель
    private TranslationPackage parent;
    
    public void setStatusPackage(StatusPackage pcStatus)
    {
        this.pcStatus=pcStatus;
    }
    
    public StatusPackage getStatusPackage()
    {
        return pcStatus;
    }
    
    public void setPackageTranslateResourcesString(List<ResourceString> strResource)
    {
        packageTranslateResourcesStr=strResource;
    }
    
    public List<ResourceString> getPackageTranslateResourcesString()
    {
       
        return packageTranslateResourcesStr;
    }
     
    public void Remove (String key)
    {
        int i=0;
        for(ResourceString r: packageTranslateResourcesStr)
        {
             i++;
             if (r.getKey().equals(key))
             {
               packageTranslateResourcesStr.remove(i);
               break;
             }
        }
    }
     
    public void setResource(ResourceString resource)
    {
        int index = packageTranslateResourcesStr.indexOf(resource);
        if (index >= 0 && index < packageTranslateResourcesStr.size())
        {
            packageTranslateResourcesStr.add(index, resource);
        }
        else
           packageTranslateResourcesStr.add(resource);  
    }
    
    public String getName()
    {
        return _PackageName;
    }

    public void setName(String name)
    {
        _PackageName = name;
    }
    
    public void addSubPackage(TranslationPackage addingPacage)
    {
       subPakage.add(addingPacage);
    }
    
    public List<TranslationPackage> getSubPackages()
    {
       return subPakage;
    }
    
    public void setParent(TranslationPackage parent)
    {
       this.parent=parent;
    }
    
    public TranslationPackage  getParent()
    {
       return parent;
    }
    
    public void ChangeValue (String key,ELanguages id,String value)
    {
        int i=-1;
        for(ResourceString r: packageTranslateResourcesStr)
        {
            i++;
           if (r.getKey().equals(key))
           {
               r.setString(id, value);
               packageTranslateResourcesStr.set(i, r);
               break;
            }
        }
        
    }
   
    public TranslationPackage CreateNode(ResourceString res, TranslationPackage node)
    {
        TranslationPackage copnode = node;
        CreateNode1(res.getKey(), node, res);
        return copnode;
    }

    private static void CreateNode1(String key, TranslationPackage node, ResourceString res)
    {
        if (key.contains("."))
        {
            boolean flag = false;
            int index = key.indexOf(".");
            String substring1 = key.substring(0, index);
            key = key.substring(index + 1, key.length());
            for (Object i : node.getSubPackages())
            {
                TranslationPackage child = (TranslationPackage) i;
                if (child.getName().equals(substring1))
                {
                    flag = true;
                    CreateNode1(key, child, res);
                }
            }
            if (flag == false)
            {
                TranslationPackage child = new TranslationPackage();
                child.setName(substring1);
                node.addSubPackage(child);
                CreateNode1(key, child, res);
            }
        }
        else
        {
            node.setResource(res);
        }
    }
}
