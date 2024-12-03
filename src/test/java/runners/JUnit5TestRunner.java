package runners;

import junit5.DashBoardTest;
import junit5.FilterTests;
import junit5.LaunchesTest;
import junit5.WidgetTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LaunchesTest.class, FilterTests.class, DashBoardTest.class, WidgetTest.class})
public class JUnit5TestRunner {

}
