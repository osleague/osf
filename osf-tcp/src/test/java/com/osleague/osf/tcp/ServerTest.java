package com.osleague.osf.tcp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Yif Zhan on 2015/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet.xml"})
public class ServerTest {

    @Resource
    private ApplicationContext ctx;

    @Resource
    private TcpServer server;

    @Before
    public void setUp() {
        assertNotNull(ctx);//never  work
    }


    @Test
    public void testServer() {
        assertNotNull(server); //never  work
    }

    @Test
    public void testShutdown() {
        server.shutdown();//never  work
    }

}
