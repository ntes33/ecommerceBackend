package it.ntesConsulting.wearU.service.interfce;

import it.ntesConsulting.wearU.dto.LoginRequest;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.dto.UserDto;
import it.ntesConsulting.wearU.entity.User;

public interface UserService {

	Response registerUser(UserDto registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getLoginUser();
    Response getUserInfoAndOrderHistory();
}
