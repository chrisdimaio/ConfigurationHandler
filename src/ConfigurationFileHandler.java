
public class ConfigurationFileHandler {
	
	/**
	 * Method ConfigurationFileHandler
	 *
	 *
	 */
	 
	 String theFileString = "CONFIG1=stuff.txt MAX=NULL\nCONFIG2=some thing\n";
	 
	public ConfigurationFileHandler() {
		
		// System.out.println("Configuration File Handler started...\n");
		
		// System.out.println("Printing test file string\n\n");
		
		// System.out.println(theFileString);
		
//		int previousNewLine = 0;
//		while( previousNewLine < theFileString.length()-1){
//			
//			int nextNewLine = theFileString.indexOf('\n', previousNewLine + 1);
//			
//			String configLine = ((previousNewLine==0)?
//				theFileString.substring(previousNewLine, nextNewLine+1)
//				:
//				theFileString.substring(previousNewLine+1, nextNewLine+1));
//			
//			if(readConfigLine(configLine)){
//				// Line was read successfully.
//			}else{
//				// System.out.println("Config line read failed");
//			}
//			
//			//System.out.println(theFileString.length() + " | " + lastNewLine + " : " + nextNewLine);
//			
//			previousNewLine = nextNewLine;
//			
//		}
		
		readConfigLine("CONFIG1=stuff FILE=\"stuff file\".txt MAX=100 MIN=2");
		
	}
	
	private void readConfigLine(String configLine){
			
		// FORMAT
		// CONFIG_TOKEN|EQUALS|DOUBLE QUOTE OR VALUE|SPACE
		
		// System.out.println("Parsing: " + configLine);
		
		if(configLine.length() > 0){
		
			int spaceDelimiterIndex = configLine.indexOf(' ');
			
			// If the space delimiter is zero make the off 
			// set one,
			int offSet = (spaceDelimiterIndex == 0) ? 1 : 0;
			
			int quoteIndex = configLine.indexOf('"');
			
			// Broken
			spaceDelimiterIndex = (spaceDelimiterIndex > quoteIndex) ?
				configLine.indexOf(' ', configLine.indexOf('"', quoteIndex)) :
					spaceDelimiterIndex;
			
			// If the config line starts with a space
			// find the next one.
			spaceDelimiterIndex = (spaceDelimiterIndex == 0) ?
				configLine.indexOf(' ', offSet) : spaceDelimiterIndex;
			
			// If there isn't a space delimiter use the length.
			spaceDelimiterIndex = (spaceDelimiterIndex > -1) ?
				spaceDelimiterIndex : configLine.length();
			
			String config = configLine.substring(0, spaceDelimiterIndex);
			
			System.out.println("");
			
			int equalsDelmiter = configLine.indexOf('=');
			
			String token = config.substring(offSet, equalsDelmiter);
			String value = config.substring(equalsDelmiter+1);
			
			System.out.println("The token is: " + token);
			System.out.println("The value is: " + value);
			
			readConfigLine( configLine.substring(spaceDelimiterIndex));
		}
		
		// return false;
	}
}
