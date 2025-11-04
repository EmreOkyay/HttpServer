package org.example.httpserver;

import org.example.httpserver.config.Configuration;
import org.example.httpserver.config.ConfigurationManager;
import org.example.httpserver.core.ServerListenerThread;

public class HttpServer {

    public static void main(String[] args) {
        System.out.println("Starting HTTP server...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using WebRoot: " + conf.getWebroot());

        ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
        serverListenerThread.start();
    }
}
