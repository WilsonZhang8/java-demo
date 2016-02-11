package com.zghw.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * java内部执行其他操作系统的程序，并且控制这些程序的输入和输出
 * 工具
 * @author zghw
 *
 */
public class OSExecute {
	public static void command(String command){
		boolean err=false;
		try {
			Process process=new ProcessBuilder(command.split(" ")).start();
			BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s=br.readLine())!=null){
				System.out.println(s);
			}
			BufferedReader er=new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s=er.readLine())!=null){
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		OSExecute.command("javap /home/zghw/github/java-demo/bin/com/zghw/base/OSCommand.class");
		}
}
