package com.xiaowa.bioart.common.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Created by Administrator on 2018/2/7.
 * type 表示方法签名包含 Executor,
 * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 ParameterHandler (getParameterObject, setParameters)
 ResultSetHandler (handleResultSets, handleOutputParameters)
 StatementHandler (prepare, parameterize, batch, update, query)
 */
@Intercepts({@Signature(type = Executor.class,method ="update",args = {MappedStatement.class,Object.class})})
public class PluginInterceptor implements Interceptor
{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties.getClass());
    }
}
