package com.osleague.osf.tcp;

import com.osleague.osf.core.annotation.RpcService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Yif Zhan on 2015/9/22.
 */
@Component
public class TcpServer implements ApplicationContextAware, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(TcpServer.class);

    private int port = 80;

    private HashMap<String, Class<?>> referenceMap = new HashMap<>();

    ServerBootstrap serverBootstrap;
    ChannelFuture channelFuture;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RpcService.class);
        for (Map.Entry<String, Object> beanEntry : beans.entrySet()) {
            String name = beanEntry.getKey();
            Object bean = beanEntry.getValue();
            Class<?> clazz = bean.getClass();
            RpcService annotation = clazz.getAnnotation(RpcService.class);
            String key = annotation.referrer().getName();
            referenceMap.put(key, clazz);
            System.out.println(key);
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {


        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline();
                }
            }).option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
            ;

            channelFuture = serverBootstrap.bind(port).sync();

            LOGGER.info("server started on port {}", port);

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    public void shutdown() {
        channelFuture.channel().close();
        LOGGER.info("server stopped successfully");
    }
}
