package com.manning.gia.todo.utils;

public class CommandLineInput{
	
	char command;
	
	public CommandLineInput(char command){
		this.command = command;
	}
	
	public static class EXIT{
		public static char getShortCmd(){
			return 'E';
		}
	}
	
	public static CommandLineInput getCommandLineInputForInput(char command){
		return new CommandLineInput(command);
	}
	
	public char getCommand(){
		return this.command;
	}
	
}