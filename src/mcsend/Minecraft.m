classdef Minecraft
    
    properties
        listener = com.mathworks.minecraft.MinecraftCommandListener;
    end
    
    methods
        function start(obj)
           javaaddpath('./java/minecraftcomms.jar');   
           obj.listener.start(); 
        end
        
        function stop(obj)
           javaaddpath('./java/minecraftcomms.jar');   
           obj.listener.stop(); 
        end
        
        function send(~, command)
            javaaddpath('./java/minecraftcomms.jar');   
            com.mathworks.minecraft.MinecraftCommandSender.send(command);
        end
        
        function setBlock(obj, x, y, z, block)
            command = [ '/setblock ' num2str(x) ' ' num2str(y) ' '...
                num2str(z) ' ' block.minecraft_name];
            obj.send(command);
        end
        
        function fill( x1, y1, z1, x2, y2, z2, block )
            command = [ '/fill ' num2str(x1) ' ' num2str(y1) ' ' ...
                num2str(z1) ' ' num2str(x2) ' ' num2str(y2) ' ' ...
                num2str(z2) ' ' block.minecraft_name];
            obj.send(command);
        end
    end
    
end

