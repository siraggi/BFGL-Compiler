/**
 * Created by krist on 10-05-2016.
 */
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import grammar.ini.lexer.LexerException;
import grammar.ini.parser.ParserException;
import org.apache.tools.ant.taskdefs.Tar;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert.*;
import org.junit.internal.runners.statements.Fail;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import static org.junit.Assert.*;

public class TestCompilationEquivalence {
    protected File targetFolder = new File("Library/TestingTarget");
    protected File[] targetFilesList = targetFolder.listFiles();
    protected File compOutFolder = new File("Output");
    protected File[] compOutFilesList = compOutFolder.listFiles();
    private static boolean setUpIsDone = false;


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
    public void testFolders(){
        assertTrue("Folder not found! targetFolder", (targetFolder.length()) > 0);
        assertTrue("Folder not found! compOutFolder", (compOutFolder.length()) > 0);
    }

    @Test
    public void testFileLists(){
        assertNotNull("Folder empty! targetFolder", targetFilesList);
        assertNotNull("Folder empty! compOutFolder", compOutFilesList);
    }


    @Test
    public void testFileNumbers(){
        assertEquals("The number of files are not equal!", targetFilesList.length, compOutFilesList.length);
    }


    @Test
    public void testMD5(){
        MessageDigest md5;
        for (int i = 0; i < targetFilesList.length; i++) {
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return;
            }
            String targetFile = readFile(targetFilesList[i]);
            String compiledFile = readFile(compOutFilesList[i]);
            String hexCompiledFile;
            String hexTargetFile;
            if (targetFile != null && compiledFile != null){
                hexTargetFile = (new HexBinaryAdapter()).marshal(md5.digest(targetFile.getBytes()));
                hexCompiledFile =  (new HexBinaryAdapter()).marshal(md5.digest(compiledFile.getBytes()));

                if (hexTargetFile != null && hexCompiledFile != null){
                    assertTrue("Files are different! MD5 mismatch!" + i, hexTargetFile.equals(hexCompiledFile));
                }
                else{
                    assertNull(hexTargetFile);
                    assertNull(hexCompiledFile);
                }
            }
            else{
                assertNull(targetFile);
                assertNull(compiledFile);
            }

        }
    }

    private String readFile(File file){
        String result = null;
        StringBuilder sb  = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(file);
            BufferedReader input = new BufferedReader(new InputStreamReader(fin));

            String line;
            while ((line = input.readLine()) != null){
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (sb.toString()!= null)
        {
            return result;
        }
        return "ERROR";
    }



}
