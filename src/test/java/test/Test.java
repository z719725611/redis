package test;

import com.microblog.biz.BlogBiz;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test extends TestCase {

	// 测试redis点赞数的自增
	public void testApp09() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		BlogBiz ub = (BlogBiz) ac.getBean("blogBizImpl");
		System.out.println("当前点赞数" + ub.parse(2L, 5));
	}

	// 测试redis转发数
	public void testApp10() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans_mybatis.xml");
		BlogBiz ub = (BlogBiz) ac.getBean("blogBizImpl");
		System.out.println("当前转发数" + ub.relay(2L, 3));
	}
}
