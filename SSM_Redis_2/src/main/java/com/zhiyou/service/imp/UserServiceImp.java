package com.zhiyou.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.userService;

@Service
public class UserServiceImp implements userService {
	
	@Autowired
	UserDao dao;
	@CacheEvict(value="userselect",allEntries=true)
	public void add(User user) {
		dao.add(user);
		
	}
	@CacheEvict(value="userselect",allEntries=true)
	public void update(User user) {
		dao.update(user);
		
	}
	@CacheEvict(value="userselect",allEntries=true)
	public void delete(int id) {
		dao.delete(id);
		
	}
	@Cacheable(value="userselect")
	public List<User> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}
	@Cacheable(value="userselect")
	public User selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
