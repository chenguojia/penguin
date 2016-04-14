package com.cardvalue.penguin.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by guojia.chen on 2016-01-06 10:21.
 *
 * @Description:
 */
public class RequestPipe {
    public String ip;
    private Timer timer;
    private Timer timer1;
    private String type;
    private final long timeOut = 24*60*60*1000;
    private final long rax = 10*1000;
    private SessionList lists;
    private int ipCount ;
    private int verityCode ;
    private boolean accessAble = false;


    public RequestPipe(String ip,String type){
        this.ip = ip;
        this.type = type;
        this.ipCount = 1 ;
        this.verityCode = 1;
    }


    public void setLists(SessionList lists) {
        this.lists = lists;
        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                RequestPipe.this.lists.remove(new RequestPipe(RequestPipe.this.ip,RequestPipe.this.type));
            }}, timeOut);

    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "RequestPipe [ip=" + ip + ", type=" + type + ", ipCount="
                + ipCount + ", verityCode=" + verityCode + "]";
    }


    @Override
    public boolean equals(Object obj) {
        RequestPipe eq= (RequestPipe) obj;
        if (this.ip.equals(eq.getIp()) && this.getType().equals(eq.getType()) && !(ipCount>3 || verityCode>3) )
            return true;
        return false;
    }

    public int update(RequestPipe pipe){

        if (this.type.equals("ip"))
            ipCount++;
        else if (this.type.equals("code"))
            verityCode++;
        System.out.println(toString());


        if (ipCount >3 || verityCode > 3)
            return RET_FAILED;
        else
            return RET_SUCCESS;

    }

    public static final int RET_SUCCESS = 1;
    public static final int RET_FAILED = 2;
}