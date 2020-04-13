import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Unit1 {

    public static void main(String[] args) {

        FileFilter filter  =new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir= new File("D:\\Spring-workspace\\brewery-monolith\\src\\main\\java\\guru\\sfg\\brewery\\domain");
        File[] files = dir.listFiles(filter);
        System.out.println("YES");

        FileFilter filterlamda = (File pathname) -> pathname.getName().endsWith(".java");
        File[] filesUsingLamda = dir.listFiles(filterlamda);



        Arrays.stream(filesUsingLamda).forEach(System.out::println);

    }
}
