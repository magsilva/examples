package identifier;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
{
	IdentifierTest_Functional.class,
	IdentifierTest_Structural.class
})
public class AllTests
{
}
