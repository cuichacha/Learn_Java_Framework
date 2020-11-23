package utils;

import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.util.UUID;

/**
 * @Author Vsunks.v
 * @Date 2020/10/19 21:51
 * @Blog blog.sunxiaowei.net
 * @Description:
 */
public class FileUtil {

    /*
        upload
            36字符串  ----  4aeb1da8-64af-42a5-8bd7-aeee7e3ac63a
            4
             a
              e
                4aeb1da8-64af-42a5-8bd7-aeee7e3ac63a



     */

    /**
     *  生成包含三级目录的唯一文件名
     * @return
     */
    public static String getFileNameWithPath() {
        // 生成一个唯一的文件名
        String fineName = UUID.randomUUID().toString();
        fineName = fineName.replaceAll("-", "");

        // 获取前三个字符作为目录名
        char c1 = fineName.charAt(0);
        char c2 = fineName.charAt(1);
        char c3 = fineName.charAt(2);

        StringBuilder filePath = new StringBuilder().append(c1).append("/").append(c2).append("/").append(c3).append("/");
//        System.out.println("filePath = " + filePath);

        return filePath + fineName;
    }

    /**
     * 判断三级目录是否存在
     * @param fileNameWithPath
     * @param uploadRealPath
     */
    public static void makeDirs(String fileNameWithPath, String uploadRealPath) {
        //截取目录，判断是否存在，不存在就创建
        String filePath = fileNameWithPath.substring(0, fileNameWithPath.lastIndexOf("/"));

        // 如果不存在，就创建
        if (!new File(uploadRealPath,filePath).exists()) {
            new File(uploadRealPath,filePath).mkdirs();
        }
    }

}
