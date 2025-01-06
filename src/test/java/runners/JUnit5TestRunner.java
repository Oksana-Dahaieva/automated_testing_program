package runners;

import api.DashboardTest;
import api.FilterTests;
import api.LaunchesTest;
import api.WidgetTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LaunchesTest.class, FilterTests.class, DashboardTest.class, WidgetTest.class})
public class JUnit5TestRunner {

}
