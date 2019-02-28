import com.main.Factory;
import com.main.operations.Grep;
import org.junit.Assert;
import org.junit.Test;

public class GrepTest {
     @Test
    public void _grep() {

        try {
            Factory.getInstance().create_op("com.main.operations", "grep");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Grep grep = new Grep();
        Assert.assertTrue("hello world".equals(grep.block_work("hello", "hello world")));
        Assert.assertTrue("hello world".equals(grep.block_work("hel", "hello world")));
        Assert.assertTrue("hello world\n hello world\n hello world".equals(grep.block_work("hello", "hello world\n hello world\n hello world")));
        Assert.assertTrue("hello world\n hello world\n hello world".equals(grep.block_work("he", "hello world\n hello world\n hello world")));
        Assert.assertTrue("Hello world\n".equals(grep.block_work("Hello", "Hello world\n hello world")));
        Assert.assertTrue("".equals(grep.block_work("hello", "Hello world\n hel\n last line")));

     }
}