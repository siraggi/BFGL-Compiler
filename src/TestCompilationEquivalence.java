/**
 * Created by krist on 10-05-2016.
 */
import grammar.ini.lexer.LexerException;
import grammar.ini.parser.ParserException;
import org.junit.Test;
import org.junit.Ignore;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestCompilationEquivalence {

    public void setUp(){
        try {
            Main.compile(new File("Test", "BFGLtest.bfgl"));
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (LexerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testCompilationEquivalence(){

    }



}
