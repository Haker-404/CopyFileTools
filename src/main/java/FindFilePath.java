import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * @Author: LiJingWen
 * @Date: 2019/6/1 15:26
 * @Version 1.0
 **/
public class FindFilePath {
    JFileChooser jfc = new JFileChooser();
    {
        //设置当前路径为桌面路径,否则将我的文档作为默认路径
        FileSystemView fsv = FileSystemView .getFileSystemView();
        jfc.setCurrentDirectory(fsv.getHomeDirectory());
        //JFileChooser.FILES_AND_DIRECTORIES 选择路径和文件
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        /**
         * 下面的几个选项本次暂时不选，等待以后将功能做的更复杂一点时使用。
         * jfc.showSaveDialog(null);
         *   .setMultiSelectionEnabled(true);//是否允许多选
         *   .addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));//文件过滤器
         *   .setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
         */
    }
    public File findFilePath(){
        jfc.showDialog(new JLabel(), "确定");
        File file = jfc.getSelectedFile();
        System.out.println("获取文件路径为："+file.getAbsolutePath());
        return file;
    }
    public File findSaveFilePath(){
        jfc.showSaveDialog(null);
        File file = jfc.getSelectedFile();
        System.out.println("存储文件路径为："+file.getAbsolutePath());
        return file;
    }
}
