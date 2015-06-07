function minecraftcommandsend( command )
    javaaddpath('./java/minecraftcomms.jar');   
    com.mathworks.minecraft.MinecraftCommandSender.send(command);
end

