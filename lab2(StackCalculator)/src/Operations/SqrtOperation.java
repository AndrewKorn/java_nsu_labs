package Operations;

import com.company.ExecutionContext;
import com.company.Operation;

public class SqrtOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) {
        Double a = executionContext.getStack().pop();
        executionContext.getStack().push(Math.sqrt(a));
    }
}
