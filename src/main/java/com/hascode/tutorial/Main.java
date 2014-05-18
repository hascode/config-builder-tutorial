package com.hascode.tutorial;

import com.tngtech.configbuilder.ConfigBuilder;

public class Main {
	public static void main(final String[] args) {
		System.setProperty("target-os", "Linux x86_64 GNU/Linux");

		Config cnf = new ConfigBuilder<Config>(Config.class)
				.withCommandLineArgs(args).build();
		System.out.println("Starting application " + cnf.getAppName());
		System.out.println("\tJava-Home-Dir\t:" + cnf.getJavaHomeDir());
		System.out.println("\tTarget-OS\t:" + cnf.getTargetOs());
		System.out.println("\tSelected Mode\t:" + cnf.getMode());
		System.out.println("\tTarget-OS\t:" + cnf.isSilent());
		System.out.println("\tAllowed users\t:");
		cnf.getUsersAllowed().forEach(
				u -> System.out.println("\t\t\t" + u.getName()));
	}

}
