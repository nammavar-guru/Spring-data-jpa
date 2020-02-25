package SpringDataJpa.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository;
	
	public List<User> getUser(){
		return (List<User>) repository.findAll();
	}
	
	public void createUser(User user) {
		repository.save(user);
	}
	
	public User findById(int id) {
		Optional<User>  user = repository.findById(id);
        return user.get();
	}
	
	public void updateUser(User user, int id) {
		repository.save(user);
	}

	public void updateUserPartially(User user, int id) {
//		User currentUser = findById(id);
//		currentUser.setCountry(user.getCountry());
//		currentUser.setName(user.getName());
		repository.save(user);
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}
	
	public void deleteUserById(int id) {
		repository.deleteById(id);
	}
}
