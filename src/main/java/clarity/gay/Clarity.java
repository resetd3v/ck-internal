package clarity.gay;

import clarity.gay.modules.Module;
import clarity.gay.modules.ModuleManager;
import clarity.gay.modules.utils.Fonts;
import org.greenrobot.eventbus.EventBus;
import org.lwjgl.opengl.Display;

public class Clarity {
    private static final Clarity INSTANCE = new Clarity();

    private static final String name = "Clarity";
    private static final String ver = "v0.0.1";
    public final EventBus eventBus = new EventBus();
    private Clarity() {
    }

    public static Clarity getInstance() {
        return INSTANCE;
    }

    public void init() {
        ModuleManager moduleManager = new ModuleManager();
        Display.setTitle(name + " | " + ver);
        Fonts.INSTANCE.setup();
        moduleManager.initModule();

        ModuleManager.modules.values().stream().filter(Module::getStartup).forEach(Module::enableOnStartUp);
    }
}