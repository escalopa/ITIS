import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FindData {

    private static List<File> data= new LinkedList<>();

    public static List<File> findFiles(String location, String phrase){
        File data=new File(location);
        return findFiles_process(data,phrase);

    }

    private static  List<File> findFiles_process(File path, String phrase){

        if (path.isDirectory()) {
            File[] files = path.listFiles();
            for (File current : files) {
                if (!current.isDirectory() && current.getName().contains(phrase)){
                    data.add((current));
                }
                findFiles_process(current, phrase);
            }
        }
        return data;
    }
}

