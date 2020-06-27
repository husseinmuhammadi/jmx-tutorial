package com.javastudio.tutorial.jmx;

import com.javastudio.tutorial.jmx.mbean.HelloMBean;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try {
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
            echo("\n>>> Perform operations on QueueSampler MXBean <<<");
            ObjectName mbeanName = new ObjectName("com.javastudio.tutorial:type=Hello");
            HelloMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);
            mbeanProxy.setCacheSize(150);
        } catch (MalformedObjectNameException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void echo(String msg) {
        System.out.println(msg);
    }
}
