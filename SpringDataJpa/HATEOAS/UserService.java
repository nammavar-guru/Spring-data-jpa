package SpringDataJpa.HATEOAS;

import java.util.List;



public interface UserService {
	public List<User> getUser(); 
	public void createUser(User user);
	public User findById(int id);
	public void updateUser(User user, int i);
	public void updateUserPartially(User user, int id);
	public void deleteUserById(int id);
	public void deleteUser(User user);

}
