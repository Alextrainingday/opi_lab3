import beans.Result;
import database.ResultInterface;
import org.junit.Before;
import org.junit.Test;
import util.ResultInterfaceImplementation;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PersistenceTest {
    static ResultInterface ResultInterface;

    @Before
    public void initDAO() {
        ResultInterface = new ResultInterfaceImplementation();
    }

    @Test
    public void databaseCheck() {
        Random random = ThreadLocalRandom.current();
        Result result = new Result();
        result.setX(BigDecimal.valueOf(random.nextDouble()));
        result.setY(BigDecimal.valueOf(random.nextDouble()));
        result.setR(BigDecimal.valueOf(random.nextDouble()));
        result.setHit(random.nextBoolean());

        // save result to database
        ResultInterface.save(result);

        // get results from database
        List<Result> results = ResultInterface.getAll();

        assertTrue(results.contains(result));
    }
}