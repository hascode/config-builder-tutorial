package com.hascode.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tngtech.configbuilder.annotation.propertyloaderconfiguration.PropertiesFiles;
import com.tngtech.configbuilder.annotation.typetransformer.TypeTransformer;
import com.tngtech.configbuilder.annotation.typetransformer.TypeTransformers;
import com.tngtech.configbuilder.annotation.valueextractor.CommandLineValue;
import com.tngtech.configbuilder.annotation.valueextractor.DefaultValue;
import com.tngtech.configbuilder.annotation.valueextractor.EnvironmentVariableValue;
import com.tngtech.configbuilder.annotation.valueextractor.PropertyValue;
import com.tngtech.configbuilder.annotation.valueextractor.SystemPropertyValue;

@PropertiesFiles("config")
public class Config {
	@PropertyValue("app.name")
	private String appName;

	@EnvironmentVariableValue("JAVA_HOME")
	private String javaHomeDir;

	@SystemPropertyValue("target-os")
	private String targetOs;

	@DefaultValue("interactive")
	@CommandLineValue(shortOpt = "m", longOpt = "mode", hasArg = true)
	private String mode;

	@CommandLineValue(shortOpt = "s", longOpt = "silent", hasArg = false)
	private boolean silent;

	@TypeTransformers(StringToUserTransformer.class)
	@CommandLineValue(shortOpt = "u", longOpt = "users", hasArg = true)
	@PropertyValue("users.allowed")
	private List<User> usersAllowed = new ArrayList<>();

	public static class StringToUserTransformer extends
			TypeTransformer<String, List<User>> {
		@Override
		public List<User> transform(final String input) {
			List<String> names = Arrays.asList(input.split(","));
			return names.stream().map(s -> new User(s))
					.collect(Collectors.toList());
		}
	}

	public final String getAppName() {
		return appName;
	}

	public final void setAppName(final String appName) {
		this.appName = appName;
	}

	public final String getJavaHomeDir() {
		return javaHomeDir;
	}

	public final void setJavaHomeDir(final String javaHomeDir) {
		this.javaHomeDir = javaHomeDir;
	}

	public final String getTargetOs() {
		return targetOs;
	}

	public final void setTargetOs(final String targetOs) {
		this.targetOs = targetOs;
	}

	public final String getMode() {
		return mode;
	}

	public final void setMode(final String mode) {
		this.mode = mode;
	}

	public final boolean isSilent() {
		return silent;
	}

	public final void setSilent(final boolean silent) {
		this.silent = silent;
	}

	public final List<User> getUsersAllowed() {
		return usersAllowed;
	}

	public final void setUsersAllowed(final List<User> usersAllowed) {
		this.usersAllowed = usersAllowed;
	}
}
