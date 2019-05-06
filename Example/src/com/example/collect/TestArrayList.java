package com.example.collect;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Student> array  = new ArrayList<Student>();
       Student s1 =  new Student("张飞",53);
       Student s2 =  new Student("刘备",63);
       Student s3 =  new Student("方友文",43);
       Student s4 =  new Student("董锤瑞",18);
       Student s5 =  new Student("阿三",30);
       Student s6 =  new Student("草上飞",23);
       Student s7 =  new Student("方友文",43);
       Student s8 =  new Student("董锤瑞",18);
        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);
        array.add(s5);
        array.add(s6);
        array.add(s7);
       ArrayList<Student> list  = new ArrayList<Student>();
       for(Student stu:array){
           if(!list.contains(stu)){
               list.add(stu);
           }
       }
       for (Student stu:list){
           System.out.println(stu);
       }
    }
}
