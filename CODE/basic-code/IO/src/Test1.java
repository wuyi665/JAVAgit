import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //拷贝一个文件夹考虑子文件夹
        File file = new File("C:\\Users\\20590\\OneDrive\\Desktop\\file");
        File filecopy = new File("C:\\Users\\20590\\OneDrive\\Desktop\\filecopy");
        copydir(file, filecopy);
    }

    private static void copydir(File file, File filecopy) throws IOException {
        filecopy.mkdirs();
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    copydir(f, new File(filecopy, f.getName()));
                } else {
                    FileInputStream fi = new FileInputStream(f);
                    FileOutputStream fo = new FileOutputStream(new File(filecopy, f.getName()));
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = fi.read(buf)) != -1) {
                        fo.write(buf, 0, len);
                    }
                    fo.close();
                    fi.close();
                }
            }
        }
    }
}
