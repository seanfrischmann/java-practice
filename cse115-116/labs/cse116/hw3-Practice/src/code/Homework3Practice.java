package code;

import java.util.HashMap;

import util.general.CharacterFromFileReader;

public class Homework3Practice {
	
	public HashMap<String, Integer> count(String inputPath){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String word = "";
		CharacterFromFileReader cffr = new CharacterFromFileReader(inputPath);
		while (cffr.hasNext()){
			char c = cffr.next();
			if (c == ' '|| c == '\t'|| c == '\n'|| c == ','|| c == '.'){
				addToMap(map, word);
				word = "";
			}
			else{
				word = word + c;
			}
		}
		addToMap(map, word);
		return map;
	}
	public void addToMap(HashMap<String, Integer> map, String word){
		if (word != ""){
			if (map.containsKey(word)){
				int value = map.get(word);
				map.put(word, ++value);
			}
			else{
				map.put(word, 1);
			}
		}
	}

}
