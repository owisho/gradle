package com.manning.gia.todo.utils;

import java.util.Scanner;
import java.util.List;
import com.manning.gia.todo.repository.InMemoryToDoRepository;
import com.manning.gia.todo.repository.ToDoRepository;
import com.manning.gia.todo.model.ToDoItem;

public class CommandLineInputHandler{
	
	Scanner sc = new Scanner(System.in);
	ToDoRepository toDoRepository = new InMemoryToDoRepository();
	
	public String readInput(){
		return sc.nextLine();
	}
	
	public void printOptions(){
		System.out.println("(a)ll items");
		System.out.println("(f)ind a specific item");
		System.out.println("(i)nsert a new item");
		System.out.println("(u)pdate an existing item");
		System.out.println("(d)elete an existing item");
		System.out.println("(e)xit");
	}
	
	public void processInput(CommandLineInput commandLineInput){
		char command = commandLineInput.getCommand();
		switch (command) {
		case 'a':
			List<ToDoItem> items = toDoRepository.findAll();
			for(ToDoItem item:items){
				System.out.println(item);
			}
			break;
		case 'f':
			String numStr = readInput();
			long num = Long.parseLong(numStr);
			ToDoItem item = toDoRepository.findById(num);
			System.out.println(item);
			break;
		case 'i':
			ToDoItem itemi = new ToDoItem();
			System.out.println("please input name");
			String name = readInput();
			itemi.setName(name);
			System.out.println("please input completed");
			String completed = readInput();
			if("true".equals(completed)){
				itemi.setCompleted(true);
			}else{
				itemi.setCompleted(false);
			}
			toDoRepository.insert(itemi);	
			System.out.println("option complete");			
			break;
		case 'u':
			ToDoItem itemu = new ToDoItem();
			System.out.println("please input id");
			String idStr = readInput();
			Long id = Long.parseLong(idStr);
			itemu.setId(id);
			System.out.println("please input name");
			String nameu = readInput();
			itemu.setName(nameu);
			System.out.println("please input completed");
			String completedu = readInput();
			if("true".equals(completedu)){
				itemu.setCompleted(true);
			}else{
				itemu.setCompleted(false);
			}
			toDoRepository.update(itemu);
			System.out.println("option complete");
			break;
		case 'd':
			ToDoItem itemd = new ToDoItem();
			System.out.println("please input id");
			String idStrd = readInput();
			Long idd = Long.parseLong(idStrd);
			itemd.setId(idd);
			toDoRepository.delete(itemd);
			System.out.println("option complete");
			break;
		case 'e':
			System.exit(1);
			break;
		default:
			break;
		}
	}
	
}