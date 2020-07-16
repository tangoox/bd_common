package sven666.common.bdcommon.base.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用 MySQL Mapper 类
 *
 * @param <T>
 * @author : macbook[weide<weide001@gmail.com>]
 * @create : 2016年3月12日下午4:35:23
 */
public interface CommonMapperMySQL<T> extends Mapper<T>, MySqlMapper<T> {

}
