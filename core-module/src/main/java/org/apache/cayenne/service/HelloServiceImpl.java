package org.apache.cayenne.service;

public class HelloServiceImpl implements HelloService{
    @Override
    public String sayIt() {
        return "Hello";
    }
}
