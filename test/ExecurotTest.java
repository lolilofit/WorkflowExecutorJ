import com.main.Executor;
import com.main.operations.ReadFile;
import org.junit.Assert;
import org.junit.Test;

public class ExecurotTest {
    @Test
    public void exec() {
        try {
            Executor executor = new Executor("src/com/main/workflow_in.txt", "com.main.operations.");
            executor.executor();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ReadFile _read = new ReadFile();
        Assert.assertTrue("bbb hello world!\r\nlast hello\r\nsecond hello\r".equals(_read.block_work("out_file.txt")));
    }
}
