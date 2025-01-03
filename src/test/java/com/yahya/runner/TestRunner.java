package com.yahya.runner;

import com.yahya.day8.BaseAuthTest;
import com.yahya.day8.LibraryLoginTest;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Smoke Test")
@SelectPackages("com.yahya.day9")
//@SelectPackages({"com.yahya.day7", "com.yahya.day1"})
//@SelectClasses(LibraryLoginTest.class)
//@SelectPackages({"com.yahya.day9"})
@IncludeTags("smoke1")
public class TestRunner {


}
