package Operations;

import com.company.ExecutionContext;
import com.company.Operation;

public class PrintOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) {
        System.out.println(executionContext.getStack().peek());
    }
}
