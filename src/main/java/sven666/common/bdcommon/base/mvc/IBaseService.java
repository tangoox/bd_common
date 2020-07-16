package sven666.common.bdcommon.base.mvc;


import java.io.Serializable;
import java.util.List;

/**
 * Web 请求处理业务服务基类接口
 *
 * @param <T>
 * @param <PK>
 * @author : macbook[weide<weide001@gmail.com>]
 * @create : 2016年3月12日下午12:34:17
 */
public interface IBaseService<T, PK extends Serializable> {

    public IBaseDao<T, PK> getBaseDao();

    public void setBaseDao(IBaseDao<T, PK> baseDao);

    /**
     * 插入一个对象
     * <p>
     * 备注：值为NULL的属性也会保存，不会使用数据库默认值。
     *
     * @param entity 要保存的对象
     * @return 数据插入后的对象
     */
    public T insert(T entity);

    /**
     * 插入一个对象
     * <p>
     * 备注：值为NULL的属性不会保存，会使用数据库默认值
     *
     * @param entity 要保存的对象
     * @return 数据插入后的对象
     */
    public T insertSelective(T entity);

    /**
     * 插入对象集合
     * <p>
     * 限制：支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列
     *
     * @param entities 要保存的对象集合
     * @return 数据插入后的对象集合
     */
    public List<? extends T> insertList(List<? extends T> entities);

    /**
     * 插入一个对象
     * <p>
     * 限制：支持自增字段的数据库可以使用，例如MySQL,SQLServer等，自动为实体生成id属性并且必须为自增列，实体设置的主键策略无效
     *
     * @param entity 要保存的对象
     * @return 数据插入后的对象
     * @method IBaseService: insertUseGeneratedKeys()
     * @memo TODO
     */
    public T insertUseGeneratedKeys(T entity);

    /**
     * 删除一个对象
     * <p>
     * 备注：根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 要删除的对象
     * @return int 数据删除后所影响的记录数目
     * @method IBaseService: delete()
     * @memo TODO
     */
    public int delete(T entity);

    /**
     * 根据Example条件删除数据
     *
     * @param example 条件
     * @return int 数据删除后所影响的记录数目
     * @method IBaseService: deleteByExample()
     * @memo TODO
     */
    public int deleteByExample(Object example);

    public int deleteByCondition(Object condition);

    /**
     * 根据主键字段进行删除
     * <p>
     * 限制：方法参数必须包含完整的主键属性
     *
     * @param key 主键取值
     * @return int 数据删除后所影响的记录数目
     * @method IBaseService: deleteByPrimaryKey()
     * @memo TODO
     */
    public int deleteByPrimaryKey(PK key);

    /**
     * 根据Example条件更新实体entity包含的全部属性
     * <p>
     * 备注：NULL值也会被更新
     *
     * @param entity  更新的实体
     * @param example 条件
     * @return T 数据更新后的实体
     * @method IBaseService: updateByExample()
     * @memo TODO
     */
    public T updateByExample(T entity, Object example);

    public T updateByCondition(T record, Object condition);

    /**
     * 根据Example条件更新实体entity包含的属性值
     * <p>
     * 备注：NULL值不会被更新
     *
     * @param entity  更新的实体
     * @param example 条件
     * @return T 数据更新后的实体
     * @method IBaseService: updateByExampleSelective()
     * @memo TODO
     */
    public T updateByExampleSelective(T entity, Object example);

    public T updateByConditionSelective(T record, Object condition);

    /**
     * 根据主键更新实体全部字段
     * <p>
     * 备注：NULL值也会被更新
     *
     * @param entity 更新的实体
     * @return T 数据更新后的实体
     * @method IBaseService: updateByPrimaryKey()
     * @memo TODO
     */
    public T updateByPrimaryKey(T entity);

    /**
     * 根据主键更新实体全部字段
     * <p>
     * 备注：NULL值不会被更新
     *
     * @param entity 更新的实体
     * @return T 数据更新后的实体
     * @method IBaseService: updateByPrimaryKeySelective()
     * @memo TODO
     */
    public T updateByPrimaryKeySelective(T entity);

    /**
     * 根据实体中的属性值进行查询
     * <p>
     * 备注：查询条件使用等号
     *
     * @param entity 条件
     * @return List<T> 结果实体集合
     * @method IBaseService: select()
     * @memo TODO
     */
    public List<T> select(T entity);

    /**
     * 查询全部结果
     * <p>
     * 备注：select(null)方法能达到同样的效果
     *
     * @return List<T> 结果对象集合
     * @method IBaseService: selectAll()
     * @memo TODO
     */
    public List<T> selectAll();

    /**
     * 根据Example条件进行查询
     * <p>
     * 备注：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
     * Condition方法和Example方法作用完全一样，只是为了避免Example带来的歧义，提供的的Condition方法
     *
     * @param example 条件
     * @return List<T> 结果实体集合
     * @method IBaseService: selectByExample()
     * @memo TODO
     */
    public List<T> selectByExample(Object example);

    public List<T> selectByCondition(Object condition);

//    /**
//     * 根据example条件和RowBounds进行分页查询
//     *
//     * @param example 条件
//     * @param bounds  分页参数
//     * @return List<T> 结果实体集合
//     * @method IBaseService: selectByExampleAndRowBounds()
//     * @memo TODO
//     */
//    public List<T> selectByExampleAndRowBounds(Object example, RowBounds bounds);

//    public List<T> selectByConditionAndRowBounds(Object condition, RowBounds rowBounds);

    /**
     * 根据主键字段进行查询
     * <p>
     * 备注：方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 条件主键值
     * @return T 结果对象
     * @method IBaseService: selectByPrimaryKey()
     * @memo TODO
     */
    public T selectByPrimaryKey(PK key);

//    /**
//     * 根据实体属性和RowBounds进行分页查询
//     *
//     * @param entity 条件实体
//     * @param bounds 分页参数
//     * @return List<T> 结果对象集合
//     * @method IBaseService: selectByRowBounds()
//     * @memo TODO
//     */
//    public List<T> selectByRowBounds(T entity, RowBounds bounds);

    /**
     * 根据实体中的属性查询总数
     * <p>
     * 备注：查询条件使用等号
     *
     * @param entity 条件实体
     * @return int 总数
     * @method IBaseService: selectCount()
     * @memo TODO
     */
    public int selectCount(T entity);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example 条件
     * @return int 总数
     * @method IBaseService: selectCountByExample()
     * @memo TODO
     */
    public int selectCountByExample(Object example);

    public int selectCountByCondition(Object condition);

    /**
     * 根据实体中的属性进行查询
     * <p>
     * 备注：只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 条件实体
     * @return T 结果对象
     * @method IBaseService: selectOne()
     * @memo TODO
     */
    public T selectOne(T entity);

}
