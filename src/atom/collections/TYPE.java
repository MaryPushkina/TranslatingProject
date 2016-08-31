/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;

/**
 * Реализация интерфейса шаблона организационной группы хранения объектов "ПЕРЕЧИСЛЕНИЕ", обеспечивающего
 * хранение ассоциативного перечня "вариантов" для различных "Контекстов".
 * С каждым объектом TContext ассоциирован один перечень применимых вариантов - объектов типа TVariant
 * Можно задавать условие применимости одного из вариантов для всех контекстов (один и тот же вариант используетя для всех контекстов)
 * Можно задать исключение общего варианта из использования в определенном контексте.
 * Можно добавить использование нового варианта в определенном контексте
 * @author Жиряков
 * @param <TContext> Тип объекта - контекста, ассоциированного с перечнем вариантов
 * @param <TVariant> Тип объекта - варианта преречисления
 */
public class TYPE<TContext, TType, TObject> //implements ITYPE<TContext, TType, TObject>
{
//  /**Все допустимые варианты, используемые в контекстах*/
//  protected ATOMMap<String, ITYPE.IVariant<TContext, TType, TObject>> _AllVariants = new ATOMMap<String, ITYPE.IVariant<TContext, TType, TObject>>();
//  
//  
////##################################################################
////<editor-fold defaultstate="collapsed" desc="##### КОНТЕКСТ #####">
//public static class Context<TContext, TType, TObject> implements ITYPE.IContext<TContext, TType, TObject>
//  {
//
//    @Override
//    public IATOMList<IVariant<TContext, TType>> GetApplicableVariants()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IATOMList<TType> GetApplicableVariants_AsObjects()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IATOMList<IVariant<TContext, TType>> GetApplicableVariants_OfThisContextOnly()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IATOMList<TType> GetApplicableVariants_OfThisContextOnly_AsObjects()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void AddApplicableVariant(IVariant<TContext, TType> newVariant)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void SetUsingVariants(IATOMListReader<IVariant<TContext, TType>> variantsList)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public IATOMList<IVariantApplicabilityRule<TContext, TType>> GetApplicabilityRecords()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void ExcludeVariant(IVariant<TContext, TType> variant)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public TContext GetContextObject()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//  
//
//  }
////</editor-fold> КОНЕЦ "КОНТЕКСТ"
////##################################################################
//
//  //##################################################################
////<editor-fold defaultstate="collapsed" desc="##### ВАРИАНТ #####">
//public static class Variant<TContext, TVariant> implements ITYPE.IVariant<TContext, TVariant>
//  {
//
//    @Override
//    public String getVariantFullCaption()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getVariantShortCaptionName()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getVariantDesignation()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setVariantFullCaptionName(String fullCaption)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setVariantShortCaptionName(String shortCaption)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setVariantDesignation(String variantDesignation)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void UseInContext(IContext<TContext, TVariant> context)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void NotUseInContext(IContext<TContext, TVariant> context)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void UseInAllContexts()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public TVariant GetVariantObject()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//  }
////</editor-fold> КОНЕЦ "ВАРИАНТ"
////##################################################################
//  
//  //##################################################################
////<editor-fold defaultstate="collapsed" desc="##### ПРАВИЛО ПРИМЕНИМОСТИ #####">
//public static class VariantApplicabilityRule<TContext, TVariant> implements ITYPE.IVariantApplicabilityRule<TContext, TVariant>
//  {
//
//    @Override
//    public TVariant getVariant()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public TContext getContext()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public EVariantApplicabilityType getApplicabilityType()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getVariantOrderNumberInContext()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//  }
////</editor-fold> КОНЕЦ "ПРАВИЛО ПРИМЕНИМОСТИ"
////##################################################################
//  
//  @Override
//  public IATOMList<IVariant<TContext, TVariant>> GetAllVariants()
//  {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//
//  @Override
//  public void AddVariant(IVariant<TContext, TVariant> newVariant)
//  {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//
//  @Override
//  public void RemoveVariant(IVariant<TContext, TVariant> removingVariant)
//  {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//
//  @Override
//  public void RemoveVariantByObject(TVariant removingVariantObject)
//  {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//
//  @Override
//  public IVariantApplicabilityRule<TContext, TVariant> AddVariantApplicabilityRule(IContext<TContext, TVariant> context, IVariant<TContext, TVariant> variant, EVariantApplicabilityType applicabilityType)
//  {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//
//  @Override
//  public void RemoveVariantApplicabilityRule(IVariantApplicabilityRule<TContext, TVariant> removingRule)
//  {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//  
//    
//    
}
