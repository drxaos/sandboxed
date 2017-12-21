package com.github.drxaos.sandboxed;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {

        ArrayList<byte[]> list = new ArrayList<byte[]>();
        for (int a = 0; a < 100; a++) {
            for (int i = 0; i < 10; i++) {
                list.add(new byte[100000000]);
            }
        }

        list.clone();
    }
}
