package com.yahya.runner;

import com.yahya.day8.BaseAuthTest;
import com.yahya.day8.LibraryLoginTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Smoke Test")
//@SelectPackages({"com.yahya.day8"})
@SelectPackages({"com.yahya.day7", "com.yahya.day1"})
//@SelectClasses(LibraryLoginTest.class)
public class TestRunner {


}
