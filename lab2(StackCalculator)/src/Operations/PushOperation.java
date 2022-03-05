package Operations;

import com.company.ExecutionContext;
import com.company.Operation;

public class PushOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) {
        executionContext.getStack().push(executionContext.getVariables().get(args[1]));
    }
}
