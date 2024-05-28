package utilities.files;

import java.io.File;

public class DeleteFile {

    public static void deleteFile(String dirPath, String fileName){
        File dir = new File(dirPath);
        File[] dirContents = dir.listFiles();
        for (File file : dirContents){
            if (file.getName().equals(fileName)){
                System.out.println(file.getName());
                if (file.delete()){
                    System.out.println("file " + file.getName() + " deleted successfully");
                }else {
                    System.out.println("file " + file.getName() + " not deleted");
                }
            }
        }

    }
}
