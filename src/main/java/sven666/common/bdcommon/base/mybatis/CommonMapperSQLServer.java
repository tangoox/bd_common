package sven666.common.bdcommon.base.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.SqlServerMapper;

/**
 * 通用 SQLServer Mapper 类
 *
 * @param <T>
 * @author : macbook[weide<weide001@gmail.com>]
 * @create : 2016年3月12日下午4:39:55
 */
public interface CommonMapperSQLServer<T> extends Mapper<T>, SqlServerMapper<T> {

}
