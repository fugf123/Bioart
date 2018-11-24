package com.xiaowa.bioart.common.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2018/2/7. 自定义对象工厂
 */
public class CustomObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
