package com.main.operations;

import com.main.Main;
import com.main.OperationsInterface;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteFile implements OperationsInterface {
    private static Logger log = Logger.getLogger(WriteFile.class.getName());

    public String block_work(String ... option_args) {
        String text = "";
        try {
            String name = option_args[0].replace(" ", "");
            FileOutputStream out = new FileOutputStream("src/com/main/operations/" + name);
            byte[] buffer = option_args[1].getBytes();
            out.write(buffer, 0, buffer.length);
            out.close();
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
        return  text;
    }
}
