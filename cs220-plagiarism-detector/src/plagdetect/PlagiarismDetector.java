package plagdetect;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PlagiarismDetector implements IPlagiarismDetector {
	private Map<String, Set<String>> ngramMap = new HashMap<>();   // A
	private Map<String, Map<String, Integer>> results = new HashMap<>();
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
	public int getNumNGramsInCommon(String file1, String file2, int count) {
		// TODO Auto-generated method stub
		for (String filename1 : ngramMap.keySet()) {
			for (String filename2 : ngramMap.keySet()) {
				if (filename1.equals(filename2)) continue;
				var value1 = ngramMap.get(filename1);
				var value2 = ngramMap.get(filename2);
				for (String ngram : value1) {
					if (value2.contains(ngram)) {
						count++;
					}
				}
				putResults(filename1, filename2, count);
			}
		}
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
	private void putResults(String f1, String f2, int count) {
		if (!results.containsKey(f1)) results.put(f1, new HashMap<String, Integer>());
		if (!results.containsKey(f2)) results.put(f2, new HashMap<>());
		if (!results.get(f1).containsKey(f2)) results.get(f1).put(f2, 0);
		if (!results.get(f2).containsKey(f1)) results.get(f2).put(f1, 0);
		results.get(f1).put(f2, results.get(f1).get(f2) + 1);
		results.get(f2).put(f1, results.get(f2).get(f1) + 1);
	}

}
