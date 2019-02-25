package com.main.operations;

import com.main.OperationsInterface;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadFile implements OperationsInterface {
    private static Logger log = Logger.getLogger(ReadFile.class.getName());

    public String block_work(String ... option_args) {
        StringBuilder text = new StringBuilder();
        boolean first = false;
        int symb;
        char ch;

        try {
            String name = option_args[0].replace(" ", "");
            FileInputStream in = new FileInputStream("src/com/main/operations/" + name);

            while ((symb = in.read()) != -1) {
                ch = (char) symb;
                if (first == false) {
                    first = true;
                    text.insert(0, ch);
                } else
                    text.append(ch);
            }
            in.close();
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }

        return text.toString();
    }
}
