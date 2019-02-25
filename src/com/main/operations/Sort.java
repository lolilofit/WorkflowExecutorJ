package com.main.operations;

import com.main.Main;
import com.main.OperationsInterface;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Sort implements OperationsInterface {
    private static Logger log = Logger.getLogger(Sort.class.getName());

    public String block_work(String ... option_args) {
        String[] line;
        String res = new String();
        try {
            line = option_args[1].split("\n");
            Arrays.sort(line);
            for (int i = 0; i < line.length - 1; i++)
                res += line[i] + "\n";
            res += line[line.length - 1];
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
        return  res;
    }
}
