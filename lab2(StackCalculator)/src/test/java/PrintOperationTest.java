import com.company.Exceptions.CalculatorException;
import com.company.Configuration;
import com.company.ExecutionContext;
import com.company.Operation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertThrows;

public class PrintOperationTest {
    @Test
    public void testEmptyPrint() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("PRINT");
        String[] args = {"PRINT"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }

    @Test
    public void testIncorrectNumberOfArgumentsPrint() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] argsDefine = {"DEFINE", "a", "4"};
        operation.execute(argsDefine, executionContext);
        operation = configuration.getConfig().get("PUSH");
        String[] argsPush = {"PUSH", "a"};
        operation.execute(argsPush, executionContext);
        operation = configuration.getConfig().get("PRINT");
        String[] argsPrint = {"PRINT", "a"};
        Operation finalOperation = operation;
        assertThrows(CalculatorException.class, () -> finalOperation.execute(argsPrint, executionContext));
    }
}
