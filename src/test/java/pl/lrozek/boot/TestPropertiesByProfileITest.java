package pl.lrozek.boot;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestPropertiesByProfileITest.class)
public class TestPropertiesByProfileITest {

    @Test
    public void itShouldGetPropertiesFromActiveProfile() throws Exception {
        // given

        // when

        // then
        assertThat( environment.getActiveProfiles(), hasItemInArray( "test" ) );
        assertThat( environment.getProperty( "spring.datasource.url" ), is( "jdbc:log4jdbc:h2:mem:boot-test" ) ); //this value is overidden by value from application-test.properties
        assertThat( environment.getProperty( "spring.datasource.driverClassName" ), is( "net.sf.log4jdbc.sql.jdbcapi.DriverSpy" ) );// this value is only present in application-test.properties
    }

    @Autowired
    private Environment environment;

}
