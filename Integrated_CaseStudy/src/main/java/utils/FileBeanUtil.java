package utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileBeanUtil {
    private static DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
    private static ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

    private FileBeanUtil() {
    }

    public static <T> T fillBean(HttpServletRequest req, Class<T> tClass, String relativePath, String fileNameWithPath) throws Exception {
        T t = null;
        boolean multipartContent = ServletFileUpload.isMultipartContent(req);
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);
        if (multipartContent) {
            t = BeanUtil.fillBean(fileItems, tClass);
            String realPath = req.getServletContext().getRealPath(relativePath);
            FileUtil.makeDirs(fileNameWithPath, realPath);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    fileItem.write(new File(realPath, fileNameWithPath));
                }
            }
        } else {
            t = BeanUtil.fillBean(req, tClass);
        }
        return t;
    }
}
