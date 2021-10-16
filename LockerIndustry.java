import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LockerIndustry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Virtual Key for Your Repositories");
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		String rootDirPath = "C:\\Users\\ADMIN\\simplilearn project";
		boolean result = true;
		do
		{
			displayMenu();
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice)
			{
			case 1:
				viewFile(rootDirPath);
				break;
			case 2:
				boolean res = true;
				displaySubMenu();
				int subChoice = Integer.parseInt(sc.nextLine());
				switch(subChoice)
				{
					case 1:
						System.out.println("Enter file name to create");
						String fileName = sc.nextLine();
						createFile(rootDirPath,fileName);
					break;
					case 2:
						System.out.println("Enter file name to Delete");
						String fileDeleteName = sc.nextLine();
						deleteFile(rootDirPath,fileDeleteName);
					break;
					case 3:
						System.out.println("Enter file name to Search");
						String fileSearchName = sc.nextLine();
						searchFile(rootDirPath,fileSearchName);
					break;
					default:
						System.out.println("incorrect choice...");
					break;
				}
			break;
			case 3:
				System.out.println("I'm Done");
				System.exit(0);
			break;
			default:
				System.out.println("incorrect choice...");
			break;
			}
			System.out.println("Do you want to process (y/n):");
			String proceed = sc.nextLine();
			if(proceed.equals("y"))
				result = true;
			else
				result = false;
		}while(result);
	}
	private static void searchFile(String rootDirPath, String fileName) 
	{
		File rootDir = new File(rootDirPath+"\\");
	 	boolean fileNotFound = true;
		if (rootDir.exists() && rootDir.isDirectory()) 
        {
			File rootDirArr[] = rootDir.listFiles();
			for(int i=0;i<rootDirArr.length;i++)
			{
				if(rootDirArr[i].getName().equals(fileName+".txt"))
				{
					fileNotFound = false;
					System.out.println(fileName+" is avail in path "+rootDirPath);
					i = rootDirArr.length;
				}
			}
		}
		if(fileNotFound)
			System.out.println("File Not Found");
	}
	private static void deleteFile(String rootDirPath, String fileName) 
	{
		 	File rootDir = new File(rootDirPath+"\\");
		 	boolean fileNotFound = true;
			if (rootDir.exists() && rootDir.isDirectory()) 
	        {
				File rootDirArr[] = rootDir.listFiles();
				for(int i=0;i<rootDirArr.length;i++)
				{
					if(rootDirArr[i].getName().equalsIgnoreCase(fileName+".txt"))
					{
						rootDirArr[i].delete();
						fileNotFound = false;
						System.out.println(fileName+" file is deleted");
					}
				}
			}
			if(fileNotFound)
				System.out.println("File Not Found");
	}
	private static void createFile(String rootDirPath, String fileName) 
	{
		File file = new File(rootDirPath+"\\"+fileName+".txt");
		try	{
			file.createNewFile();
			System.out.println(fileName+" file is created.");
		} 
		catch (IOException e){
			e.printStackTrace();
		}
	}
	private static void viewFile(String path) 
	{
		ListFile obj = new ListFile();
		obj.checkRootDir(path);
	}
	public static void displayMenu()
	{
		System.out.println("1. View all files");
		System.out.println("2. Manipulate your directory(Add, Delete, Search file)");
		System.out.println("3. Close my App");
		System.out.println("Enter your choice");
	}
	public static void displaySubMenu()
	{
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file");
		System.out.println("3. Search files");
		System.out.println("Enter your choice");
	}
}