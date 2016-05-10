import org.junit.Before;

/**
 * Created by krist on 10-05-2016.
 */
public class Test {
    private static boolean setUpIsDone = false;

    @Before
    public void setUp(){
        if (!setUpIsDone){

            //insert setup

            setUpIsDone = true;
        }

    }
}
