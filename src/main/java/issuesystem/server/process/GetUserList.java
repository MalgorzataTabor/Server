package issuesystem.server.process;

import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;
import issuesystem.server.repository.UserRepository;


import java.util.List;

public class GetUserList implements ProcessInterface<Void,List<User>> {
    @Override
    public DataTransferObject<List<User>> process(Void obj) {
        List<User> userList = UserRepository.getUserList();
        return new DataTransferObject<>(DataTransferObject.GETUL, userList);
    }
}
