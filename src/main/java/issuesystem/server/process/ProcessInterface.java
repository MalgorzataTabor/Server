package issuesystem.server.process;

import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;

import java.util.List;

public interface ProcessInterface<T, R> {
    DataTransferObject<R> process(T obj);
}
