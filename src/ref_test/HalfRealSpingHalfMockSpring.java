package ref_test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.spring.ref.UserAction;
import com.atguigu.spring.ref.UserService;
/**
 * half mock half real is not in qiantao clause, is in parallel clause
 * because qiantao clause , if mock outer,only outer run,so not run inner.  
 * in parallet clause, even thouth the same object userService, I can use real userService and then I can use mock userService,see test() method result
 * so if you want to test qiantao in real, you must gouzao all the object and method result in real value
 * @author jaloli
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)//init spring container
@ContextConfiguration(locations = { "classpath:applicationContext-annotation.xml"})  //file:WebRoot/WEB-INF/*.xml
public class HalfRealSpingHalfMockSpring {
	
	@Autowired
    UserAction userAction;
	
	@Mock
	UserService userService;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);//unit test no need this code
        System.out.println(111);
    }

    @Test
    public void test() throws IllegalAccessException {
         Mockito.when(userService.serviceExecuteParam()).thenReturn("fuck");
         System.out.println(userService.serviceExecuteParam());
         
         Mockito.when(userService.serviceExecuteParamA()).thenCallRealMethod();//add this,next return A,if not add,next return null
         System.out.println(userService.serviceExecuteParamA());
         
         System.out.println(userAction.executeParams());  //this result tell us half mock half real(introduce in the first line), based on userService,   userService.serviceExecuteParam() is not fuck ? success
    }
    
    /**
     * 
     *  @Mock
	    UserAction userAction;
		
		@Autowired
		UserService userService;
     */
    @Test
    public void executeTest() throws IllegalAccessException {
    	Mockito.when(userAction.executeParam()).thenReturn("fuck");
    	System.out.println(userAction.executeParam()); //fuck, do not run into executeParam
    }
    
    
    
    
    
    
}
