/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;

import atom.kernel.ParametrRef;


/**
 * Интерефейс "Словаря". Хранит пары ключ-значение
 * @author SERGEY
 * @param <TKey> Ключ словаря
 * @param <TValue> Хранимое значение в словаре
 */
public interface IDictionary<TKey, TValue>  //extends IWrapped<IDictionary<TKey, TValue>>
{
  //##################################################################
//<editor-fold defaultstate="collapsed" desc="##### интерфейс ISection #####">
/**
     * Интерфейс раздела в словаре
     * @param <TKey>
     * @param <TValue>
     */
    interface ISection<TKey, TValue> // extends IDictionary<TKey, TValue> 
    {
        String getSectionName();        

       
        @Override
        String toString();

        @Override
        boolean equals(Object obj);

        @Override
        int hashCode();
        
        /*Получить словарь, в котором определена секция*/
        IDictionary<TKey, TValue> getParentDictionary();
        
        
        /*Получить родительскую секцию*/
        ISection<TKey, TValue> getParentSection();
        
        /**
         * Получить последовательность вложений разделов друг в друга, начиная с корневого раздела в словаре и
         * заканчивая данным разделом.
         * Например. Для записи в структуре разделов словаря
         * /Проект А/Ресурсы/Общие/Иконки таблицы/
         * функция возвращает коллекцию {"Проект А", "Ресурсы", "Общие", "Иконки таблицы"}
         * @return Коллекция разделов, начиная с корневого раздела словаря, заканчивая текущим разделом
         */
         IATOMList<ISection<TKey, TValue>> getFullSectionPath();
        
         /** получить обертку секции словаря, превращающую работу с секцией как с отдельным словарем
         * @return  Интерфейс поведения секции словаря в виде словаря        
         */
         IDictionary<TKey, TValue>  AsDictionary();
         
         
          /**
     * Добавить запись в секцию словаря. Если запись по ключу key уже существует, то 
     * хранимое значение перезаписывается. 
     * @param key Ключ записи
     * @param value значение, хранимое по ключу
     * @return предыдущее значение, которое было записано по ключу
     */
       TValue AddRecord(TKey key, TValue value);

   
   /**
    * Проверить, хранится ли запись в секции словаря по ключу
    * @param key
    * @return true - запис по ключу найдена, false - иначе
    */
    boolean IsContainsRecord(TKey key);
   
   
   /**
    * Создать новую подсекцию
    * @param sectionName
    * @return 
    */
   ISection<TKey, TValue>  CreateSubSection(String sectionName);
   
   /*Найти секцию по имени*/
   ISection<TKey, TValue>  FindSection(String sectionName);
   
//   /** Перечислить все корневые записи в секции
//     * @return Перечислитель записей для выражения foreach*/
//   Iterable<IRecord<TKey, TValue>> AllRootEntries();
//   
//   /** Перечислить все записи в секции, включая вложенные разделы
//     * @return Перечислитель записей для выражения foreach*/
//   Iterable<IRecord<TKey, TValue>> AllEntries();
//   
//      /** Перечислить все корневые разделы в словаре
//     * @return Перечислитель разделов для выражения foreach*/
//    Iterable<ISection<TKey, TValue>> AllRootSections();
    
    /** Список подразделов данного раздела
     *  @return Список подразделов
     */
    IATOMList<ISection<TKey, TValue>> SubSections();
    
    /**Список записей данного раздела
     * @return Список записей раздела
     */
    IATOMList<IRecord<TKey, TValue>> Records();
    
 
    }
//</editor-fold> КОНЕЦ "интерфейс ISection"
  //##################################################################
    
    //##################################################################
//<editor-fold defaultstate="collapsed" desc="##### интерфейс IRecord<TKey, TValue> #####">
/**
     * Интерфейс записи в словаре  в виде пары ключ-значение
     * @param <TKey> Ключ словаря
     * @param <TValue> Хранимое значение в словаре
     */
   interface IRecord<TKey, TValue>
   {
       ISection<TKey, TValue>  ParentSection();
       TKey Key();
       TValue Value();
       
        /**
         * Получить последовательность вложений разделов друг в друга, начиная с корневого раздела в словаре и
         * заканчивая разделом, в который входит запись
         * Например. Для записи в структуре разделов словаря
         * /Проект А/Ресурсы/Общие/Иконки таблицы/Добавить запись.png
         * функция возвращает коллекцию {"Проект А", "Ресурсы", "Общие", "Иконки таблицы"}
         * @return Коллекция разделов, начиная с корневого раздела словаря, заканчивая разделом, в котором
         * располагается данная запись
         */
        IATOMList<ISection<TKey, TValue>> getFullSectionPath();
   }
    
//</editor-fold> КОНЕЦ "интерфейс IRecord<TKey, TValue>"
//##################################################################
    
