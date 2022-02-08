package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import javax.sound.sampled.Line;

public class CodingExamB {
	static /*
			 * This is a logging program for collecting TODO comments in a program. The
			 * program will scan Through all the files in the Coding_Exam_B/classes package,
			 * and collect all the comments that start with //TODO: and write them to their
			 * own file. See the TODO_Log_example.txt file for an idea of what the final
			 * file output will look like.
			 */
	String value = "";

	public static String getLoggingInfo(String fileName) {
		/*
		 * 1. Complete the getLoggingInfoMethod. The method takes in a String for a file
		 * and returns a String. The method will open the file a read through it. It
		 * will then take all the comments that begin with //TODO: and combine them into
		 * one large String. The string will also state the file name and the line
		 * number for where each TODO was found.
		 */

		// My Notes
		/*
		 * trying to get the while loop to run the correct amount of times c2 is so that
		 * it will only quit after a todo comment has been read(every class has at least
		 * 1) issue is that c2 does not work of classes with multiple todo lines.(some
		 * class have 1 todo line, some have 2)
		 */
		value = fileName + " \n ";
		boolean tryLine = true;
		int counter = 0;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			try {
				while(tryLine) {
					String line = br.readLine();
					if (line == null) {
						tryLine = false;
					}else if (line.contains("//TODO") || line.contains("// TODO")) {
						value += (counter + 1) + ": " + line + " \n ";
						System.out.println(value);

					}
					
counter ++;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END");
		System.out.println(value);
		value += " \n ";
		return value;
	}

	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");

		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should
		 * match TODO_Log_example.txt.
		 */

		try {
			FileWriter fw = new FileWriter("C:\\Users\\dylan\\git\\level5-coding-exam-dylanvanwinkle\\TODO_Log.txt");
			String[] input = finalLogString.split("||");
			System.out.println(input.length);
			for (int i = 0; i < input.length; i++) {
				fw.write(input[i]);
			}
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
