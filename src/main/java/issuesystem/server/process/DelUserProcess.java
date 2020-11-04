package issuesystem.server.process;

import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;
import issuesystem.server.repository.UserRepository;

import java.util.List;

public class DelUserProcess implements ProcessInterface <Integer, Integer> {

    @Override
    public DataTransferObject<Integer> process(Integer Id) {

        boolean isRemove=  UserRepository.removeUser(Id );
        if(isRemove){
            return new DataTransferObject<>(DataTransferObject.DELU, 1);
        }else{
            return new DataTransferObject<>(DataTransferObject.DELU, -1);

        }
    }
}
