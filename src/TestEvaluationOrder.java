import grammar.ini.lexer.LexerException;
import grammar.ini.parser.ParserException;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by krist on 10-05-2016.
 */
public class TestEvaluationOrder {

    private static boolean setUpIsDone = false;

    @SuppressWarnings("Duplicates")
    @Before
    public void setUp(){
        try {
            if (!setUpIsDone){
                Main.compile(new File("Test", "BFGLtest.bfgl"));
                setUpIsDone = true;
            }
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (LexerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void TestEvalOrder(){
        File outputScene = new File("Output/Scene.java");
        try(BufferedReader br = new BufferedReader(new FileReader(outputScene))) {
            String[] targetLines = {"float _x = 5f;", "_x = _x + 5f;", "float _y = _player._g;", "_y = _x * 2f;"};
            String line = null;

            while (!(br.readLine().contains("float _x"))){
            }
            for (int i = 0; i < 4; i++){
                assertTrue(line.equals(targetLines[i]));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
