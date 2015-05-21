% added all minecraft jars to classpath.txt and commmented out java/patch
% entry 3/3/2015
diary '/tmp/diary.txt';
%java.lang.System.setProperty('log4j.configurationFile','/Users/brendancashman/Documents/minecraftforge/eclipse/log4j2_setting.xml');
java.lang.System.setProperty('legacy.debugClassLoadingFiner','true');
java.lang.System.setProperty('legacy.debugClassLoading','true');
%java.lang.System.setProperty('legacy.debugClassLoadingSave', 'true');
% add javamatlab layer
%javaaddpath('/Users/brendancashman/Documents/MATLAB/mods');
%javaaddpath('/Users/brendancashman/Documents/minecraftforge/out/production/minecraftforge');
%javaaddpath('/Users/brendancashman/.gradle/caches/minecraft/net/minecraftforge/forge/1.8-11.14.0.1290-1.8/start');
%javaaddpath('/Users/brendancashman/Documents/minecraftforge/out/production/minecraftforge/matlab/minecraftmod/ModDriver.class');
%javaaddpath('/Users/brendancashman/Documents/minecraftforge/out/production/minecraftforge/matlab/minecraftmod/MessageBridge.class');
args = javaArray('java.lang.String',1);
args(1) = java.lang.String('');
g = GradleStart;
g.main(args);