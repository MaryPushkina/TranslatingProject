///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package atom.collections;
//
//import atom.errors.ATOMReporter;
//import atom.events.IATOMEventDelegate;
//import atom.kernel.ParametrRef;
//import java.util.Enumeration;
//import java.util.List;
//import javax.swing.tree.TreeNode;
//
//
///**
// * Базовый класс реализации "Словаря"
// * @author SERGEY
// * @param <TKey>
// * @param <TValue>
// */
//public abstract  class DictionaryAbstract<TKey, TValue> implements IDictionary<TKey, TValue>
//{
//   // protected IATOMTree _SectionsTreeData; // Носитель данных о разделах словаря
//    protected ISection<TKey, TValue> _DefaultSection;
//    
//    protected Wrap_DictionaryAsTree _WrapAsTree;
//    
//  //##################################################################
//  //<editor-fold defaultstate="collapsed" desc="##### КЛАСС DictionaryStructureElement #####">
//  /**
//   * Базовый класс структурного элемента словаря (раздел или запись)
//   * @param <TKey>
//   * @param <TValue>
//   */
//  protected class DictionaryStructureElement //implements IDictionary.IRecord<TKey, TValue>
//  {
//    IDictionary<TKey, TValue> _ParentDictionary;
//    Wrap_AsTreeNode  _Wrap_AsTreeNode;
//
//    //##################################################################
//    //<editor-fold defaultstate="collapsed" desc="##### КЛАСС Wrap_AsTreeNode #####">
//    public class Wrap_AsTreeNode extends Wrap<DictionaryStructureElement, IATOMTree.INode> implements  IATOMTree.INode
//    {
//
//      protected Wrap_AsTreeNode(DictionaryStructureElement original, IATOMTree.INode implementation)
//      {
//         super(original, implementation);
//      }
//
//      @Override
//      public IATOMTree.INode getWrap()
//      {
//        return this;
//      }
//
////      @Override
////      public String getNodeCaption()
////      {
////        return _Implementation.getNodeCaption();
////      }
////
////      @Override
////      public String setNodeCaption(String nodeCaption)
////      {
////        return _Implementation.getNodeCaption();
////      }
//
//      @Override
//      public Object getNodeData()
//      {
//        return _Implementation.getNodeData();
//      }
//
//      @Override
//      public Object setNodeData(Object userData)
//      {
//        return _Implementation.setNodeData(userData);
//      }
//
//      @Override
//      public IATOMTree.ITreeBranch getChilds()
//      {
//        return _Implementation.getChilds();
//      }
//
//      @Override
//      public IATOMTree.INode getParent()
//      {
//        return _Implementation.getParent();
//      }
//
//      @Override
//      public IATOMTree.INode setParentNode(IATOMTree.INode parentNode)
//      {
//        return _Implementation.setParentNode(parentNode);
//      }
//
//      @Override
//      public IATOMTree.INode setParentNode(IATOMTree.INode parentNode, int childIndexToSet)
//      {
//        return _Implementation.setParentNode(parentNode, childIndexToSet);
//      }
//
//      @Override
//      public IATOMTree getParentTree()
//      {
//        return _Implementation.getParentTree();
//      }
//
//      @Override
//      public IATOMList<IATOMTree.INode> getPathToRoot()
//      {
//        return _Implementation.getPathToRoot();
//      }
//
//      @Override
//      public int getChildsCount()
//      {
//        return _Implementation.getChildsCount();
//      }
//
//      @Override
//      public int AppendChildNode(IATOMTree.INode appendingNode)
//      {
//        return _Implementation.AppendChildNode(appendingNode);
//      }
//
//      @Override
//      public void Insert(int index, IATOMTree.INode insertingNode)
//      {
//        _Implementation.Insert(index, insertingNode);
//      }
//
//      @Override
//      public IATOMTree.INode RemoveChildByIndex(int deletingNodeIndex)
//      {
//        return _Implementation.RemoveChildByIndex(deletingNodeIndex);
//      }
//
//      @Override
//      public void Remove()
//      {
//        _Implementation.Remove();
//      }
//
//        @Override
//        public IATOMTree.INode getChildAt(int childIndex)
//        {
//          return _Implementation.getChildAt(childIndex);
//        }
//
//        @Override
//        public int getChildCount()
//        {
//            return _Implementation.getChildCount();
//        }
//
//       
//
//        @Override
//        public int getIndex(TreeNode node)
//        {
//            return _Implementation.getIndex(node);
//        }
//
//        @Override
//        public boolean getAllowsChildren()
//        {
//            return _Implementation.getAllowsChildren();
//        }
//
//        @Override
//        public boolean isLeaf()
//        {
//           return _Implementation.isLeaf();
//        }
//
//        @Override
//        public Enumeration children()
//        {
//           return _Implementation.children();
//        }
//
//        @Override
//        public int getNodeLevel()
//        {
//          return _Implementation.getNodeLevel();
//        }
//
//        @Override
//        public int getOrderIndex()
//        {
//          return _Implementation.getOrderIndex();
//        }
//
//        @Override
//        public IATOMTree setParentTree(IATOMTree tree)
//        {
//          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public int RemoveAllChilds()
//        {
//          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//    }
//    //</editor-fold> КОНЕЦ "КЛАСС Wrap_AsTreeNode"
//    //##################################################################
//    
//    
//    protected DictionaryStructureElement(DictionaryAbstract<TKey, TValue> parentDictionary)
//    {
//      
////      _Wrap_AsTreeNode = new Wrap_AsTreeNode(this, 
////                  //new ATOMTreeAbstract.DefaultNode(parentDictionary._WrapAsTree._Implementation));
////                   new ATOMTreeAbstract.DefaultNode());
////       
////      _ParentDictionary = parentDictionary;
//       
//    }
//    
//    public IDictionary<TKey, TValue> getParentDictionary()
//    {
//      Wrap_DictionaryAsTree wrapAsTree = (Wrap_DictionaryAsTree)  _Wrap_AsTreeNode._Implementation.getChilds().getParentTree();
//      return wrapAsTree.getOriginal();
//    }
//    
////    
////    @Override
////    public ISection<TKey, TValue> ParentSection()
////    {
////      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
////
////    @Override
////    public TKey Key()
////    {
////      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
////
////    @Override
////    public TValue Value()
////    {
////      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
////
////    @Override
////    public IATOMList<ISection<TKey, TValue>> getFullSectionPath()
////    {
////      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
////        
//    
//
//    
//  }
////</editor-fold> КОНЕЦ "КЛАСС DictionaryStructureElement"
//  //##################################################################
//    
//    //##################################################################
//    //<editor-fold defaultstate="collapsed" desc="##### КЛАСС SectionAbstract<TKey, TValue> #####">
//    protected class SectionAbstract extends DictionaryStructureElement implements ISection<TKey, TValue>
//    {
//        /*Имя секции*/
//        protected String _SectionName;
//        
//        protected IATOMMap<TKey, TValue> _RecordsMap;
//        
//        //protected IATOMList<ISection<TKey, TValue>> _Sections;
//        
//        
//       
//        
//        protected SectionAbstract(String sectionName, DictionaryAbstract<TKey, TValue> parentDictionary,
//                                  IATOMMap<TKey, TValue> recordsMap)
//        { 
//          super(parentDictionary);
//          
//            if (parentDictionary == null)
//               ATOMReporter.ReportError(this.getClass().toString(), "parentDictionary can`t be null when creating new Section.");
//            
//          _SectionName = sectionName;
//          _ParentDictionary = parentDictionary;
//         // _NestedDictionary = nestedDictionary;
//         // _ParentSection = null;
//        }
//        
////         protected SectionAbstract(String sectionName, ISection<TKey, TValue> parentSection, IDictionary<TKey, TValue> nestedDictionary) 
////        { 
////           if (parentSection == null)
////               ATOMReporter.ReportError(this.getClass().toString(), "parentSection can`t be null when creating new Section.");
////              
////           
////          _SectionName = sectionName;
////          _ParentDictionary = parentSection.getParentDictionary();
////          _NestedDictionary = nestedDictionary;
////          _ParentSection = parentSection;
////        }
////        
//        @Override
//        public String getSectionName()
//        {
//           return _SectionName;             
//        }
//
//        @Override
//        public String toString()
//        {
//             return String.format("Раздел словаря '%s'", _SectionName);
//        }
//
//        @Override
//        public boolean equals(Object obj)
//        {
//           if (obj == null) return false;
//           if (obj instanceof ISection<?, ?>)
//           {
//              ISection<?, ?> sectionObj = (ISection<?, ?>)obj; 
//              String objSectionName = sectionObj.getSectionName();
//              if (_SectionName == null)
//                  return  (objSectionName == null); //(objSectionName == null) ? true : false; 
//                                                    // (Текущая секция без имени и переданная секия в obj также без имени)
//              else
//                  return _SectionName.equals(objSectionName);
//           }
//           return false;
//        }
//
//        @Override
//        public int hashCode()
//        {
//            return (_SectionName == null) ? 0: _SectionName.hashCode();
//        }
//
//        /*Получить словарь, в котором определена секция*/
//        @Override
//        public IDictionary<TKey, TValue> getParentDictionary()
//        {
//            return _ParentDictionary;
//        }
//        
//        /*Получить родительскую секцию*/
//        @Override
//        public ISection<TKey, TValue> getParentSection()
//        {
//            return null; // _ParentSection;
//        }
//
//        @Override
//        public IATOMList<ISection<TKey, TValue>> getFullSectionPath()
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        /** получить обертку секции словаря, превращающую работу с секцией как с отдельным словарем
////         * @return  Интерфейс поведения секции словаря в виде словаря        
////         */
//        @Override
//        public IDictionary<TKey, TValue> AsDictionary()
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public TValue AddRecord(TKey key, TValue value)
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        
//
//        @Override
//        public ISection<TKey, TValue> CreateSubSection(String sectionName)
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//        
//        /**
//         * Установить родительскую секцию
//         *
//         * @param newParent Новая родительская секция
//         * @return Предыдущая родительская секция, если она была
//         */
//        public ISection<TKey, TValue> SetParent(ISection<TKey, TValue> newParent)
//        {
//          // return _ParentDictionary.SetParent(newParent);
//          return null; // !!! ДОДЕЛАТЬ
//        }
//        
//
//        
//        /*Найти секцию по имени*/ 
//        @Override
//        public ISection<TKey, TValue> FindSection(String sectionName)
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        
//        
//        
//        /**
//       * Список подразделов данного раздела
//       *
//       * @return Список подразделов
//       */
//      @Override
//      public IATOMList<ISection<TKey, TValue>> SubSections()
//      {
//         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//      }
//
//      /**
//       * Список записей данного раздела
//       *
//       * @return Список записей раздела
//       */
//      @Override
//      public IATOMList<IRecord<TKey, TValue>> Records()
//      {
//         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//      }
//
//    @Override
//    public boolean IsContainsRecord(TKey key)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//        
//    
//    } // end class ParentSection
////</editor-fold> КОНЕЦ "КЛАСС SectionAbstract<TKey, TValue>"
////##################################################################
//    
//  //##################################################################
//  //<editor-fold defaultstate="collapsed" desc="##### Класс RecordAbstract<TKey, TValue> #####">
//  protected class RecordAbstract extends DictionaryStructureElement implements IRecord<TKey, TValue>
//    {
//        //ISection<TKey, TValue> _Section;
//        TKey     _Key;
//        TValue   _Value;
//    
//        
//        public RecordAbstract(DictionaryAbstract<TKey, TValue> dictionary, TKey key, TValue value)
//        {
//          super(dictionary);
//            //_Section = section;
//            _Key = key;
//            _Value = value;
//        }
//
//        @SuppressWarnings("unchecked") 
//        @Override
//        public ISection<TKey, TValue> ParentSection()
//        {
//          
//          
//           IATOMTree.INode parentNode = _Wrap_AsTreeNode._Implementation.getParent();
//           
//           Wrap_AsTreeNode wrap = (Wrap_AsTreeNode)parentNode;
//           DictionaryStructureElement  parentElement = wrap.getOriginal();
//           
//           return (ISection<TKey, TValue>)parentElement;
//        }
//
//        @Override
//        public TKey Key()
//        {
//            return _Key;
//        }
//
//        @Override
//        public TValue Value()
//        {
//           return _Value; 
//        }
//    
//        /**
//         * Получить строковое представление объекта
//         *
//         * @return Строковое представление объекта
//         */
//        @Override
//        public String toString()
//        {
////            String sSection = (_Section==null)? "": _Section.toString();
////            String sKey = (_Key==null)? "nullKey": _Key.toString();
////            String sValue = (_Value==null)? "null": _Value.toString();
////            
////        
////            if (_Section == null)
////                return String.format("%s='%s'", sKey,sValue);
////            else
////                return String.format("[%s] %s='%s'", sSection, sKey,sValue);
//          return "";
//        }
//
//        @Override
//        public IATOMList<ISection<TKey, TValue>> getFullSectionPath()
//        {
////            if (_Section == null)
////                return new ATOMList<ISection<TKey, TValue>>();
////            else
////                return _Section.getFullSectionPath();
//          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    } // end class RecordAbstract
////</editor-fold> КОНЕЦ "Класс RecordAbstract<TKey, TValue>"
////##################################################################
//
////##################################################################
////<editor-fold defaultstate="collapsed" desc="##### КЛАСС Wrap_DictionaryAsTree #####">
//protected class Wrap_DictionaryAsTree extends Wrap<DictionaryAbstract<TKey, TValue>, IATOMTree> implements IATOMTree
//{
//    IATOMTree _TreeData = new ATOMTree(); // Данные древовидной структуры
//
//    public Wrap_DictionaryAsTree(DictionaryAbstract<TKey, TValue> original, IATOMTree implementation)
//    {
//        super(original, implementation);
//    }
//    
//    @Override
//    public IATOMTree getWrap()
//    {
//       return this;
//    }
//   
//
//    //##################################################################
//     //<editor-fold defaultstate="collapsed" desc="##### ИНТЕРФЕЙС IATOMTree #####">
//  @Override
//  public INode getRoot()
//  {
//    return _TreeData.getRoot();
//  }
//
//  @Override
//  public int AppendNode(INode parentNode, INode appendingNode)
//  {
//    return _TreeData.AppendNode(parentNode, appendingNode);
//  }
//
//  @Override
//  public void InsertNode(INode parentNode, int index, INode insertingNode)
//  {
//    _TreeData.InsertNode(parentNode, index, insertingNode);
//  }
//
//  @Override
//  public INode RemoveChildByIndex(INode parentNode, int deletingNodeIndex)
//  {
//    return _TreeData.RemoveChildByIndex(parentNode, deletingNodeIndex);
//  }
//
//  @Override
//  public void RemoveChildByNode(INode deletingNode)
//  {
//    _TreeData.RemoveChildByNode(deletingNode);
//  }
//
//  @Override
//  public int AppendRootNode(INode rootNode)
//  {
//    return _TreeData.AppendRootNode(rootNode);
//  }
//  
//  /**
//   * Начало массового обновления модели данных. Изменения в данных будут накапливаться до
//   * момента вызова EndUpdate, когда будет уведомлено одним событием обо всех изменениях,
//   * произошедших в данных
//   *
//   * @return Текущее состояние массового обновления до данного вызова. Возвращает true,
//   *         если режим массового обновления уже был включен, false - иначе
//   */
//  @Override
//  public boolean BeginUpdate()
//  {
//    return _TreeData.BeginUpdate();
//  }
//
//  /**
//   * Окончание массового обновления модели данных. Все зарегистрированные изменения в
//   * данных будут разосланы слушателям соответствующих событий
//   */
//  @Override
//  public void EndUpdate()
//  {
//     _TreeData.EndUpdate();
//  }
//
//  /**
//   * Определить, находится ли модель данных в состоянии массового обновления
//   *
//   * @return true- модель находится в соостянии массового обновления данных, false - иначе
//   */
//  @Override
//  public boolean IsOnUpdating()
//  {
//    return _TreeData.IsOnUpdating();
//  }
//
//  /**
//   * В режиме массового обновления данных зафиксировать вновь вставленные в дерево узлы
//   *
//   * @param parentNode    Родительский узел
//   * @param insertedChild Втавленный узел
//   */
//  @Override
//  public void Fix_InsertedNodeData(IATOMTree.INode parentNode, IATOMTree.INode insertedChild,int insertAtIndex)
//  {
//    _TreeData.Fix_InsertedNodeData(parentNode, insertedChild, insertAtIndex);
//  }
//
//  /**
//   * В режиме массового обновления данных зафиксировать удаленные из дерева узлы
//   *
//   * @param parentNode   родительский узел, из которого удалили узел
//   * @param removedChild удаленный узел
//   */
//  @Override
//  public void Fix_RemovedNodeData(IATOMTree.INode parentNode, IATOMTree.INode removedChild, int removeFromIndex)
//  {
//     _TreeData.Fix_RemovedNodeData(parentNode, removedChild,removeFromIndex);
//  }
//
//  /**
//   * В режиме массового обновления данных зафиксировать узлы, в которых изменились
//   * соответствующие им данные
//   *
//   * @param updatedNode
//   */
//  @Override
//  public void Fix_UpdatedNodeData(IATOMTree.INode updatedNode)
//  {
//    _TreeData.Fix_UpdatedNodeData(updatedNode);
//  }
//
//
//  /**
//   * Делегат для подписывания слушателей
//   *
//   * @return Делегат для подписывания слушателей
//   */
//  @Override
//  public IATOMEventDelegate<IATOMTree, ATOMTreeAbstract.Events> Delegate()
//  {
//    return _TreeData.Delegate();
//  }
//  
////</editor-fold> КОНЕЦ "ИНТЕРФЕЙС IATOMTree"
//    //##################################################################
//
//        @Override
//        public INode CreateNodeInstance()
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public INode ReplaceNode(INode parentNode, int index, INode newReplacingNode, boolean isKeepChildsStructure)
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//    @Override
//    public int[] AppendRootNode(List<INode> rootNodes)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//        @Override
//        public void Fix_NodeReplaced(INode replacedNode, INode oldParent, int oldOrderIndex, INode newParent, int newOrderIndex)
//        {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//    @Override
//    public ITreeBranch getRootNodes()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public INode CreateNodeInstance(Object criteria)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean RelocateNode(INode parentNode, int insertIndex, INode relocatingNode)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int[] AppendRootNode(List rootNodes)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//
//
//   
//    
//   
//}
////</editor-fold> КОНЕЦ "КЛАСС Wrap_DictionaryAsTree"
////##################################################################
//
//
//    public DictionaryAbstract()
//    {
//      _WrapAsTree = new Wrap_DictionaryAsTree(this, null);
////      _DefaultSection = new SectionAbstract<TKey, TValue>("default", _DefaultSection, this)
////        _RootEntriesMap = new ATOMMap<TKey, TValue>();
////        _Sections = new ATOMList<ISection<TKey, TValue>>();
//    }
//
//  @Override
//    public TValue AddRecord(TKey key, TValue value)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        //return _RootEntriesMap.put(key, value);
//    }
//
////    @Override
////    public boolean AddRecord(ISection<TKey, TValue> section, TKey key, TValue value)
////    {
////        
////        int sectionIndex = _Sections.indexOf(section);
////        if (sectionIndex >=0)
////        { // Секция существует
////            
////        }
////       // ISection<TKey, TValue> foundedSection = 
////       
////    }
//
//    @Override
//    public boolean IsContains(TKey key)
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//      // return _RootEntriesMap.containsKey(key);
//    }
//
////    @Override
////    public boolean IsContains(ISection<TKey, TValue> section, TKey key)
////    {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
//
//    @Override
//    public TValue GetValue(TKey key, ParametrRef<Boolean> refFoundedFlag)
//    {
////        boolean isContainKey = _RootEntriesMap.containsKey(key);
////        refFoundedFlag.setValue(isContainKey);
////        return (isContainKey) ? _RootEntriesMap.get(key): null;
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
////    @Override
////    public TValue GetValue(ISection<TKey, TValue> section, TKey key, ParametrRef<Boolean> refFoundedFlag)
////    {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
//
////    @Override
////    public int AddSection(ISection<TKey, TValue> section, IDictionary<? extends TKey, ? extends TValue> dictionary)
////    {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
//
//      /**
//    * Создать новую корневую секцию
//     * @param parentSection родительский раздел для создаваемого раздела
//    * @param sectionName
//    * @return 
//    */
//    @Override
//    public ISection<TKey, TValue>  AddNewSection(String sectionName)
//    {
//      return  AddNewSection(null, sectionName);
//    }
//   
//       /**
//    * Создать новую секцию, вложенную в parentSection
//     * @param parentSection родительский раздел для создаваемого раздела
//    * @param sectionName
//    * @return 
//    */
//    @Override
//   public ISection<TKey, TValue>  AddNewSection(ISection<TKey, TValue> parentSection, String sectionName)
//   {
//      ISection<TKey, TValue> newSection=FabricateSectionInstance(sectionName,this, parentSection);
//      if (parentSection != null)
//          newSection = parentSection.CreateSubSection(sectionName);
//      else
//      {
//          //_Sections.add(newSection);
//      }
//      
//      return newSection;
//   }
//  
//   /**
//    * Установить родительскую секцию
//    * @param newParent Новая родительская секция
//    * @return Предыдущая родительская секция, если она была
//    */
//    public ISection<TKey, TValue> SetParent(ISection<TKey, TValue> newParent)
//    {
//      return null; //!!!! ДОДЕЛАТЬ
//    }
//   
//   
//    
//   /*Создание экземпляра секции словаря*/
//   protected abstract ISection<TKey, TValue> FabricateSectionInstance(String sectionName,
//          IDictionary<TKey, TValue> parentDictionary, ISection<TKey, TValue> parentSection);
//   
//    
//    /*Найти секцию по имени*/
//    @Override
//   public ISection<TKey, TValue> FindSection(String sectionName)
//   {
////      int foundedIndex = _Sections.indexOf(sectionName);
////      return (foundedIndex >=0) ? _Sections.get(foundedIndex) : null;
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   }
//
//   
//   /** Список корневых разделов словаря
//     *  @return Список подразделов
//     */
//    @Override
//    public IATOMList<ISection<TKey, TValue>> RootSections()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    /**Список записей словаря расположенных в безымянной секции (секции по умолчанию)
//     * @return Список записей безымянной секции
//     */
//    @Override
//    public  IATOMList<IRecord<TKey, TValue>> Records()
//    {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
//////##################################################################
//////<editor-fold defaultstate="collapsed" desc="##### ИТЕРАТОР Iterable<IEntry<TKey, TValue>> AllRootEntries #####">
////   @Override
////   public Iterable<IRecord<TKey, TValue>> AllRootEntries()
////    {
////
////        return new Iterable<IRecord<TKey, TValue>>()
////        {
////            @Override
////            public Iterator<IRecord<TKey, TValue>> iterator()
////            {
////                return new Iterator<IRecord<TKey, TValue>>()
////                {
////                    protected Iterator<Map.Entry<TKey, TValue>> _mapIteratorsetOfEntries;
////
////                    
////                    {
////                        _mapIteratorsetOfEntries = _RootEntriesMap.entrySet().iterator();
////                    }
////
////                    @Override
////                    public boolean hasNext()
////                    {
////                        return _mapIteratorsetOfEntries.hasNext();
////                    }
////
////                    @Override
////                    public IRecord<TKey, TValue> next()
////                    {
////                        Map.Entry<TKey, TValue> entry = _mapIteratorsetOfEntries.next();
////                        return new RecordAbstract<TKey, TValue>(null, entry.getKey(), entry.getValue());
////                    }
////
////                    @Override
////                    public void remove()
////                    {
////                        _mapIteratorsetOfEntries.remove();
////                    }
////
////                };
////            }
////        };
////    }
//////</editor-fold> КОНЕЦ "ИТЕРАТОР Iterable<IEntry<TKey, TValue>> AllRootEntries"
//////##################################################################
//  
//
//////##################################################################
//////<editor-fold defaultstate="collapsed" desc="##### ИТЕРАТОР Iterable<IEntry<TKey, TValue>> AllEntries() #####">
/////**
////     * Перечислить все записи в словаре, включая вложенные разделы
////     * @return Перечислитель записей для выражения foreach
////     */
////    @Override
////    public Iterable<IRecord<TKey, TValue>> AllEntries()
////    {
////        return new Iterable<IRecord<TKey, TValue>>()
////        {
////            @Override
////            public Iterator<IRecord<TKey, TValue>> iterator()
////            {
////                return new Iterator<IRecord<TKey, TValue>>()
////                {
////                    protected Iterator<Map.Entry<TKey, TValue>> _IteratorOfRootEntries;
////                    protected Iterator<IRecord<TKey, TValue>> _IteratorOfSectionEntries;
////                    protected Iterator<ISection<TKey, TValue>> _IteratorOfAllSections;
////                    protected ISection<TKey, TValue> _CurrentSection;
////                    protected boolean IsEnumeratingRootEntries = true;
////
////                    
////                    {
////                        
////                        _IteratorOfAllSections = _Sections.iterator();
////                        
////                    }
////
////                    @Override
////                    public boolean hasNext()
////                    {
////                        if (IsEnumeratingRootEntries)
////                        { // Перечисляем записи корневой секции
////                          IsEnumeratingRootEntries = _IteratorOfRootEntries.hasNext();
////                          if (IsEnumeratingRootEntries) return true;
////                        }  
////                  
////                        // Больше нет записей в корневом разделе. Перечисляем записи в разделах
////                        if (_CurrentSection == null)
////                        { // текущая секция еще не выбрана или закончилась предыдущая
////                            boolean isHasSections = false; 
////                            while (isHasSections == false)
////                            {
////                                isHasSections = _IteratorOfAllSections.hasNext();
////                                if (!isHasSections) return false; // Больше не осталось разделов
////                                
////                                _CurrentSection = _IteratorOfAllSections.next();
////                                // Проверяем, что в текущем разделе есть записи
////                                _IteratorOfSectionEntries = _CurrentSection.AllRootEntries().iterator();
////                                boolean isHasEntriesInSection =  _IteratorOfSectionEntries.hasNext();
////                                if (isHasEntriesInSection) return true; // Найдена запись в разделе
////                  
////                               isHasSections = false;
////                               
////                            } // while  (isHasSections == false)
////                        }
////                         else
////                        { // else (_CurrentSection == null)
////                          boolean isHasEntriesInSection = _IteratorOfSectionEntries.hasNext();
////                          if (isHasEntriesInSection) return true; // Найдена запись в разделе
////                          _CurrentSection = null;
////                          return hasNext();
////                        }
////                        
////                        return false; // недостижимая точка
////                    }
////
////                    @Override
////                    public IRecord<TKey, TValue> next()
////                    {
////                        if (IsEnumeratingRootEntries)
////                        {
////                           Map.Entry<TKey, TValue> entry =  _IteratorOfRootEntries.next();
////                           return new RecordAbstract<TKey, TValue>(null, entry.getKey(), entry.getValue());
////                        }
////                        else
////                        {
////                           return _IteratorOfSectionEntries.next();
////                        }
////                    }
////
////                    @Override
////                    public void remove()
////                    {
////                        if (IsEnumeratingRootEntries)
////                        {
////                          _IteratorOfRootEntries.remove();
////                        }
////                        else
////                        {
////                          _IteratorOfRootEntries.remove();
////                        }
////                    }
////
////                };
////            }
////        };
////    }
//////</editor-fold> КОНЕЦ "ИТЕРАТОР Iterable<IEntry<TKey, TValue>> AllEntries()"
//////##################################################################
////    
//////##################################################################
//////<editor-fold defaultstate="collapsed" desc="##### ИТЕРАТОР Iterable<ISection<TKey, TValue>> #####">
////  @Override
////  public Iterable<ISection<TKey, TValue>> AllRootSections()
////  {
////     return new Iterable<ISection<TKey, TValue>>()
////     {
////       @Override
////       public Iterator<ISection<TKey, TValue>> iterator()
////       {
////           return _Sections.iterator();
////       }
////     };
////  }
//////</editor-fold> КОНЕЦ "ИТЕРАТОР Iterable<ISection<TKey, TValue>>"
//////##################################################################
////  
//// 
////  
////  
//////##################################################################
//////<editor-fold defaultstate="collapsed" desc="##### ИНТЕРФЕЙС IWrapped<IDictionary<TKey, TValue>> #####">
////
////   
//////    /**
//////     * Получить все обертки (все возможные поведения) объекта
//////     * @return 
//////     */
//////    @Override  
//////    public IATOMList<IWrap<IDictionary<TKey, TValue>,?>> getAllWraps()
//////    {
//////    }
//////    
//////    /**
//////     * Зарегистрироваь обертку (поведение) для класса TOriginal
//////     * @param <TImplementation> java-тип, реализующий поведение обертки
//////     * @param implementationClass информация о классе-обертке, под которым было зарегистрировано поведение
//////     * @param implementationWrap реализация поведения
//////     * @return Зарегистрированная ранее обертка поведения  под тем же классам поведения implementationClass или null, 
//////     * если ранее поведения не было зарегистрировано
//////     */
//////    @Override
//////    public <TImplementation> IWrap<IDictionary<TKey, TValue>,TImplementation> 
//////      RegisterWrap(Class<? extends TImplementation> implementationClass,
//////                                                              IWrap<IDictionary<TKey, TValue>,TImplementation> implementationWrap)
//////    {
//////    }
//////    
//////    
//////
//////    /**
//////     * Найти обертку (реализацию поведения) данного объекта
//////     * @param <TImplementation> java-тип, реализующий поведение обертки
//////     * @param implementationClass информация о классе-обертке, под которым было зарегистрировано поведение
//////     * @return Реализация поведения implementationClass или null, если поведение не найдено
//////     */
//////    @Override
//////    public <TImplementation> IWrap<IDictionary<TKey, TValue>,TImplementation> 
//////                 FindWrap(Class<? extends TImplementation> implementationClass)
//////    {
//////                    
//////    }
////                 
//////</editor-fold> КОНЕЦ "ИНТЕРФЕЙС IWrapped<IDictionary<TKey, TValue>>"
//////##################################################################
////   
//  
//    
//    
//    
//}
