package com.study.mbean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@ManagedResource(objectName = "com.my:name=config", description = "config properties")
public class ConfigMBean {
    private String ips;

    @ManagedAttribute(description = "get config property")
    public String getIP() {
        return ips;
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "ip", description = "add config property")
    public void setIP(String ip) {
        ips=ip;
    }
}
