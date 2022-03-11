import com.company.Exceptions.CalculatorException;
import com.company.Configuration;
import com.company.ExecutionContext;
import com.company.Operation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class PopOperationTest {
    @Test
    public void testSimplePop() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] argsDefine = {"DEFINE", "a", "4"};
        operation.execute(argsDefine, executionContext);
        operation = configuration.getConfig().get("PUSH");
        String[] argsPush = {"PUSH", "a"};
        operation.execute(argsPush, executionContext);
        operation = configuration.getConfig().get("POP");
        String[] argsPop = {"POP", "a"};
        operation.execute(argsPop, executionContext);
        assertEquals(0, executionContext.getStack().size());
    }

    @Test
    public void testEmptyPop() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("PUSH");
        String[] args = {"PUSH", "a"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }

    @Test
    public void testIncorrectNumberOfArgumentsPop() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] argsDefine = {"DEFINE", "a", "4"};
        operation.execute(argsDefine, executionContext);
        operation = configuration.getConfig().get("PUSH");
        String[] argsPush = {"PUSH", "a"};
        operation.execute(argsPush, executionContext);
        operation = configuration.getConfig().get("POP");
        String[] argsPop = {"POP"};
        Operation finalOperation = operation;
        assertThrows(CalculatorException.class, () -> finalOperation.execute(argsPop, executionContext));
    }
}
