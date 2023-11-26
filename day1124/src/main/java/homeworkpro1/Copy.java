package homeworkpro1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liu
 * @date 2023/11/24 22:45
 */
public class Copy {
        public  void Copy(String sourcePath, String destinationPath) {
            try (FileInputStream fis = new FileInputStream(sourcePath);
                 FileOutputStream fos = new FileOutputStream(destinationPath)) {
                byte[] bytes = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, bytesRead);
                }
                System.out.println("文件从 " + sourcePath + " 成功拷贝到 " + destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            String sourceFilePath = "\"E:\\zhen xuexiwejia\\666\\pr2.txt\"";
            String destinationFilePath = "\"E:\\zhen xuexiwejia\\666\\pro5.txt\"";
            Copy copy =new Copy();
            copy.Copy(sourceFilePath, destinationFilePath);
        }
}


