pause(10);
data = peaks(30);
adjusted_data = data + 10;

for x = 1:size(adjusted_data,1)
    for y = 1:size(adjusted_data,2)
        setBlock(x, adjusted_data(x,y), y, Block.gold_ore);
        pause(0.1);
    end
end

pause(10);
fillArea(1, 1, 1, size(adjusted_data,1), size(adjusted_data,2), size(adjusted_data,3), Block.air);