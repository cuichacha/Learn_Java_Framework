package code1.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    @RequestMapping("/FileUpload")
    public String fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
            char dir1 = fileName.charAt(0);
            char dir2 = fileName.charAt(1);
            char dir3 = fileName.charAt(2);

            String realPath = request.getServletContext().getRealPath("/upload") + "/" + dir1 + "/" + dir2 + "/" + dir3;
            File directory = new File(realPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            file.transferTo(new File(directory, fileName));
        }


        return "Test1";
    }
}
