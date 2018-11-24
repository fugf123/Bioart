package com.xiaowa.bioart.util.InjectSqlHelper;

import com.xiaowa.bioart.util.CommonUtil;
import com.xiaowa.bioart.util.RegexUtil;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 11:52
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MybatisParamInterceptor implements Interceptor {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        String sqltype = "";
        String getColumnString = "";
        if (sql.toLowerCase().matches("^select.*$".toLowerCase())) {
            sqltype = "select";
            if (sql.toLowerCase().indexOf("order") > -1) {
                String[] templist = sql.toLowerCase().split("order");
                templist[templist.length - 1] = "";
                ;
                String tempstring = StringUtil.join(templist, " order ").substring(0, StringUtil.join(templist, " order ").length() - 6);
                getColumnString = tempstring;
            } else {
                getColumnString = sql.toLowerCase();
            }


        } else if (sql.toLowerCase().replaceAll("\\s*", "").matches("^update.*$".toLowerCase())) {
            sqltype = "update";
            getColumnString = RegexUtil.getString(sql.toLowerCase().replaceAll("\\s*", ""), "^update(.*)set.*$".toLowerCase(), 1);
        } else if (sql.replaceAll("\\s*", "").toLowerCase().matches("^insert.*$".toLowerCase())) {
            sqltype = "insert";
            getColumnString = RegexUtil.getString(sql.toLowerCase().replaceAll("\\s*", ""), "^insertinto([^\\(]*)\\(.*$".toLowerCase(), 1);
        }
        System.out.println("columns:" + getColumnString);
        Connection connection = (Connection) invocation.getArgs()[0];
        if (!getColumnString.replaceAll("\\s*", "").equals("")) {
            Map<String, Object> theColumns = getSqlColumn(getColumnString, connection);
        }
        logger.info("mybatis intercept sql:{}", sql);

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }


    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        logger.info("mybatis intercept dialect:{}", dialect);
    }

    public Map<String, Object> getSqlColumn(String sql, Connection connection) throws Exception {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        Statement statement = connection.createStatement();
        System.out.println("select * from ( select the = 0 ) A left join ( " + sql + ") B on 1<>1");
        ResultSet resultSet = statement.executeQuery("select * from ( select the = 0 ) A left join ( " + sql + ") B on 1<>1");
        connection.close();
        List<Map<String, Object>> resultList = CommonUtil.ResultSetToList(resultSet);
        return resultList.get(0);
    }
}
