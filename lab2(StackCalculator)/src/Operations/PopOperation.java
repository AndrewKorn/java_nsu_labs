package Operations;

import com.company.ExecutionContext;
import com.company.Operation;

public class PopOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) {
        executionContext.getStack().pop();
    }
}
