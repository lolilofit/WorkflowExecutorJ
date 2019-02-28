package com.main;

import java.io.*;
import java.lang.*;
import java.util.Properties;

public class Factory {
    private InputStream resourse;
    private Properties property;
    private static volatile Factory instance;

    public Factory() {
        property = new Properties();
        resourse = getClass().getResourceAsStream("classes.properties");
    }

    public static Factory getInstance() {
        if(instance == null) {
            synchronized (Factory.class) {
                if (instance == null) {
                    instance = new Factory();
                }
            }
        }
        return instance;
    }
    public OperationsInterface create_op(java.lang.String package_name, java.lang.String key) throws Exception {  //имя пакета тоже!

            property.load(resourse);
            Class<OperationsInterface> _class = (Class<OperationsInterface>) Class.forName(java.lang.String.valueOf(package_name + property.getProperty(key)));
            return _class.getDeclaredConstructor().newInstance();

    }
}


