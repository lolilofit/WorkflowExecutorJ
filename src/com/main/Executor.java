package com.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Executor {
    private FileInputStream in;
    private Map<String, OperationsInterface> blocks;
    private Map<String, String> block_args;
    private String package_name;
    private String workflow_in_name;


    public Executor(String workflow_in, String pac_name) {
        workflow_in_name = workflow_in;
        package_name = pac_name;
        blocks = new HashMap<>();
        block_args = new HashMap<>();
    }

    private void open_file() throws IOException {
        in = new FileInputStream(workflow_in_name);
    }
    private void close_file() throws  IOException {
        in.close();
    }

    public void executor() throws Exception {
        String[] line;
        boolean csed = true;
        Factory factory = new Factory();
        String current_res = "";

        open_file();
        ReadPars reader = new ReadPars(in);
        while((line = reader.read())[0].equals("")) {
            if(line[0].equals("csed"))
                csed = true;
            else {
                if(line[0].equals("desc"))
                    csed = false;
                else {
                    if (csed == false) {
                        // String full_name = package_name + line[1];
                        blocks.put(line[0], factory.create_op(package_name, line[1]));
                        block_args.put(line[0], line[2]);
                    } else {
                        current_res = blocks.get(line[0]).block_work(block_args.get(line[0]), current_res);
                    }
                }
            }
        }
        close_file();
    }
}

