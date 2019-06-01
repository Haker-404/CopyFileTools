
import java.io.*;

/**
 * @Author: LiJingWen
 * @Date: 2019/6/1 13:44
 * @Version 1.0
 *
 * 动手写一个小程序，目前打算实现功能如下：
 *      -->用户选择本地文件
 *      -->输入指定路径
 *      -->将该文件复制到指定路径
 **/
public class CopyFile {
    /**
     * 获取选取的文件并进行复制到指定地点操作。
     * @param copyfile
     * @param saveFile
     */
    public void copyFile(File copyfile,File saveFile){
        /**
         * 创建好输入输出流，用的是字节缓冲流。
         */
        InputStream is = null;
        OutputStream os =null;
        try {
            is = new FileInputStream(copyfile);
            os = new FileOutputStream(saveFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        /**
         * 复制操作
         */
        try {
            byte[] bytes = new byte[1024];
            int len ;
            while((len = bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            System.out.println("复制完成");
        }catch (IOException e){
            e.printStackTrace();
        /**
         * 关闭流操作
         */
        }finally {
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args){
        FindFilePath ffp =new FindFilePath();
        CopyFile cf = new CopyFile();
        cf.copyFile(ffp.findFilePath(),ffp.findSaveFilePath());
    }

}
