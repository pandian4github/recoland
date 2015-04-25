package com.housing.recoland.service;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
 
public class MyServer{
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.addServlet(new ServletHolder(new Servlet()), "/recoland");
        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] { servletContextHandler });
        server.setHandler(handlerList);
        server.start();
        server.join();
    }
}