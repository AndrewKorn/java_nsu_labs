import com.company.CalculatorException;
import com.company.Configuration;
import com.company.ExecutionContext;
import com.company.Operation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class PushOperationTest {
    @Test
    public void testSimplePush() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] argsDefine = {"DEFINE", "a", "4"};
        operation.execute(argsDefine, executionContext);
        operation = configuration.getConfig().get("PUSH");
        String[] argsPush = {"PUSH", "a"};
        operation.execute(argsPush, executionContext);
        assertEquals(4, executionContext.getStack().pop());
    }

    @Test
    public void testUninitializedPush() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("PUSH");
        String[] args = {"PUSH", "a"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }

    @Test
    public void testIncorrectNumberOfArgumentsPush() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] argsDefine = {"DEFINE", "a", "4"};
        operation.execute(argsDefine, executionContext);
        operation = configuration.getConfig().get("PUSH");
        String[] args = {"PUSH"};
        Operation finalOperation = operation;
        assertThrows(CalculatorException.class, () -> finalOperation.execute(args, executionContext));
    }
}
