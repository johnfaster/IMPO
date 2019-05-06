package com.example.collect;

import java.util.ArrayList;
import java.util.List;

public class TestCollect {
    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        List<String> list1 = new ArrayList<String>();
        list1.add("hello");
        list1.add("world");
        list1.add("c++");
        List<String> list2 = new ArrayList<String>();
        list2.add("hello");
        list2.add("world");
        list2.add("c#");
        List<String> list3 = new ArrayList<String>();
        list3.add("hello");
        list3.add("world");
        data.add(list1);
        data.add(list2);
        data.add(list3);
        intersection(list,list1,list2,list3);
    }

    public static List<String> intersection(List<String>...param){
        List<String> initlist = new ArrayList<String>();
        for (List<String> list : param) {
            if(initlist.isEmpty()){
                initlist.addAll(list);
                continue;
            }
            initlist.retainAll(list);
        }
        System.out.println(initlist);
        return null;

    }
}
