import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipStreamTest {
    public static void main(String[] args) throws IOException {
//        File file1 = new File("C:\\Users\\20590\\OneDrive\\Desktop\\file.zip");
//        File file2 = new File("C:\\Users\\20590\\OneDrive\\Desktop");
//        unzip(file1, file2);
        File file3 = new File("C:\\Users\\20590\\OneDrive\\Desktop\\file");
        System.out.println(file3.getPath());
        File file4 = new File(file3.getPath() + ".zip");
        //创建压缩流
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file4));
//        System.out.println(file4.getName());
        tozip(file3, zos, file3.getName());
        zos.close();
    }

    /*
     * 作用:压缩
     * 参数一:要压缩的文件
     * 参数二:压缩到的地址
     * */
    private static void tozip(File src, ZipOutputStream zos, String name) throws IOException {
        //对每个文件进行判断
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    tozip(file, zos, name + "\\" + file.getName());
                } else {
                    //创建ZipEntry对象,写入压缩包
                    ZipEntry entry = new ZipEntry(name + "\\" + file.getName());
                    zos.putNextEntry(entry);
                    //将文件数据传入压缩包中的文件
                    FileInputStream fis = new FileInputStream(file);
                    int len;
                    byte[] buf = new byte[1024];
                    while ((len = fis.read(buf)) != -1) {
                        zos.write(buf, 0, len);
                    }
                    fis.close();
                }
            }
            zos.closeEntry();
        }
    }

    /*
     * 作用:解压缩
     * 参数一:要解压缩的文件
     * 参数二:解压缩到的地址
     * */
    private static void unzip(File file1, File file2) throws IOException {
        //创建压缩包流
        file2.mkdirs();
        ZipInputStream zis = new ZipInputStream(new FileInputStream(file1));
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            if (ze.isDirectory()) {
                File file = new File(file2, ze.getName());
                file.mkdirs();
            } else {
                FileOutputStream fos = new FileOutputStream(new File(file2, ze.getName()));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
