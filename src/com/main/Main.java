package com.main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            Executor executor = new Executor("src/com/main/workflow_in.txt", "com.main.operations.");
            executor.executor();
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
    }
}
