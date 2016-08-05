package io.file;

import java.io.File;

/**
 * <p>
 * <p>
 * Created by liuchenwei on 2016/8/5.
 */
public class FileUtil {

    public static void main(String[] args) {
        File file = new File("D:/solr_4.10.4");
        System.out.println(totalFilesOfDir(file));
        System.out.println(sizeOfDir(file));
    }

    public static long sizeOfDir(File dir) {
        long size = 0;
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += sizeOfDir(file);
                }
            }
        }
        return size;
    }

    public static long totalFilesOfDir(File dir) {
        long total = 0;
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    total++;
                } else {
                    total += totalFilesOfDir(file);
                }
            }
        }
        return total;
    }
}
