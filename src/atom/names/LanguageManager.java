/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import packageDataStructure.ResourceString;
import packageDataStructure.TranslationPackage;
import packageDataStructure.TranslationProject;
import packageImportTranslateProject.ParseXMLFile;

/**
 *
 * @author Жиряков
 */
public class LanguageManager implements ILanguageManager
{ 
    private Map KeyMap = new HashMap < String,TranslationPackage>();
    ////
    //////
    private int i=0;
    private TranslationPackage trPackage = new TranslationPackage();
    
    private String fileName="";
    
    private String programName="";
    
    protected static LanguageManager _SingltonXML = null;
    
    protected static LanguageManager _Singlton = null;
    
    protected ELanguages _CurrentLanguage;
    
    protected LanguageManager()
    {
        _CurrentLanguage = ELanguages.Russian;
    }
    
    public static LanguageManager getManagerXML()
    {
      if (_SingltonXML == null)
          _SingltonXML = new LanguageManager();
      
      return _SingltonXML;  
    }
    
    public static ILanguageManager getManager()
    {
      if (_Singlton == null)
          _Singlton = new LanguageManager();
      
      return _Singlton;
    }

    @Override
    public ELanguages CurrentLanguage()
    {
       return _CurrentLanguage;
               
    }

    @Override
    public void setCurrentLanguage(ELanguages currentLanguage)
    {
       _CurrentLanguage = currentLanguage;
    }
      
    public void setFileNameAndProgramName(String fileName, String programName) throws ParserConfigurationException, SAXException, IOException
    {
        this.programName=programName;
        this.fileName=fileName;
        ParseXMLFile parseXMLFile = new ParseXMLFile();
        File file = new File(fileName);
        TranslationProject trProject = parseXMLFile.ParseFile(file);
        for(TranslationPackage trPackage:trProject.getPackageResources())
        {
            if (trPackage.getName().equals(programName))
                this.trPackage=trPackage;
        }
    }
    
    public void ConvertResourceStringToAtomString(Class cls) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
    {
        FindNode(trPackage,cls.getName(),cls);
        int g=0;
    }
    
    private void FindNode(TranslationPackage trPackage,String key,Class cls) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
    {
        String adres =  key.substring(0,key.lastIndexOf("."));
        if(KeyMap.containsKey(adres))
        {
            TranslationPackage trMapPackage = (TranslationPackage) KeyMap.get(adres);
            String name = cls.getSimpleName();
            for(TranslationPackage subPackage:trMapPackage.getSubPackages())
            {   
                if (subPackage.getName().equals(name))
                {
                   FindResourse(subPackage,cls);
                   break;
                }
            }
        }
        else
        {
            String adress="";
            TranslationPackage mapPackage = FindNode1(key,trPackage,adress);
            if(mapPackage!=null)
            {
                FindResourse(mapPackage,cls);
                int t=0;
            }
            else 
                System.out.println("yps");
        }
    }
    
    private TranslationPackage FindNode1(String key, TranslationPackage node,String adress)
    {
        TranslationPackage mapPackage1 = null;
        if (key.contains("."))
        {
            int index = key.indexOf(".");
            
            String substring1 = key.substring(0, index);
            adress=adress.concat(substring1);
            key = key.substring(index + 1, key.length());
            for (TranslationPackage child : node.getSubPackages())
            {
                if (child.getName().equals(substring1))
                {
                    KeyMap.put(adress, child);
                    adress=adress.concat(".");
                    mapPackage1=FindNode1(key, child,adress);
                    break;
                }
            }
        }
        else
        {
            for (TranslationPackage child1 : node.getSubPackages())
            {
                if (child1.getName().equals(key))
                {
                    mapPackage1=child1;
                    break;
                }
            }
        }
        return mapPackage1;
    }
    
    //создание ключа для ресурса
    private String CreateKey(Class c, Field f) 
    {
        Package p = c.getPackage();
        String className = c.getSimpleName().replace("$", ".");
        String key1 = p.getName() + "." + className + "." + f.getName();
        return key1;
    }
    
    //Нахождение соответствующих Atom ресурсам String ресурсы
    private void FindResourse(TranslationPackage trPackage,Class cl1) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
    {
        Field[] fields = cl1.getDeclaredFields();
        for(Field f:fields)
        {
            Class fieldType = f.getType();
            int modifiers = f.getModifiers();
            if (fieldType.getSimpleName().equals("ATOMStringResource")&&(Modifier.isStatic(modifiers)))
            {
                String key= CreateKey(cl1, f);
                for(ResourceString resStr:trPackage.getPackageTranslateResourcesString())
                {
                    if (resStr.getKey().equals(key))
                    {
                        //заполнение ATOM Resource
                        SetAtomResource(cl1,f,resStr);
                    }
                }
            }
        }
    }
    
    //заполнение Atom ресурса
    private void SetAtomResource(Class c,Field f,ResourceString resStr) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
    {
        f.setAccessible(true);
        Object atom = f.get(null);
        Class classMethod = atom.getClass();
         // with single parameter, return void
        String methodName = "setStr";
        Method setNameMethod = classMethod.getMethod(methodName,String.class,ELanguages.class );
        setNameMethod.invoke(atom, resStr.getString(ELanguages.Russian),ELanguages.Russian ); // pass arg
        setNameMethod.invoke(atom, resStr.getString(ELanguages.English),ELanguages.English);
    }
}
