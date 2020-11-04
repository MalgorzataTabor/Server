package issuesystem.server.process;

import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;
import issuesystem.server.repository.UserRepository;

import java.util.List;

public class GetUserByLogin implements ProcessInterface<String,User >{

    @Override
    public DataTransferObject<User> process(String login) {
       User userByLogin = UserRepository.getUserByLogin(login);
        return new DataTransferObject<>(DataTransferObject.FUBL, userByLogin);
    }


}
