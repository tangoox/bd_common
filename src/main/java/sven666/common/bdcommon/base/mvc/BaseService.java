package sven666.common.bdcommon.base.mvc;

import java.io.Serializable;
import java.util.List;

/**
 * Web 请求处理业务服务抽象基类
 *
 * @param <T>
 * @param <PK>
 * @author : macbook[weide<weide001@gmail.com>]
 * @create : 2016年3月12日下午12:33:28
 */
abstract public class BaseService<T, PK extends Serializable> implements com.fc.common.base.mvc.IBaseService<T, PK> {

    @SuppressWarnings("unused")
    private IBaseDao<T, PK> baseDao = null;

    @Override
    public void setBaseDao(IBaseDao<T, PK> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T insert(T entity) {
        this.getBaseDao().insert(entity);
        return entity;
    }

    @Override
    public T insertSelective(T entity) {
        this.getBaseDao().insertSelective(entity);
        return entity;
    }

    @Override
    public List<? extends T> insertList(List<? extends T> entities) {
        this.getBaseDao().insertList(entities);
        return entities;
    }

    @Override
    public T insertUseGeneratedKeys(T entity) {
        this.getBaseDao().insertUseGeneratedKeys(entity);
        return entity;
    }

    @Override
    public int delete(T entity) {
        return this.getBaseDao().delete(entity);
    }

    @Override
    public int deleteByExample(Object example) {
        return this.getBaseDao().deleteByExample(example);
    }

    @Override
    public int deleteByCondition(Object condition) {
        return this.deleteByExample(condition);
    }

    @Override
    public int deleteByPrimaryKey(PK key) {
        return this.getBaseDao().deleteByPrimaryKey(key);
    }

    @Override
    public T updateByExample(T entity, Object example) {
        this.getBaseDao().updateByExample(entity, example);
        return entity;
    }

    @Override
    public T updateByCondition(T record, Object condition) {
        this.updateByExample(record, condition);
        return record;
    }

    @Override
    public T updateByExampleSelective(T entity, Object example) {
        this.getBaseDao().updateByExampleSelective(entity, example);
        return entity;
    }

    @Override
    public T updateByConditionSelective(T record, Object condition) {
        this.updateByExampleSelective(record, condition);
        return record;
    }

    @Override
    public T updateByPrimaryKey(T entity) {
        this.getBaseDao().updateByPrimaryKey(entity);
        return entity;
    }

    @Override
    public T updateByPrimaryKeySelective(T entity) {
        this.getBaseDao().updateByPrimaryKeySelective(entity);
        return entity;
    }

    @Override
    public List<T> select(T entity) {
        return this.getBaseDao().select(entity);
    }

    @Override
    public List<T> selectAll() {
        return this.getBaseDao().selectAll();
    }

    @Override
    public List<T> selectByExample(Object example) {
        return this.getBaseDao().selectByExample(example);
    }

    @Override
    public List<T> selectByCondition(Object condition) {
        return this.selectByExample(condition);
    }


    @Override
    public T selectByPrimaryKey(PK key) {
        return this.getBaseDao().selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T entity) {
        return this.getBaseDao().selectCount(entity);
    }

    @Override
    public int selectCountByExample(Object example) {
        return this.getBaseDao().selectCountByExample(example);
    }

    @Override
    public int selectCountByCondition(Object condition) {
        return this.selectCountByExample(condition);
    }

    @Override
    public T selectOne(T entity) {
        return this.getBaseDao().selectOne(entity);
    }

}
