package com.main.operations;

import com.main.OperationsInterface;

public class Replace implements OperationsInterface {

    public  String block_work(String ... option_args) {
        //отделить одно слово от др
        String[] words = option_args[0].split(" ");
        String res = option_args[1].replace(words[0], words[1]);
        return res;
    }
}
