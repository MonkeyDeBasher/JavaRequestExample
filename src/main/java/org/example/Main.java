package org.example;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Main {
    public static void main(String[] args) {
        MyJavaRequest myRequest = new MyJavaRequest();
        JavaSamplerContext context = new JavaSamplerContext(new Arguments());
        SampleResult result = myRequest.runTest(context);
        System.out.println("Результат выполнения теста: " + result.getResponseMessage());
    }
}