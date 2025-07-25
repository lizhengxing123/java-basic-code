package com.lzx.collection;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollection {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();

        col.add("abc");
        col.add("abde");
        col.add("cdf");
        col.add("cde");

        col.removeIf(t -> t.length() > 3);
        System.out.println(col); // [abc, cdf, cde]
    }
}
