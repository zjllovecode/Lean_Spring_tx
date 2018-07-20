package com.zjl.spring.tx.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjl.spring.tx.dao.TestDAO;
import com.zjl.spring.tx.model.User;
import com.zjl.spring.tx.service.InnerBean;
import com.zjl.spring.tx.service.OuterBean;

@Service
public class OuterBeanImpl implements OuterBean {
	private static final Log log = LogFactory.getLog(OuterBeanImpl.class);

	@Autowired
	private TestDAO testDAO;
	
	@Autowired
	private InnerBean innerBean;

	/** 调用方法可以是事务方法也可以是非事务方法 */
	@Override
	//@Transactional(propagation=Propagation.REQUIRED)
	public void testRequired(User outer, User inner) {
		testDAO.insertUser(outer);
		try{
			innerBean.testRequired(inner);
		} catch(RuntimeException e){
          log.error("内层方法出现异常回滚",e);
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequiresNew(User outer, User inner) {
		testDAO.insertUser(outer);
		try{
			innerBean.testRequiresNew(inner);
		} catch(RuntimeException e){
			log.error("内层方法出现异常回滚",e);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testNested(User outer, User inner) {
		testDAO.insertUser(outer);
		try{
			innerBean.testNested(inner);
		} catch(RuntimeException e){
			log.error("内层方法出现异常回滚",e);
		}
	}

}
