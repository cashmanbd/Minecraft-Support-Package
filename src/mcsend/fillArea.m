function [ output_args ] = fillArea( x1, y1, z1, x2, y2, z2, block )
    command = [ '/fill ' num2str(x1) ' ' num2str(y1) ' ' num2str(z1) ' '...
         num2str(x2) ' ' num2str(y2) ' ' num2str(z2) ' '...
        block.minecraft_name]
    mcsend(command);
end

