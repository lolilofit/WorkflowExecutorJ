import com.main.Factory;
import org.junit.Assert;
import org.junit.Test;
import com.main.operations.ReadFile;

public class ReadFileTest {

    @Test
    public void read_file() {

        try {
            Factory.getInstance().create_op("com.main.operations", "readfile");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ReadFile _read = new ReadFile();

        Assert.assertTrue(("bbb hello world!\r\nsecond line\r\nlast line\r\n").equals(_read.block_work("in_file.txt")));

    }
}
