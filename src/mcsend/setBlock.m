function [ output_args ] = setBlock(x, y, z)
    command = [ '/setblock ' num2str(x) ' ' num2str(y) ' ' num2str(z) ' minecraft:stone' ]
%     strcat('/setblock ', num2str(x), ' ', num2str(y), ' ',...
%         num2str(z), ' minecraft:stone')
    mcsend(command);
end

