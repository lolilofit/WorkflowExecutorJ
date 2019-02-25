package com.main.operations;

import com.main.Main;
import com.main.OperationsInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Grep implements OperationsInterface {
    private static Logger log = Logger.getLogger(Grep.class.getName());

    public String block_work(String ... option_args) {
        String[] lines;
        String res = "";
        try {
            lines = option_args[1].split("\n");
            for (int i = 0; i < lines.length - 1; i++) {
                if (lines[i].contains(option_args[0]))
                    res += lines[i] + '\n';
            }
            if (lines[lines.length - 1].contains(option_args[0]))
                res += lines[lines.length - 1];
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
        return res;
    }
}