    /**
     * Добавить запись в корневую секцию словаря. Если запись по ключу key уже существует, то 
     * хранимое значение перезаписывается. 
     * @param key Ключ записи
     * @param value значение, хранимое по ключу
     * @return предыдущее значение, которое было записано по ключу
     */
   TValue AddRecord(TKey key, TValue value);
   
//    /**
//     * Добавить запись в  секцию словаря с именем sectionName. Если запись по ключу key уже существует, то 
//     * хранимое значение перезаписывается. 
//     * @param section сеция, куда записывать данные
//     * @param key Ключ записи
//     * @param value значение, хранимое по ключу
//     * @return true - запись добавлена, false - иначе
//     */
//   boolean AddRecord(ISection<TKey, TValue> section, TKey key, TValue value);
   
   /**
    * Проверить, хранится ли запись в корневой секции словаря по ключу
    * @param key
    * @return true - запис по ключу найдена, false - иначе
    */
   boolean IsContains(TKey key);
   
//    /**
//    * Проверить, хранится ли запись в словаре в секции sectionName по ключу
//    * @param section сеция, где осуществлять поиск
//    * @param key
//    * @return true - запис по ключу найдена, false - иначе
//    */
//   boolean IsContains(ISection<TKey, TValue> section,TKey key);
   
   /**
    * Получить значение по ключу из корневой секции
    * @param key
    * @param refFoundedFlag
    * @return Значение, хранимое по ключу. Если значение не найдено, возвращается null.
    *         Признак обнаружения записи указывается в параметре refFoundedFlag
    */
   TValue GetValue(TKey key, ParametrRef<Boolean> refFoundedFlag);
   
//   /**
//    * Получить значение по ключу из секции sectionName
//    * @param section сеция, где осуществлять поиск
//    * @param key
//    * @param refFoundedFlag
//    * @return Значение, хранимое по ключу. Если значение не найдено, возвращается null.
//    *         Признак обнаружения записи указывается в параметре refFoundedFlag
//    */
//   TValue GetValue(ISection<TKey, TValue> section,TKey key, ParametrRef<Boolean> refFoundedFlag);
   
   
//   /**
//    * Добавить записи из словаря sectionDictionary, в раздел section текущего словаря.
//    * Если sectionDictionary равно null, то записи добавляются в корневую секцию
//    * @param section
//    * @param dictionary
//    * @return число добавленных записей
//    */
//   int AddSection(ISection<TKey, TValue> section, IDictionary<? extends TKey, ?extends TValue> dictionary);
   
   
   
   /**
    * Создать новую секцию
    * @param sectionName
    * @return 
    */
   ISection<TKey, TValue>  AddNewSection(String sectionName);
   
   /**
    * Создать новую секцию, вложенную в parentSection
     * @param parentSection родительский раздел для создаваемого раздела
    * @param sectionName
    * @return 
    */
   ISection<TKey, TValue>  AddNewSection(ISection<TKey, TValue> parentSection, String sectionName);
   
   /**
    * Установить родительскую секцию
    * @param newParent Новая родительская секция
    * @return Предыдущая родительская секция, если она была
    */
   ISection<TKey, TValue> SetParent(ISection<TKey, TValue> newParent);
   
   
   /*Найти секцию по имени*/
   ISection<TKey, TValue>  FindSection(String sectionName);
   
//   /** Перечислить все записи в словаре
//     * @return Перечислитель записей для выражения foreach*/
//   Iterable<IRecord<TKey, TValue>> AllRootEntries();
//   
//   /** Перечислить все записи в словаре, включая вложенные разделы
//     * @return Перечислитель записей для выражения foreach*/
//   Iterable<IRecord<TKey, TValue>> AllEntries();
//   
//   /** Перечислить все корневые разделы в словаре
//     * @return Перечислитель разделов для выражения foreach*/
//   Iterable<ISection<TKey, TValue>> AllRootSections();

    /** Список корневых разделов словаря
     *  @return Список подразделов
     */
    IATOMList<ISection<TKey, TValue>> RootSections();
    
    /**Список записей словаря расположенных в безымянной секции (секции по умолчанию)
     * @return Список записей безымянной секции
     */
    IATOMList<IRecord<TKey, TValue>> Records();
   
}
