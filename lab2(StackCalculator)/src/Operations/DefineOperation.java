package Operations;

import com.company.ExecutionContext;
import com.company.Operation;

public class DefineOperation implements Operation {

    @Override
    public void execute(String[] args, ExecutionContext executionContext) {
        executionContext.getVariables().put(args[1], Double.parseDouble(args[2]));
    }
}
