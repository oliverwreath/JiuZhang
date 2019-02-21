package com.Tools.FileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.google.common.base.Preconditions;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/20/2016.
 */
public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static void main(String[] arg) {
        testFileUtils();
    }

    private static void testFileUtils() {
        logger.info("{}", fileUtils());
    }

    static int fileUtils() {
        return 0;
    }

    static List<File> getFileList(String pathname) {
        Preconditions.checkArgument(pathname != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

        List<File> fileList = new LinkedList<File>();
        File rootFile = new File(pathname);
        Queue<File> queue = new LinkedList<File>();
        queue.add(rootFile);
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            if (currentFile.exists()) {
                if (currentFile.isDirectory()) {
                    File[] files = currentFile.listFiles();
                    if (files != null) {
                        queue.addAll(Arrays.asList(files));
                    }
                } else {
                    fileList.add(currentFile);
                }
            }
        }

        return fileList;
    }

    static int deleteFilesSet(Set<File> fileSet) {
        for (File file : fileSet) {
            if (!file.delete()) {
                logger.info("deletion failed for: file.getName() = {}", file.getName());
            }
        }

        return 0;
    }

    static String fileToMd5(File file) {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        String md5 = "";
        try {
            fis = new FileInputStream(file);
            md5 = DigestUtils.md5Hex(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("fileToMd5() time taken = {} s", (System.currentTimeMillis() - startTime) / 1000.0);
        return md5;
    }

    static String fileToSha1(File file) {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        String sha1 = "";
        try {
            fis = new FileInputStream(file);
            sha1 = DigestUtils.sha1Hex(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("fileToSha1() time taken = {} s", (System.currentTimeMillis() - startTime) / 1000.0);
        return sha1;
    }

    static Comparator<File> shorterNameComparator = new Comparator<File>() {
        public int compare(File o1, File o2) {
            return o1.getName().length() - o2.getName().length();
        }
    };
}
