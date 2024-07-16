import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CommonsioTest {
    public static void main(String[] args) throws IOException {
        //CommonsIO工具包使用
        FileUtils.copyFile(new File("IO\\a.txt"), new File("IO\\d.txt"));
        //Hutool工具包使用
        File io = FileUtil.file("IO", "wjm.txt");
        //touch创建file
        FileUtil.touch(io);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d");
        //写入数据
        FileUtil.writeLines(list, io, "UTF-8", true);

    }
}
