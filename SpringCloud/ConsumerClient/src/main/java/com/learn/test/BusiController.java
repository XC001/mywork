package com.learn.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BusiController {
    private static Map<String, ArrayList<String>> cache = new ConcurrentHashMap<String, ArrayList<String>>();
    public void getWorkDay(String id){
        //1.根据key获取HashMap中的value值，value是个ArrayList的类型
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(getWeekDayData(id));
        //2.在第一步的结果上再加周六、周日
        arrayList.add("6");
        arrayList.add("7");
        //3.输出结果
        System.out.println(arrayList.toString());
    }

    /**
     * 获取工作日的上班数据（也就是周一到周五的上班数据）
     * @param id
     * @return
     */
    private ArrayList<String> getWeekDayData(String id){
        //判断HashMap是否有缓存，有则直接返回缓存中的值
        if(cache.get(id)!=null){
            return cache.get(id);
        }else{
            //如果没有，则初始化一个ArrayList返回
            synchronized (BusiController.class) {
                if(cache.get(id)!=null){
                    return cache.get(id);
                }
                //模拟从数据库中获取数据
                ArrayList arrayList = new ArrayList();
                arrayList.add("1");
                arrayList.add("2");
                arrayList.add("3");

                cache.put(id, arrayList);
                return arrayList;
            }
        }
    }
}
