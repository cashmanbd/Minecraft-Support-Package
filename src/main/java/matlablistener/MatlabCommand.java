package matlablistener;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MatlabCommand extends CommandBase{

    private ExecutorService executorService;
    private String matlabHostname = "127.0.0.1";
    private int matlabPort = 58777;

    public MatlabCommand() {

        executorService = Executors.newSingleThreadExecutor();
        try {
            String envOverride = System.getenv("MW_MATLAB_LISTENING_PORT");
            if (envOverride != null) {
                matlabPort = Integer.parseInt(envOverride);
            }

        } catch (Exception e) {
            // do nothing and use the default setting of port.
        }

        try {
            String envOverride = System.getenv("MW_MATLAB_LISTENING_ADDRESS");
            if (envOverride != null) {
                matlabHostname = envOverride.trim();
            }

        } catch (Exception e) {
            // do nothing and use the default setting of port.
        }

    }

    @Override
    public String getName()
    {
        return "matlab";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "Sends matlab command to " + matlabHostname + ":" + matlabPort;
    }

    @Override
    public void execute(ICommandSender icommandsender, String[] astring)
    {
        executorService.submit(new CommandSender(astring));
    }

    class CommandSender implements Callable<Boolean> {
        private String[] args;

        CommandSender(String[] args) {
            this.args = args;
        }

        public Boolean call() {
            StringBuilder stringBuilder = new StringBuilder();
            for (String arg : args) {
                stringBuilder.append(arg).append(' ');
            }
            try {
                String matlabCommand = stringBuilder.toString().trim();
                byte[] sendData = matlabCommand.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                InetAddress ipAddress = InetAddress.getByName(matlabHostname);
                DatagramSocket clientSocket = new DatagramSocket();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, matlabPort);
                clientSocket.send(sendPacket);
                clientSocket.close();
            } catch (IOException ioe) {
                return false;
            }
            return true;
        }
    }

}
