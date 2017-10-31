package ref_test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.spring.ref.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)//init spring container
@ContextConfiguration(locations = { "classpath:applicationContext-annotation.xml"})  //file:WebRoot/WEB-INF/*.xml

public class UserActionTest extends AbstractJUnit4SpringContextTests {

	@Autowired
    UserAction userAction;
	
	@Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);//unit test no need this code
    }

    @Test
    public void test() throws IllegalAccessException {
        userAction.execute();
        System.out.println(userAction.executeParam());
        System.out.println(111);


    }
}
