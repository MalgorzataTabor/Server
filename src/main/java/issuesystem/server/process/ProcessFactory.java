package issuesystem.server.process;

import issuesystem.dto.DataTransferObject;

public class ProcessFactory {
    public static <T>ProcessInterface<?, ?> getProcess(DataTransferObject<T> dto){
        switch (dto.getProcessName()){

            case DataTransferObject.ADU:
                return new AddUserProcess();

            case DataTransferObject.FUBL:
                return new GetUserByLogin();

            case DataTransferObject.DELU:
                return new DelUserProcess();
            case DataTransferObject.GETUL:
                return new GetUserList();

            default:
                return null;
        }
    }
}
