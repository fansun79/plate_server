package com.sun.plate.mq;

/**
 * Created by sun on 2017/9/20.
 */
public interface MsgListener {

  void consume(String msg);

}
