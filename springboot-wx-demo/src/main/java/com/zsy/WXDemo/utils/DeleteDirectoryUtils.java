package com.zsy.WXDemo.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 删除目录或文件工具类
 * @author zj
 *
 */
public enum DeleteDirectoryUtils {
    INSTANCE;
    private Logger logger = LoggerFactory.getLogger(DeleteDirectoryUtils.class);
    /**
     * 删除空目录或文件
     * @param dir 将要删除的目录路径
     */
    public void deleteFile(String dir) {
        boolean success = (new File(dir)).delete();
        if (success) {
            logger.info("成功删除目录或文件: " + dir);
        } else {
            logger.info("删除目录或文件失败: " + dir);
        }
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return
     */
    public boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
