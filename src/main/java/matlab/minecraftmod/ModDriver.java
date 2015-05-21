//package matlab.minecraftmod;
//
//import java.io.File;
//import java.io.IOException;
//import com.mathworks.mvm.MVM;
//import com.mathworks.mvm.MvmFactory;
//import com.mathworks.mvm.MvmSession;
//
//import com.mathworks.mvm.exec.FutureFevalResult;
//import net.minecraft.init.Blocks;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//
////@Mod(modid = ModDriver.MODID, name = "MATLAB Mod", version = ModDriver.VERSION)
//public class ModDriver
//{
//    public static final String MODID = "moddriver";
//    public static final String VERSION = "1.0";
//    private MVM mvm;
//
//    @EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
//        try {
//            final MvmSession.SessionOptions sessionOptions = new MvmSession.SessionOptions();
//            // Allow MW signal handler to not be installed if you add the following to the session
//            sessionOptions.fDisableLocalMVM = true;
//
//            final MvmSession mvmSession = MvmSession.createSession(sessionOptions);
//            final MvmFactory.FactoryOptions factoryOptions = new MvmFactory.FactoryOptions(
//                    MvmFactory.JavaLevel.SimpleJVM); //, "-matlabPath",
//    //                    new File("/Applications/MATLAB_R2015a.app/", "toolbox" + File.separator
//    //                    + "local").getAbsolutePath());
//
//            MvmFactory mvmFactory = MvmFactory.createFactory(MvmFactory.FactoryType.MATLABMVM, "TestFactory", factoryOptions);
//            mvm = mvmFactory.createMVM();
//            //            mvm.feval("setupJavaClasspath");
//
//            MATLABWorldGenerator worldGenerator = new MATLABWorldGenerator(mvm);
//            GameRegistry.registerWorldGenerator(worldGenerator, 0);
//        } catch (InterruptedException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @EventHandler
//    public void init(FMLInitializationEvent event)
//    {
//        MinecraftForge.EVENT_BUS.register(new MessageBridge(mvm));
//    }
//
//}
