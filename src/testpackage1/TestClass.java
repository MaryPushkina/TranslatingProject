/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage1;
import atom.names.ATOMStringResource;
import atom.names.LanguageManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author Мария
 */
public class TestClass {
     static ATOMStringResource TestClass1 = new ATOMStringResource("asdasd", " TestClass 1 привет ");
     static ATOMStringResource TestClass2 = new ATOMStringResource("asdasd", " TestClass 1 привет1");
     static ATOMStringResource TestClass3 = new ATOMStringResource("asdasd", " TestClass 1 привет2");

     static
     {
         try {
             LanguageManager.getManagerXML().ConvertResourceStringToAtomString(TestClass.class);
         } catch (ParserConfigurationException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SAXException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalArgumentException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoSuchMethodException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InvocationTargetException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
