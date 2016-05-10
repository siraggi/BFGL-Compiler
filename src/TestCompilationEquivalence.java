/**
 * Created by krist on 10-05-2016.
 */
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import grammar.ini.lexer.LexerException;
import grammar.ini.parser.ParserException;
import org.apache.tools.ant.taskdefs.Tar;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert.*;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestCompilationEquivalence {
    protected File targetFolder;
    protected File[] targetFilesList;
    protected File compOutFolder;
    protected File[] compOutFilesList;


    @Before
    public void setUp(){
        try {
            Main.compile(new File("Test", "BFGLtest.bfgl"));
            targetFolder = new File("Library/TestingTarget");
            compOutFolder = new File("Output");
            targetFilesList = targetFolder.listFiles();
            compOutFilesList = compOutFolder.listFiles();

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
        assertNotNull("Folder not found! targetFolder",targetFolder);
        assertNotNull("Folder not found! compOutFolder", compOutFolder);
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
            String hexTargetFile = (new HexBinaryAdapter()).marshal(md5.digest(readFile(targetFilesList[i]).getBytes()));
            String hexCompiledFile =  (new HexBinaryAdapter()).marshal(md5.digest(readFile(compOutFilesList[i]).getBytes()));
            assertEquals("Files are different! MD5 mismatch!", hexTargetFile, hexCompiledFile);
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
