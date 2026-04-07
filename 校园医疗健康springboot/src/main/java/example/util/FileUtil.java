package example.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static String fileUpload(HttpServletRequest request, HttpServletResponse response, Part part){
        // 获取存储上传文件的路径
        String realPath = request.getServletContext().getRealPath("/static/upload/");
        File directoryFile = new File(realPath);
        if (!directoryFile.exists()){
            directoryFile.mkdirs();
        }
        //创建新的一个文件用于保存上传文件
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = simpleDateFormat.format(new Date());
        String test = part.getSubmittedFileName();
        String fileName = format + "." + part.getSubmittedFileName().split("\\.")[1];
        File saveFile = new File(realPath + File.separator + fileName);
        try {
            saveFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 存储文件
        try(
                InputStream inputStream = part.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(saveFile)
        ){
            byte[] bytes = new byte[1024];
            int size = 0;
            while ((size = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileName;
    }
}
