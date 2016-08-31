/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;

/**
 *  Обертка класса TOriginal, определяющая реализацию  некоторого поведения TImplementataion в этом классе.
 * @author SERGEY
 * @param <TOriginal> Исходный класс, который реализует поведение TImplementataion
 * @param <TImplementataion> Класс поведения, которое обязуется реализовывать класс TOriginal
 */
public interface IWrap<TOriginal, TImplementataion>
{
    // Получить оригинальный объект, для которого создана обертка поведения
    TOriginal getOriginal();
    
    // Получить реализацию поведения TImplementataion класса TOriginal
    TImplementataion getWrap();
    
    // Получить класс, идентифицирующий разновидность поведения TImplementataion
    //Class<? extends TImplementataion> getImplementsClass();
    
    
    // Получить имя обертки (название типового поведения, реализованного в TImplementataion)
    //IATOMName getWrapName();
    
    // Получить имя варианта обертки (варианта реалиазции поведения)
    // Например, для реализации поведения "Соединить две точки на плоскости линией"
    // могут быть варианты: "соединить прямой", "соединить волнистой линией".
    // Если возвращает null, то считается, что данный вариант является вариантом по умолчанию
    //IATOMName getWrapVariantName();
}
