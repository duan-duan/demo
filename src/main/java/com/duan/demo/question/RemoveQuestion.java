package com.duan.demo.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: wangruirui
 * @date: 2019/06/20
 */
public class RemoveQuestion {
    public static void main(String[] agrs){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

//        会报错，所以 不能用for循环 add.和remove 元素 要用iterator
        for(String item:list) {
            if("2".equals(item)){
                list.remove(item);
            }
        }

        Iterator<String> listIterator = list.iterator();
        while(listIterator.hasNext()){
            String item = listIterator.next();
            if("2".equals(item)){
                listIterator.remove();
            }
        }

        for (String item : list){
            System.out.println(item);
        }

    }
}
