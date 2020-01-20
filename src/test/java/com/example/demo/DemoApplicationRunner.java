/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

//import org.graalvm.compiler.lir.CompositeValue.Component;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Component;

/**
 *
 * @author vadim
 */
@Component
@TestConfiguration
public class DemoApplicationRunner implements ApplicationRunner{
        //private static Logger log = LoggerFactory.getLogger(DemoApplicationRunner.class);

    public DemoApplicationRunner () {
        System.out.print("Test Application Runner started!");
        //log.info("Test Application Runner started!");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.print("About to do nothing!");
        //log.info("About to do nothing!");
        // Do nothing...
    }
}