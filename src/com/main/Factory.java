package com.main;

import java.io.*;
import java.lang.*;
import java.util.Properties;

public class Factory {
    private InputStream resourse;
    private Properties property;
    public Factory() {
        property = new Properties();

    }

    public OperationsInterface create_op(java.lang.String package_name, java.lang.String key) throws Exception{  //имя пакета тоже!
        resourse = getClass().getResourceAsStream("classes.properties");
        property.load(resourse);
        String name = package_name + property.getProperty(key);

        Class<OperationsInterface> _class =  (Class<OperationsInterface>) Class.forName(java.lang.String.valueOf(package_name + property.getProperty(key)));
        return  _class.getDeclaredConstructor().newInstance();
    }

    void add_operation() {}
}
