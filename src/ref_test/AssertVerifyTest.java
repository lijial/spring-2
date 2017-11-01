package ref_test;

import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by lijialiang on 2017/11/1.
 */
public class AssertVerifyTest {

    @Test
    public void simpleTest() {

        //创建mock对象，参数可以是类，也可以是接口
        @SuppressWarnings("unchecked")
        List<String> list = mock(List.class);

        // 设置方法的预期返回值
        when(list.get(0)).thenReturn("helloworld");

        // junit测试
        assertEquals("helloworld", list.get(0));

        // 验证方法调用(是否调用了get(0)),这个有用，1就是调用1次
        System.out.println(verify(list,times(1)).get(0));
    }

    @Test
    public void test2(){
        @SuppressWarnings("unchecked")
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("helloworld");

        /**
         * list为mock对象，不需要我们自己构造list并塞入元素
         * 这里返回true则程序正常通过，返回false则程序报异常
         */
        assertTrue(new StringOP().ifTheFirstIsHelloworld(list));
    }

    class StringOP{
        public boolean ifTheFirstIsHelloworld(List<String> list){
            return list.get(0).equals("helloworld");
        }
    }
}
