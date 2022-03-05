package Operations;

import com.company.ExecutionContext;
import com.company.Operation;

public class DivOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) {
        Double first = executionContext.getStack().pop();
        Double second = executionContext.getStack().pop();
        executionContext.getStack().push(first / second);
    }
}
