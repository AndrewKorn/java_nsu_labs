import com.company.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class AddOperationTest {

    @Test
    public void testSimpleAdd() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(5.0);
        executionContext.getStack().push(10.0);
        Operation operation = configuration.getConfig().get("+");
        String[] args = {"+"};
        operation.execute(args, executionContext);
        assertEquals(15, executionContext.getStack().pop());
    }

    @Test
    public void testEmptyAdd() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("+");
        String[] args = {"+"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }

    @Test
    public void testNotEnoughArgumentsAdd() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("+");
        String[] args = {"+", "5" , "15"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }

}
