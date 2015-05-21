//package matlab.minecraftmod;
//
//import java.io.IOException;
//import com.mathworks.mvm.MVM;
//import com.mathworks.mvm.exec.MatlabFevalRequest;
//import com.mathworks.mvm.exec.FutureFevalResult;
//import com.mathworks.mvm.exec.MvmExecutionException;
//import net.minecraft.util.ChatComponentText;
//import net.minecraft.util.EnumChatFormatting;
//import net.minecraftforge.event.world.BlockEvent.BreakEvent;
//import net.minecraftforge.event.world.ChunkEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//public class MessageBridge {
//
//    private final MVM mvm;
//
//    public MessageBridge(final MVM mvm) {
//        this.mvm = mvm;
//    }
//
//    @SubscribeEvent
//    public void sendMessage(final BreakEvent event) {
//        try {
//            System.out.println("Calling breakEvent in MATLAB");
//            MatlabFevalRequest request = new MatlabFevalRequest("EventListener.breakEvent",event.getPlayer());
//            final FutureFevalResult<Object> result = mvm.getExecutor().submit(request);
//            System.out.println(Thread.currentThread());
//            System.out.println(result.get());
//        } catch (InterruptedException | MvmExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @SubscribeEvent
//    public void sendMessage(final ChunkEvent event) {
//
//    }
//}
