package com.sun.plate.mq.impl;

import com.sun.plate.mq.MqServer;
import org.zeromq.ZMQ;

/**
 * Created by sun on 2017/9/20.
 */
public class JeroMQServer implements MqServer {

  /**
   * 接受请求端口
   */
  private int respPort;

  /**
   * mq的端口
   */
  private int pubPort;

  /**
   * IO线程数
   */
  private int ioThreads = 5;

  private ZMQ.Context context;

  private ZMQ.Socket responder;

  private ZMQ.Socket publisher;

  private Thread thread;

  private boolean isStart = false;


  public void start() {
    if(!this.isStart)
    {
      this.thread = new Thread(new ResponserThread());
      this.context = ZMQ.context(ioThreads);
      this.responder = context.socket(ZMQ.REP);
      this.responder.bind("tcp://*:"+this.respPort);
      this.publisher = context.socket(ZMQ.PUB);
      this.publisher.bind("tcp://*:"+pubPort);
      this.thread.start();
      this.isStart = true;
    }


  }

  public void stop() {
    if(isStart)
    {
      this.thread.interrupt();
      this.thread = null;
      if(this.responder != null)
      {
        this.responder.close();
      }
      if(this.publisher != null)
      {
        this.publisher.close();
      }
      if(this.context != null)
      {
        this.context.term();
      }
    }

  }

  public int getRespPort() {
    return respPort;
  }

  public void setRespPort(int respPort) {
    this.respPort = respPort;
  }

  public int getPubPort() {
    return pubPort;
  }

  public void setPubPort(int pubPort) {
    this.pubPort = pubPort;
  }

  public int getIoThreads() {
    return ioThreads;
  }

  public void setIoThreads(int ioThreads) {
    this.ioThreads = ioThreads;
  }

  private class ResponserThread implements Runnable
  {

    public void run() {

      while (true)
      {
         String recvStr = responder.recvStr();
         if(recvStr == null)
         {
           continue;
         }
        publisher.send(recvStr);
        responder.send("OK");
      }
    }
  }

}
