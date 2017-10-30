//package com.sun.plate.vm;
//
//import com.sun.plate.mq.Consumer;
//import com.sun.plate.mq.MsgListener;
//import java.util.Date;
//import org.zkoss.zk.ui.Desktop;
//import org.zkoss.zk.ui.Executions;
//import org.zkoss.zk.ui.select.SelectorComposer;
//import org.zkoss.zk.ui.select.annotation.VariableResolver;
//import org.zkoss.zk.ui.select.annotation.Wire;
//import org.zkoss.zk.ui.select.annotation.WireVariable;
//import org.zkoss.zul.Image;
//import org.zkoss.zul.Window;
//
///**
// * Created by sun on 2017/9/23.
// */
//@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
//public class CaptchaViewModel extends SelectorComposer<Window> implements MsgListener {
//
////  private Desktop desktop;
////
//
//  @WireVariable("testConsumer")
//  private Consumer consumer;
//
//  @Wire
//  private Image promptImage;
//
//  @Wire
//  private Image content;
//
//
//  @Override
//  public void doAfterCompose(Window win) throws Exception {
//    super.doAfterCompose(win);
//    final Desktop desktop = win.getDesktop();
//    desktop.enableServerPush(true);
////        JeroMQConsumer consumer = new JeroMQConsumer();
////    consumer.setHost("127.0.0.1");
////    consumer.setPort(6001);
////    consumer.setThreads(5);
////    consumer.init();
//    consumer.subscribe("TOPIC_TEST", new MsgListener() {
//      public void consume(String msg) {
//        try {
//          Executions.activate(desktop);
//          captchaTextbox.setText(new Date().toString());
//          Executions.deactivate(desktop);
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    });
//  }
//
//  public void consume(String msg) {
//
//  }
////
////  @Init
////  public void init(
////      @ContextParam(ContextType.DESKTOP) final Desktop desktop,@SelectorParam("#captchaTextbox") final Textbox textbox) {
////
////    System.out.println(textbox!= null);
////    this.desktop = desktop;
////    desktop.enableServerPush(true);
////    setContent("start");
////    JeroMQConsumer consumer = new JeroMQConsumer();
////    consumer.setHost("127.0.0.1");
////    consumer.setPort(6001);
////    consumer.setThreads(5);
////    consumer.init();
////    consumer.subscribe("TOPIC_TEST", new MsgListener() {
////      public void consume(String msg) {
////        try
////        {
////          Executions.activate(desktop);
////          setContent(msg);
////          Executions.deactivate(desktop);
////
////        }
////        catch (Exception e)
////        {
////          e.printStackTrace();
////        }
////      }
////    });
////
////  }
//
////  @Command
////  @NotifyChange("captchaTextbox")
////  public void input(@SelectorParam("#captchaTextbox") final  Textbox textbox1){
////
//////    System.out.println(textbox1 != null);
//////    JeroMQConsumer consumer = new JeroMQConsumer();
//////    consumer.setHost("127.0.0.1");
//////    consumer.setPort(6001);
//////    consumer.setThreads(5);
//////    consumer.init();
//////    consumer.subscribe("TOPIC_TEST", new MsgListener() {
//////      public void consume(String msg) {
//////        try
//////        {
//////          Executions.activate(desktop);
//////          textbox1.setText(msg);
//////          Executions.deactivate(desktop);
//////        }
//////        catch (Exception e)
//////        {
//////          e.printStackTrace();
//////        }
//////      }
//////    });
////
////  }
////
////  public String getContent() {
////    return content;
////  }
////
////  public void setContent(String content) {
////    this.content = content;
////  }
//}
