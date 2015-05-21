function [ output_args ] = mcsend( command )
    u = udp('127.0.0.1', 57777);
    fopen(u);
    fwrite(u,command);
    fclose(u);
end

