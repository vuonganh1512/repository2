package plagdetect;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class PlagiarismDetector implements IPlagiarismDetector {
	
	public PlagiarismDetector(int n) {
		// TODO implement this method
	}
	
	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<String> getFilenames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getNgramsInFile(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumNgramsInFile(String filename) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Map<String, Integer>> getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readFile(File file) throws IOException {
		// TODO Auto-generated method stub
		// most of your work can happen in this method
		Scanner reader = new Scanner(file); //scanner to read in file

        String[] data = new String[3]; 

        int iteration = 0; 

        while (reader.hasNextLine()) { 
            iteration++;
            if (iteration < 1) {
                reader.nextLine();
                continue;
            }
            else {
                String list[] = reader.nextLine().trim().split(",");{
                    for (int j = 0; j < 3; j++) {
                        data[j] = list[j];
                        System.out.println(data[j]);
                    }
                }
            }
        }
		
    }

	@Override
	public int getNumNGramsInCommon(String file1, String file2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<String> getSuspiciousPairs(int minNgrams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readFilesInDirectory(File dir) throws IOException {
		// delegation!
		// just go through each file in the directory, and delegate
		// to the method for reading a file
		for (File f : dir.listFiles()) {
			readFile(f);
		}
	}
}
