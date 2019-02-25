package com.main;

import java.io.*;
import java.util.*;

public class ReadPars {
    private InputStream in;

    ReadPars(InputStream _in) {
        in = _in;
    }

    public String[] read() throws IOException {
        String[] line = new String[3];
        for(int i = 0; i<3; i++)
            line[i] = "";
        //Массив пустых строк?
        StringBuilder word = new StringBuilder();

        int symb, k = 0;
        char ch, prev = '\n';
        boolean first = false;

        symb = in.read();
        while (symb != -1 && (char)symb != '\n' && !((char)symb == '>' && prev == '-')) {
            ch = (char) symb;
            if (ch != ' ') {
                if(first == false) {
                    first = true;
                    word.insert(0, ch);
                }
                else
                    word.append(ch);
            }
            else {
                if(prev != '=' && word.toString() != " " && ch != '=' && word.toString().length() != 0){
                    if (k == 0) {
                        line[0] = word.toString().replace("\r", "").replace(" ", "");
                        k++;
                    }
                    else {
                        if(k==1) {
                            line[1] = word.toString().replace("\r", "").replace(" ", "");
                            k++;
                        }
                        else
                            line[2] += (word.toString()).replace("\r", "") + " ";
                    }
                }

                word.setLength(0);
            }
            prev = ch;
            symb = in.read();
        }

        if(!((char)symb == '>' && prev == '-')) {
            if (k == 0)
                line[0] = word.toString().replace("\r", "").replace(" ", "");
            if (k == 1)
                line[1] = word.toString().replace("\r", "").replace(" ", "");
            if (k == 2)
                line[2] += (word.toString()).replace("\r", "");
        }
        return line;
    }

}
