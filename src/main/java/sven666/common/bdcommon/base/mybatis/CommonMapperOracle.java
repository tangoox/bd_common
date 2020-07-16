package sven666.common.bdcommon.base.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.additional.dialect.oracle.OracleMapper;

/**
 * @author : S_ven
 * @create : 2019-05-23 17:23
 * @describe: CommonMapperOracle
 */
public interface CommonMapperOracle<T> extends Mapper<T>, OracleMapper<T> {


}