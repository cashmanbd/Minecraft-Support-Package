pause(10);
data = peaks(20);
adjusted_data = data + 10;

for x = 1:size(adjusted_data,1)
    for y = 1:size(adjusted_data,2)
        setBlock(x + 15, adjusted_data(x,y), y - 900);
        pause(0.1);
    end
end