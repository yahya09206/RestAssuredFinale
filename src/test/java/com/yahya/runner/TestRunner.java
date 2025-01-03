package com.yahya.runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Smoke Test")
//@SelectPackages("com.yahya.day9")
//@SelectPackages({"com.yahya.day7", "com.yahya.day1"})
//@SelectClasses(LibraryLoginTest.class)
//@SelectPackages({"com.yahya.day9"})
@SelectPackages("com.yahya.tests")
//@IncludeTags({"smoke1", "smoke2"})
@IncludeTags("db")
//@ExcludeTags("smoke2")
public class TestRunner {


}
