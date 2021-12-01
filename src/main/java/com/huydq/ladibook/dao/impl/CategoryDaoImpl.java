package com.huydq.ladibook.dao.impl;

//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Criteria;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.huydq.ladibook.dao.CategoryDao;
//import com.huydq.ladibook.entity.Category;
//
//@Transactional
//@Repository
//public class CategoryDaoImpl implements CategoryDao {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	public List<Category> findAll() {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
//		return criteria.list();
//	}
//
//}
