package com.lzx.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Test2 {
    public static void main(String[] args) {

    }

    // 解压缩文件夹
    public static void method1(File file, File dest) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(file));

        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                File dir = new File(dest, entry.getName());
                dir.mkdirs();
            } else {
                File file1 = new File(dest, entry.getName());
                FileOutputStream fos = new FileOutputStream(file1);
                int len;
                byte[] bytes = new byte[1024];
                while ((len = zis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
