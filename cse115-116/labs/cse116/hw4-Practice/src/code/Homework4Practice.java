package code;

import java.util.HashMap;

import util.general.CharacterFromFileReader;

public class Homework4Practice {

	public HashMap<String, Integer> count(String inputPath) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		CharacterFromFileReader cffr = new CharacterFromFileReader(inputPath);
		char c;
		String author = "";
		int state = 0;
		while (cffr.hasNext()) {
			c = cffr.next();
			switch (state) {
			case 0:
				if (c == '<') {
					state = 1;
				} 
				else {
					state = 0;
				}
				break;
			case 1:
				if (c == 'A') {
					state = 2;
				} 
				else {
					state = 0;
				}
				break;
			case 2:
				if (c == 'U') {
					state = 3;
				} else {
					state = 0;
				}
				break;
			case 3:
				if (c == '>') {
					state = 4;
				} 
				else {
					state = 0;
				}
				break;
			case 4:
				if (c == '<') {
					state = 5;
				} 
				else {
					author = author + c;
					state = 4;
				}
				break;
			case 5:
				if (c == '/') {
					state = 6;
				} 
				else {
					if (c == '<'){
						author = author + '<';
						state = 5;
					}
					else{
						author = author + '<' + c;
						state = 4;
					}					
				}
				break;
			case 6:
				if (c == 'A') {
					state = 7;
				} 
				else {
					if (c == '<'){
						author = author + "</";
						state = 5;
					}
					else{
						author = author + "</" + c;
						state = 4;
					}					
				}
				break;
			case 7:
				if (c == 'U') {
					state = 8;
				} 
				else {
					if (c == '<'){
						author = author + "</A";
						state = 5;
					}
					else{
						author = author + "</A" + c;
						state = 4;
					}					
				}
				break;
			case 8:
				if (c == '>') {
					if (map.containsKey(author)) {
						int value = map.get(author);
						map.put(author, ++value);
						author = "";
						state = 0;
					} else {
						map.put(author, 1);
						author = "";
						state = 0;
					}
				} 
				else {
					if(c == '<'){
						author = author + "</AU";
						state = 5;
					}
					else{
						author = author + "</AU" + c;
						state = 4;
					}
				}
				break;
			}
		}
		return map;
	}
}
