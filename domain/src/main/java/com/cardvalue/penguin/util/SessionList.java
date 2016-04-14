package com.cardvalue.penguin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by guojia.chen on 2016-01-06 10:21.
 *
 * @Description:
 */
public class SessionList {
    private List<RequestPipe> list = new ArrayList<RequestPipe>();
    private Lock lock = new ReentrantLock();

    //移除session
    public void remove(RequestPipe ed){
        lock.lock();
        System.out.println("ip为："+ed.toString()+" 的对象已经被移除");
        list.remove(ed);
        lock.unlock();
    }

    //查询session
    public boolean find(RequestPipe ed){
        lock.lock();
        boolean b = list.contains(ed);
        lock.unlock();
        return b;
    }

    public void add(String ip,String type){

        lock.lock();
        RequestPipe rp = new RequestPipe(ip,type);
        rp.setLists(this);
        list.add(rp);
        System.out.println("正在添加数据：ip="+ip+"  type="+(type.equals("ip")?"注册接口加入对列":"验证码接口添加到对列"));
        lock.unlock();
    }


    public RequestPipe getRequestPipe(RequestPipe rp){
        return list.get(list.indexOf(rp));
    }
}

