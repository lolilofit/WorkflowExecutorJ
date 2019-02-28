package com.main;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executor {
    private FileInputStream in;
    private Map<String, OperationsInterface> blocks;
    private Map<String, String> block_args;
    private String package_name;
    private String workflow_in_name;

    private static Logger log = Logger.getLogger(Executor.class.getName());

    public Executor(String workflow_in, String pac_name) {
        workflow_in_name = workflow_in;
        package_name = pac_name;
        blocks = new HashMap<>();
        block_args = new HashMap<>();
    }

    public void executor() throws Exception {
        String[] line;
        boolean csed = true;
        String current_res = "";

        try {
            in = new FileInputStream(workflow_in_name);
            ReadPars reader = new ReadPars(in);

            while (!(line = reader.read())[0].equals("")) {

                if (line[0].equals("csed"))
                    csed = true;
                else {
                    if (line[0].equals("desc"))
                        csed = false;
                    else {
                        if (!csed) {
                            blocks.put(line[0], Factory.getInstance().create_op(package_name, line[1]));
                            block_args.put(line[0], line[2]);
                        } else {
                            current_res = blocks.get(line[0]).block_work(block_args.get(line[0]), current_res);
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "Exception happened: ", e);
        }
        in.close();
    }
}

