package com.xiaowa.bioart.common.handler;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/2/7. 类型处理器 继承BaseTypeHandler 或者实现TypeHandler
 * includeNullJdbcType=true， 将该类型处理器作用于ResultMap结果集
 */
@MappedJdbcTypes(value=JdbcType.VARCHAR,includeNullJdbcType = true)
//@MappedTypes(value = {'String'})
//public class Date2TypeHandler implements TypeHandler{
public class Str2TypeHandler extends BaseTypeHandler<String>{
    public Str2TypeHandler() {
        super();
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,s);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
