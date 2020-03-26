package com.intrasoft.stsc;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test Suite: TestUI");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();

        suites.add("test_suites/TestUI.xml");
        new File("reports").mkdirs();
        testng.setOutputDirectory("reports");
        testng.setTestSuites(suites);
        testng.addListener(tla);
        testng.run();
    }

}

