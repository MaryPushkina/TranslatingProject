/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageImportTranslateProject;

import atom.names.ELanguages;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import packageDataStructure.ResourceString;
import packageDataStructure.StatusPackage;
import packageDataStructure.StatusResource;
import packageDataStructure.TranslationPackage;
import packageDataStructure.TranslationProject;

/**
 *
 * @author Мария
 */
public class ParseXMLFile {
    
    private String nameXMLFile;
    
    private File inputFile ;
    
    private TranslationProject trProject = new TranslationProject();
    
    private DocumentBuilderFactory dbFactory; 
    
    private DocumentBuilder dBuilder;
    
    private Document doc;
    
    //создание пакета
    private TranslationPackage ParsePackageXML(Element packageElement)
    {
        TranslationPackage trPackage = new TranslationPackage();
        trPackage.setName(packageElement.getAttribute(Constants._xmlAttrPackageElement));
        if(packageElement.getAttribute(Constants._xmlStatusPackage).equals("Start_Package"))
            trPackage.setStatusPackage(StatusPackage.startPackage);
        if(packageElement.getAttribute(Constants._xmlStatusPackage).equals("New_Package"))
            trPackage.setStatusPackage(StatusPackage.newPackage);
        if(packageElement.getAttribute(Constants._xmlStatusPackage).equals("Change_Package"))
            trPackage.setStatusPackage(StatusPackage.changePackage);
        return trPackage;
    }
    
