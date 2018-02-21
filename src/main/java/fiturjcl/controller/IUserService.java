package fiturjcl.controller;

import fiturjcl.user.User;
import fiturjcl.user.UserDto;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto);
}
