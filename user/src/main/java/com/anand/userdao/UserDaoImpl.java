package com.anand.userdao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anand.user.User;

@Component
public class UserDaoImpl implements UserDao {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jack", LocalDate.now().minusYears(20)));
	}

	@Override
	public List<User> findAll() {

		return users;
	}

	@Override
	public User save(User user) {

		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	@Override
	public User findOne(int id) {

		for (User use : users) {
			if (use.getId().equals(id)) {
				return use;
			}
		}

		return null;
	}

	@Override
	public void deleteByID(int id) {

		for (User use : users) {
			if (use.getId().equals(id)) {
				users.remove(use);
			}
		}

	}

}
