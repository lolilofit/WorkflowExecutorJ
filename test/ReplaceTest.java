import com.main.Factory;
import com.main.operations.Replace;
import org.junit.Assert;
import org.junit.Test;

public class ReplaceTest {
    @Test
    public void _replace() {
        Factory factory = new Factory();
        try {
            factory.create_op("com.main.operations", "replace");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Replace replace = new Replace();
        Assert.assertTrue("Hello user".equals(replace.block_work("world user", "Hello world")));
        Assert.assertTrue("Hello user\n Hello user\n Hello user".equals(replace.block_work("world user", "Hello world\n Hello world\n Hello world")));
        Assert.assertTrue("Hello user!".equals(replace.block_work("world user", "Hello world!")));
        Assert.assertTrue("Hello world\n Hello world".equals(replace.block_work("nothing user", "Hello world\n Hello world")));

    }
}
