package com.javastudio.tutorial.jmx;

import com.javastudio.tutorial.jmx.mbean.Hello;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("Hello world!");
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.javastudio.tutorial:type=Hello");
            Hello mbean = new Hello();
            mbs.registerMBean(mbean, name);

            System.out.println("Waiting forever...");
            Thread.sleep(Long.MAX_VALUE);
        } catch (MBeanRegistrationException | InstanceAlreadyExistsException | NotCompliantMBeanException | MalformedObjectNameException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
