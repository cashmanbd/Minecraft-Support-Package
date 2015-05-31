package matlablistener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = MatlabListener.MODID, version = MatlabListener.VERSION)
public class MatlabListener {

    public static final String MODID = "matlablistener";
    public static final String VERSION = "1.0";
    private static final ConcurrentLinkedQueue<String> blockQueue = new ConcurrentLinkedQueue<>();
    private int port = 57777;
    private MinecraftServer minecraftServer = null;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new MessageListener());

    }

    @EventHandler
    public void registerCommands(FMLServerStartingEvent event) {
        minecraftServer = event.getServer();
        ICommandManager command = minecraftServer.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;
        manager.registerCommand(new MatlabCommand());
    }

//    class CommandSender implements Callable<Boolean> {
//        public Boolean call() {
//            boolean listen = true;
//            while(listen) {
//                String command = blockQueue.
//            }
//            return true;
//        }
//    }

    class MessageListener implements Callable<Boolean> {

        public Boolean call() {
            boolean listen = true;
            try {
                try {
                    String envOverride = System.getenv("MW_MINECRAFT_LISTENING_PORT");
                    if (envOverride != null) {
                        port = Integer.parseInt(envOverride);
                    }

                } catch (Exception e) {
                    // do nothing and use the default setting of port.
                }
                DatagramSocket socket = new DatagramSocket(port);
                while(listen) {
                    byte[] buf = new byte[256];

                    // receive request
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);

                    ByteBuffer byteBuffer = ByteBuffer.wrap(buf);
                    String command = new String(byteBuffer.array(), java.nio.charset.StandardCharsets.UTF_8);
//                    blockQueue.add(command);
                    CommandHandler ch = (CommandHandler) minecraftServer.getCommandManager();
                    ch.executeCommand(minecraftServer, command);
                }
            } catch (IOException ioe) {
                listen = false;
            }
            return true;
        }
    }

}
