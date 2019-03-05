package com.main;

import java.lang.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factory {
    private Properties property;
    private static volatile Factory instance;

    private static Logger log = Logger.getLogger(Factory.class.getName());

    private Factory() {
        try {
            property = new Properties();
            property.load(Factory.class.getResourceAsStream("classes.properties"));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
    }

    public static Factory getInstance() {

        if (instance == null) {
            synchronized (Factory.class) {
                if (instance == null) {
                    instance = new Factory();
                }
            }
        }
        return instance;
    }

    public OperationsInterface create_op(java.lang.String package_name, java.lang.String key) {  //имя пакета тоже!

        OperationsInterface return_class = null;
        try {
            Class<?> _class = Class.forName(package_name + property.getProperty(key));
            return_class = (OperationsInterface) _class.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
        return return_class;
    }
}

