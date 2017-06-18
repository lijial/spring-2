package ref_test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.test.context.ContextConfiguration;
import org.mockito.runners.MockitoJUnitRunner;

import com.atguigu.spring.ref.UserAction;
import com.atguigu.spring.ref.UserDao;
import com.atguigu.spring.ref.UserService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/*.xml" })
public class UserActionTest2 {
	@InjectMocks
	UserAction userAction;
	@Mock
	UserService userService;
	@Mock
	UserDao userDao;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);//if not , system dont know userService and userDao
        								//there's no relationship between userAction and userService¡¢ userDao
    }

    @Test
    public void test() {
//        Mockito.doNothing().doThrow(java.lang.Exception.class).when(userService).addNew();//correct,when call userService.addNew() orrur exception,no
    	 																		//run into addNew() method
        Mockito.doNothing().doThrow(new java.lang.IllegalAccessException()).when(userService).addNew();//correct,no doThrow(java.lang.IllegalAccessException.class)    
        userAction.execute();
//        userAction.executeParam();
    }    
	
}
