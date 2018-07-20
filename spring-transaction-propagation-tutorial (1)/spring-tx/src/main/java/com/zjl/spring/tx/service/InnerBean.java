package com.zjl.spring.tx.service;

import com.zjl.spring.tx.model.User;

/**
 * 嵌套事务测试-内层事务方法提供类
 */
public interface InnerBean {

	void testRequired(User inner);

	void testRequiresNew(User inner);

	void testNested(User inner);
	
}
