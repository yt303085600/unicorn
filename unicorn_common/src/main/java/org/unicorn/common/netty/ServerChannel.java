package org.unicorn.common.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 通信信道工厂类
 * 
 * @author KING
 * @date 2018年8月21日
 */

public class ServerChannel  extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
       ChannelPipeline pipeline = ch.pipeline();
       
       //netty自带了很多handler,LoggingHandler
       //用于做netty收发消息时的日志输出,后期可以关闭,前期打开用于调试
       pipeline.addLast("logger",new LoggingHandler());     
       pipeline.addLast("decoder",new PBDecoder());  
       pipeline.addLast("encoder", new PBEncoder());
       pipeline.addLast("handler", new ServerIoHandler());
        
    }

}
