/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.kernel;

import java.util.ArrayDeque;

/**
 * Класс соссредствами облегчения отладки
 * @author Жиряков
 */
public class ATOMDebugUtils
{
  // Стек отметок времени
  protected static ArrayDeque<Long> _TimeMarks = new ArrayDeque<Long>();
  
  
  
  /**Засечь отметку времени для измерения интервалов времени*/
  public static void TimePeriodMeausre_Start()
  {
    _TimeMarks.push(System.nanoTime());
  }
  
  /**Получить число прошедших миллисекунд с момента последней засечеки времени
   * @return число прошедших миллисекунд с момента последней засечеки времени
   */
  public static int TimePeriodMeausre_End_ms()
  {
    return (int)(( System.nanoTime() - _TimeMarks.pop())/1000000.0f);
  }
  /**Получить число прошедших секунд с момента последней засечеки времени
   * @return Число прошедших секунд с момента последней засечеки времени*/
  public static int TimePeriodMeausre_End_sec()
  {
    return (int)((System.nanoTime() - _TimeMarks.pop())/1000000000.0f);
  }
  
}
