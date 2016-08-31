/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;

/**
 * Интерфейс класса, имеющего обертки различного поведения
 * @author SERGEY
 * @param <TOriginal> исходный тип, для которого созданы обертки поведения
 */
public interface IWrapped<TOriginal>
{
//    /** Получить оригинальный объект, для которого создана обертка поведения
//     * @return  */
//    TOriginal GetOriginal();
    
    /**
     * Получить все обертки (все возможные поведения) объекта
     * @return 
     */
    IATOMList<IWrap<TOriginal,?>> getAllWraps();
    
    /**
     * Зарегистрироваь обертку (поведение) для класса TOriginal
     * @param <TImplementation> java-тип, реализующий поведение обертки
     * @param implementationClass информация о классе-обертке, под которым было зарегистрировано поведение
     * @param implementationWrap реализация поведения
     * @return Зарегистрированная ранее обертка поведения  под тем же классам поведения implementationClass или null, 
     * если ранее поведения не было зарегистрировано
     */
    <TImplementation> IWrap<TOriginal,TImplementation> RegisterWrap(Class<? extends TImplementation> implementationClass,
                                                              IWrap<TOriginal,TImplementation> implementationWrap);
    
    

    /**
     * Найти обертку (реализацию поведения) данного объекта
     * @param <TImplementation> java-тип, реализующий поведение обертки
     * @param implementationClass информация о классе-обертке, под которым было зарегистрировано поведение
     * @return Реализация поведения implementationClass или null, если поведение не найдено
     */
    <TImplementation> IWrap<TOriginal,TImplementation> FindWrap(Class<? extends TImplementation> implementationClass);
    
}
