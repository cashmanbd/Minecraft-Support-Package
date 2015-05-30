function [ output_args ] = setBlock(x, y, z, block)
    command = [ '/setblock ' num2str(x) ' ' num2str(y) ' ' num2str(z) ' ' block.minecraft_name]
    mcsend(command);
end

