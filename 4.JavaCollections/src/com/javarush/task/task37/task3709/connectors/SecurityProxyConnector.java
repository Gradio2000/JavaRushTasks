package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector{
    private SimpleConnector simpleConnector;
    SecurityChecker securityChecker = new SecurityCheckerImpl();

    public SecurityProxyConnector(String resource) {
        this.simpleConnector = new SimpleConnector(resource);
    }

    @Override
    public void connect() {
       if (securityChecker.performSecurityCheck()){
           simpleConnector.connect();
       }
    }
}
