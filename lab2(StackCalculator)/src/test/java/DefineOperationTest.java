import com.company.CalculatorException;
import com.company.Configuration;
import com.company.ExecutionContext;
import com.company.Operation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DefineOperationTest {

    @Test
    public void testSimpleDefine() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] args = {"DEFINE" , "a" , "4"};
        operation.execute(args, executionContext);
        Double a = executionContext.getVariables().get("a");
        assertEquals(4, a);
    }

    @Test
    public void testNotEnoughElementDefine() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CalculatorException {
        Configuration configuration = new Configuration("config.properties");
        ExecutionContext executionContext = new ExecutionContext();
        Operation operation = configuration.getConfig().get("DEFINE");
        String[] args = {"DEFINE" , "a"};
        assertThrows(CalculatorException.class, () -> operation.execute(args, executionContext));
    }
}
