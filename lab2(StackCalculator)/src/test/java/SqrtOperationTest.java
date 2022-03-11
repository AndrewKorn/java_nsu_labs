import com.company.Exceptions.CalculatorException;
import com.company.Configuration;
import com.company.ExecutionContext;
import com.company.Operation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class SqrtOperationTest {
    @Test
    public void testSimpleSqrt() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(9.0);
        Operation operation = configuration.getConfig().get("SQRT");
        String[] args = {"SQRT"};
        operation.execute(args, executionContext);
        assertEquals(3, executionContext.getStack().pop());
    }

    @Test
    public void testEmptySqrt() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("SQRT");
        String[] args = {"SQRT"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }

    @Test
    public void testNotEnoughArgumentsSqrt() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("SQRT");
        String[] args = {"SQRT", "9"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }
}
