package com.hascode.tutorial;

import com.tngtech.configbuilder.ConfigBuilder;

public class Main {
	public static void main(final String[] args) {
		Config myConfig = new ConfigBuilder<Config>(Config.class)
				.withCommandLineArgs(args).build();
	}

}
