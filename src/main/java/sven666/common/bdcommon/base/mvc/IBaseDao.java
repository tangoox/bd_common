package sven666.common.bdcommon.base.mvc;

import java.io.Serializable;
import java.util.List;

/**
 * 持久层 Bean 基类接口
 *
 * @param <T>
 * @param <PK>
 * @author : macbook[weide<weide001 @ gmail.com>]
 * @create : 2016年3月12日下午12:31:03
 */
public interface IBaseDao<T, PK extends Serializable> {

    /**
     * 插入一个对象
     * <p>
     * 备注：值为NULL的属性也会保存，不会使用数据库默认值。
     *
     * @param entity 要保存的对象
     * @return 数据插入后所影响的记录数目
     */
    public int insert(T entity);

    /**
     * 插入一个对象
     * <p>
     * 备注：值为NULL的属性不会保存，会使用数据库默认值
     *
     * @param entity 要保存的对象
     * @return 数据插入后所影响的记录数目
     */
    public int insertSelective(T entity);

    /**
     * 插入对象集合
     * <p>
     * 限制：支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列
     *
     * @param entities 要保存的对象集合
     * @return 数据插入后所影响的记录数目
     */
    public int insertList(List<? extends T> entities);

    /**
     * 插入一个对象
     * <p>
     * 限制：支持自增字段的数据库可以使用，例如MySQL,SQLServer等，自动为实体生成id属性并且必须为自增列，实体设置的主键策略无效
     *
     * @param entity 要保存的对象
     * @return 数据插入后所影响的记录数目
     */
    public int insertUseGeneratedKeys(T entity);

    /**
     * 删除一个对象
     * <p>
     * 备注：根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 要删除的对象
     * @return 数据删除后所影响的记录数目
     */
    public int delete(T entity);

    /**
     * 根据Example条件删除数据
     *
     * @param example 条件
     * @return 数据删除后所影响的记录数目
     */
    public int deleteByExample(Object example);

    /**
     * 根据主键字段进行删除
     * <p>
     * 限制：方法参数必须包含完整的主键属性
     *
     * @param key 主键取值
     * @return 数据删除后所影响的记录数目
     */
    public int deleteByPrimaryKey(PK key);

    /**
     * 根据Example条件更新实体entity包含的全部属性
     * <p>
     * 备注：NULL值也会被更新
     *
     * @param entity  更新的实体
     * @param example 条件
     * @return 数据更新后所影响的记录数目
     */
    public int updateByExample(T entity, Object example);

    /**
     * 根据Example条件更新实体entity包含的属性值
     * <p>
     * 备注：NULL值不会被更新
     *
     * @param entity  更新的实体
     * @param example 条件
     * @return 数据更新后所影响的记录数目
     */
    public int updateByExampleSelective(T entity, Object example);

    /**
     * 根据主键更新实体全部字段
     * <p>
     * 备注：NULL值也会被更新
     *
     * @param entity 更新的实体
     * @return 数据更新后所影响的记录数目
     */
    public int updateByPrimaryKey(T entity);

    /**
     * 根据主键更新实体全部字段
     * <p>
     * 备注：NULL值不会被更新
     *
     * @param entity 更新的实体
     * @return 数据更新后所影响的记录数目
     */
    public int updateByPrimaryKeySelective(T entity);

    /**
     * 根据实体中的属性值进行查询
     * <p>
     * 备注：查询条件使用等号
     *
     * @param entity 条件
     * @return 结果实体集合
     */
    public List<T> select(T entity);

    /**
     * 查询全部结果
     * <p>
     * 备注：select(null)方法能达到同样的效果
     *
     * @return 结果对象集合
     */
    public List<T> selectAll();

    /**
     * 根据Example条件进行查询
     * <p>
     * 备注：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
     * Condition方法和Example方法作用完全一样，只是为了避免Example带来的歧义，提供的的Condition方法
     *
     * @param example 条件
     * @return 结果实体集合
     */
    public List<T> selectByExample(Object example);


    /**
     * 根据主键字段进行查询
     * <p>
     * 备注：方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 条件主键值
     * @return 结果对象
     */
    public T selectByPrimaryKey(PK key);


    /**
     * 根据实体中的属性查询总数
     * <p>
     * 备注：查询条件使用等号
     *
     * @param entity 条件实体
     * @return 总数
     */
    public int selectCount(T entity);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example 条件
     * @return 总数
     */
    public int selectCountByExample(Object example);

    /**
     * 根据实体中的属性进行查询
     * <p>
     * 备注：只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 条件实体
     * @return 结果对象
     */
    public T selectOne(T entity);

}
