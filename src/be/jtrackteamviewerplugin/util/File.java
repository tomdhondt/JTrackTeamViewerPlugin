package be.jtrackteamviewerplugin.util;

import java.io.*;
import java.util.ArrayList;

/**
 * File is a abstract class that allows me to manipulate a File.
 * @author Tom D'hondt
 */

public class File {
	private static String fileSeparator = System.getProperty("file.separator");
	// create a Logger to write the loganalyser info to the log file;
	/**
	 * Method that will allow me to check weather a certain file exists.
	 * @param fileName as a String
	 * @param filePath as s String
	 * @return boolean 
	 * <li>True the file exists</li> 
	 * <li>False the file doesn't exists yet</li>
	 * 
	 */
	public static boolean fileExists(String fileName, String filePath) {
		// create the full name of the file
		String fullFilePathName;
		if(fileName != ""){
			fullFilePathName = filePath + fileSeparator + fileName;	
		} else{
			fullFilePathName = filePath;
		}
		// create a new file
		java.io.File fileExist = new java.io.File(fullFilePathName);
		// return the result of the exists command
		return fileExist.exists();
	}

	/**
	 * Method that will allow me to delete a certain file in one time
	 * 
	 * @param fileName as a String
	 * @param filePath as s String
	 * @return boolean 
	 * <li>True the file will be deleted</li> 
	 * <li>False the file will not have been deleted</li>
	 * 
	 */
	public static boolean fileDelete(String fileName, String filePath) {
		// create the full name of the file
		String fullFilePathName = filePath + fileSeparator + fileName;
		// create a new file
		java.io.File fileDelete = new java.io.File(fullFilePathName);
		// return the result of the delete command
		return fileDelete.delete();
	}

	/**
	 * method that allows me to create a new file at a certain location with a certain name and also give
	 * along the permission to the file
	 * 
	 * @param fileName as a String
	 * @param filePath as a String
	 * @param writable as a boolean
	 * @param readable as a boolean
	 * @return boolean that represents the success 
	 * <li>True if the file is successfully created</li> <li>False will represent failure because the file already exists or there is a security problem</li>
	 * @throws IOException
	 * <li>IOException when IO failure</li>
	 * @throws SecurityException
	 * <li>SecurityException when there is a right problem at the given path</li>
	 */
	public static java.io.File createFile(String fileName, String filePath, boolean writable, boolean readable) {
		// create a new file
		String fileFullName = filePath + System.getProperty("file.separator")+ fileName;
		java.io.File newFile = new java.io.File(fileFullName);
		// set the security at the file
		newFile.setReadable(readable);
		newFile.setWritable(writable);
		try {
			// try to create a new file with a certain fileName and filePath
			if(File.fileExists(fileName, filePath) == false){
				if(!newFile.createNewFile()){
					newFile = null;
				}
			}
		} catch (IOException e) {
			
		}
		return newFile;
	}

	/**
	 * The method will return the number of rows in a certain file.
	 * 
	 * @throws IOException If there is a problem with reading the file
	 * @throws FileNotFoundExceptionif the file doesn't exist that we try to detect the amount of lines
	 * @param file as a java.io.File
	 * @return int as a number of lines in the file
	 */
	public static int fileRowCount(java.io.File file) throws FileNotFoundException, IOException {
		// create the int that will send along the amount of lines in the file.
		int count = 0;
		// create a fileReader to create a input for the give file
		// when the file doesn't exist in the right filePath this will throw a FileNotFoundException
		FileReader in = new FileReader(file);
		// create a lineNumberReader to count all the lines in the file
		LineNumberReader countLine = new LineNumberReader(in);
		// iterate over the different lines in the file
		while (countLine.readLine() != null) {
			count++;
		}
		// close the lineNumberReader
		countLine.close();
		// close the fileReader
		in.close();
		// Return the number of line read in the file.
		return count;
	}

	/**
	 * listFileInFolder will return a ArrayList<String> with the files that will be found in a certain directory.
	 * if the directory doesn't exist it will return a ArrayList that is empty.
	 * @param filePath as as String
	 * @param fileFilter as as fileFilter
	 * @return ArrayList<String> with the different files found in the directory
	 */
	public static ArrayList<String> listFileInFolder(String filePath, FileFilter fileFilter) {
		java.io.File folder = new java.io.File(filePath);											// create a new java.io.File to get the different files
		ArrayList<String> listOfFilesInDir = new ArrayList<String>();								// create a Arraylist<String> to return the different files out the filePath
		if (folder.exists() == true) {																// get the list of files and directory's that are in a certain folder
			java.io.File[] listOfFiles;																// check weather the filter that is give allong isn't null
			if(fileFilter != null){																	// give allong the filter to filter the files with
				listOfFiles = folder.listFiles(fileFilter);
			} else {
				listOfFiles = folder.listFiles();													// when the filter is null don't use is.
			}
			if(listOfFiles != null){																// check if the list isn't null
				for (int i = 0; i < listOfFiles.length; i++) {										// iterate over the different files in the filePath
					java.io.File fileDir = new java.io.File(filePath + fileSeparator + listOfFiles[i].getName());
					if(!fileDir.isDirectory()){
						listOfFilesInDir.add(listOfFiles[i].getName());									// check weather the item in the array ListOfFiles is a file or a directory
					}
				}
			}
		}
		return listOfFilesInDir;																	// return the result
	}
	/**
	 * Method create folder will create a new folder in the path you asked.
	 * @param filePath as path for the new folder
	 * @return boolean on succes
	 * 
	 */
	public static boolean createFolder(String filePath){
		boolean success = false;
		java.io.File folder = new java.io.File(filePath);											// create a new java.io.File to get the different file
		if(folder.exists() == false){
			success = folder.mkdir();
		}
		return success;
	}
}