    //создание строкового ресурса
    private ResourceString ParseStringResourceXML(Element resStringElement)
    {
        ResourceString resString = new ResourceString();
        resString.setKey(resStringElement.getAttribute(Constants._xmlAttrKeyResStringElement));
        if(resStringElement.getAttribute(Constants._xmlStatusResourcesRus).equals("Start"))
            resString.setStatusResource(ELanguages.Russian,StatusResource.StartRes);
        if(resStringElement.getAttribute(Constants._xmlStatusResourcesRus).equals("New"))
            resString.setStatusResource(ELanguages.Russian,StatusResource.NewRes);
        if(resStringElement.getAttribute(Constants._xmlStatusResourcesRus).equals("Change"))
            resString.setStatusResource(ELanguages.Russian,StatusResource.ChangRes);
        
        if(resStringElement.getAttribute(Constants._xmlStatusResourcesEng).equals("Start"))
            resString.setStatusResource(ELanguages.English,StatusResource.StartRes);
        if(resStringElement.getAttribute(Constants._xmlStatusResourcesEng).equals("New"))
            resString.setStatusResource(ELanguages.English,StatusResource.NewRes);
        if(resStringElement.getAttribute(Constants._xmlStatusResourcesEng).equals("Change"))
            resString.setStatusResource(ELanguages.English,StatusResource.ChangRes);
        
        NodeList  nList = resStringElement.getChildNodes();
        for(int temp = 0; temp < nList.getLength(); temp++)
        {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
               Element eElement = (Element) nNode;
               if (eElement.getAttribute(Constants._xmlAttrLangTranslVariant).equals(Constants._xmlAttrRuLangTranslVariant))
               {
                 resString.setString(ELanguages.Russian,eElement.getTextContent() );
               }
               else
                  if (eElement.getAttribute(Constants._xmlAttrLangTranslVariant).equals(Constants._xmlAttrEngLangTranslVariant)) 
                  {
                      resString.setString(ELanguages.English,eElement.getTextContent());
                  }
            }
        }
        return resString;
    }
    
     //извлекаем из <resources> string ресурсы и добавляем их в пакет
    private void ParseResourcesXML(Element resources, TranslationPackage trPackage)
     {
         NodeList  nList = resources.getChildNodes();
         for(int temp = 0; temp < nList.getLength(); temp++)
         {
             Node nNode = nList.item(temp);
             if (nNode.getNodeType() == Node.ELEMENT_NODE)
             {
                 Element eElement = (Element) nNode;
                 if(eElement.getTagName().equals(Constants._xmlResStringElement))
                 {
                     ResourceString resStr = ParseStringResourceXML(eElement);
                     trPackage.setResource(resStr);
                 }
             }
         }
     }
     
    //извлекаем из <packages> пакеты
    private void ParsePackagesXML(Element packages, TranslationPackage trPackage)
     {
         NodeList  nList = packages.getChildNodes();
         for(int temp = 0; temp < nList.getLength(); temp++)
         {
             Node nNode = nList.item(temp);
             if (nNode.getNodeType() == Node.ELEMENT_NODE)
             {
                 Element eElement = (Element) nNode;
                 //если <пакет>
                 if(eElement.getTagName().equals(Constants._xmlPackageElement))
                 {
                     //создаем пакет ресурсов
                     TranslationPackage subTrPackage =ParsePackageXML(eElement);
                     //извлекаем детей из <пакет>
                     NodeList  nListChildren = eElement.getChildNodes();
                     for(int tempChild = 0; tempChild < nListChildren.getLength(); tempChild++)
                     {
                         Node nNodeChild = nListChildren.item(tempChild);
                          if (nNode.getNodeType() == Node.ELEMENT_NODE)
                          {
                              Element eElementChild = (Element) nNodeChild;
                              //если извлекли <пакеты>
                              if(eElementChild.getTagName().equals(Constants._xmlPackagesElement))
                              {
                                  //извлекаем из <packages> пакеты
                                  ParsePackagesXML(eElementChild, subTrPackage);
                              }
                              //если извлекли <ресурсы>
                              if(eElementChild.getTagName().equals(Constants._xmlResources))
                              {
                                  ParseResourcesXML(eElementChild, subTrPackage);
                              }
                          }
                     }
                     trPackage.addSubPackage(subTrPackage);
                 }
             }
         }
     }
     
    //извлекаем из <packages> пакеты в корень
    private void ParsePackagesinRoot(Element resources, TranslationProject trProject)
     {
         NodeList  nList = resources.getChildNodes();
         for(int temp = 0; temp < nList.getLength(); temp++)
         {
             Node nNode = nList.item(temp);
             if (nNode.getNodeType() == Node.ELEMENT_NODE)
             {
                 Element eElement = (Element) nNode;
                 //если <пакет>
                 if(eElement.getTagName().equals(Constants._xmlPackageElement))
                 {
                     //создаем пакет
                     TranslationPackage trPackage =ParsePackageXML( eElement);
                     //извлекаем из пакета детей
                     NodeList  nListChildren = eElement.getChildNodes();
                     for(int tempChild = 0; tempChild < nListChildren.getLength(); tempChild++)
                     {
                         Node nNodeChild = nListChildren.item(tempChild);
                         if (nNode.getNodeType() == Node.ELEMENT_NODE)
                         {
                             Element eElementChild = (Element) nNodeChild;
                             //если извлекли <пакеты>
                             if(eElementChild.getTagName().equals(Constants._xmlPackagesElement))
                             {
                                 //извлекаем из <packages> пакеты
                                 ParsePackagesXML(eElementChild, trPackage);
                             }
                             //если извлекли <ресурсы>
                             if(eElementChild.getTagName().equals(Constants._xmlResources))
                             {
                                 ParseResourcesXML(eElementChild, trPackage);
                             }
                         }
                     }
                     trProject.getPackageResources().add(trPackage);
                 }
             }
         }
     }
    
    public TranslationProject ParseFile(File file)throws ParserConfigurationException, SAXException, IOException
    {
        this.inputFile =file;
        nameXMLFile = file.getName();
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        trProject.setIDProject(doc.getDocumentElement().getAttribute(Constants._xmlAttrRootElement));
        NodeList nList = doc.getDocumentElement().getChildNodes();
        for(int temp = 0; temp < nList.getLength(); temp++)
         {
             Node nNode = nList.item(temp);
             if (nNode.getNodeType() == Node.ELEMENT_NODE)
             {
                 Element eElement = (Element) nNode;
                 if(eElement.getTagName().equals(Constants._xmlPackagesElement))
                 {
                    ParsePackagesinRoot(eElement, trProject);
                 }  
             }
         }
        return trProject;
    }

}
    
   
