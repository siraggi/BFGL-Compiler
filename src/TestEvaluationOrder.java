import grammar.ini.lexer.LexerException;
import grammar.ini.parser.ParserException;
import org.junit.*;
import org.junit.Test;

import java.io.*;
import java.nio.Buffer;

/**
 * Created by krist on 10-05-2016.
 */
public class TestEvaluationOrder {

    private static boolean setUpIsDone = false;

    //unfinished, not in use

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
            String line;
            while (!(br.readLine().contains("float _x"))){

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
