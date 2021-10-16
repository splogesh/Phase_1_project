import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
public class ListFile 
{
	public static void printSubDirFile(File[] rootDirArr, int tab)
	{
		for (File f : rootDirArr) 
        {
			for (int i = 0; i < tab; i++)
				System.out.print("\t");

			if (f.isFile())
				System.out.println(f.getName());

			else if (f.isDirectory()) 
            {
				System.out.println(f.getName());
				printSubDirFile(f.listFiles(), tab + 1);
			}
		}
	}
    public static void checkRootDir(String rootPath)
    {
        File rootDir = new File(rootPath);
		if (rootDir.exists() && rootDir.isDirectory()) 
        {
			File[] rootDirArr = rootDir.listFiles();
			System.out.println( "Files from main directory : " + rootDir);
			printSubDirFile(rootDirArr, 0);
		}
    }
}