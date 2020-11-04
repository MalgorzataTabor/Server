package issuesystem.server.process;

import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;
import issuesystem.server.repository.UserRepository;

import java.util.List;

public class AddUserProcess implements ProcessInterface<User, User> {
    @Override
    public DataTransferObject<User> process(User obj) {
        User user = UserRepository.addListUser(obj);
        return new DataTransferObject<>(DataTransferObject.ADU, user);
    }
}
