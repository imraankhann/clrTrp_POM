package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class ApacheCLI {
	
	private static String CONFIG_FILE=null;
	
	
	public static class CLI{
		private String[] args=null;
		private Options options=new Options();
	
	
	public CLI(String[] args){
		this.args=args;
		options.addOption("help",false,"Help!");
		options.addOption("version",false,"1.0");
		options.addOption("configFile",true,"Input config File");
		
	}
	
	public void parse(){
		CommandLineParser parser=new DefaultParser();
		try {
			CommandLine line=parser.parse(options,args);
			if(line.hasOption("configFile")){
				CONFIG_FILE=line.getOptionValue("configFile");
				
			}
			if(line.getOptions().length==0 || line.hasOption("help")){
				helpFormatter();
			}
			
			
		} catch (org.apache.commons.cli.ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void helpFormatter(){
		String helpWithUsageTxt="java -cp com.muks.javaexamples.ApacheCommonsCLI -configFile <config-file>";
		HelpFormatter fromatter=new HelpFormatter();
		fromatter.printHelp(helpWithUsageTxt,options);
	}
	
	public static void main(String[] args) throws IOException {
		new CLI(args).parse(); /* To Read CLI Arguments*/
		
		System.out.println("My Config file is : "+CONFIG_FILE);
		try{
		Properties properties =new Properties();
		InputStream inputStream=null;
		inputStream=new FileInputStream(CONFIG_FILE);
		properties.load(inputStream);
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("URL: " + properties.getProperty("url"));
//        System.out.println("BrowserType: "+properties.getProperty("browser"));
		
	}
			
}
}