pause(10);
data = peaks(30);
adjusted_data = data + 10;
mc = Minecraft();

for x = 1:size(adjusted_data,1)
    for y = 1:size(adjusted_data,2)
        mc.setBlock(x, adjusted_data(x,y), y, Block.gold_ore);
        pause(0.1);
    end
end

pause(10);
mc.fillArea(1, 1, 1, size(adjusted_data,1), size(adjusted_data,2), max(adjusted_data), Block.air);