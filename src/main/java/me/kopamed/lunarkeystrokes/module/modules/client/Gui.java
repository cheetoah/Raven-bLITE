//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.8.9"!

package me.kopamed.lunarkeystrokes.module.modules.client;

import java.awt.Color;
import me.kopamed.lunarkeystrokes.main.NotAName;
import me.kopamed.lunarkeystrokes.module.Module;
import me.kopamed.lunarkeystrokes.module.setting.settings.Description;
import me.kopamed.lunarkeystrokes.module.setting.settings.Slider;
import me.kopamed.lunarkeystrokes.module.setting.settings.Tick;
import me.kopamed.lunarkeystrokes.utils.Utils;

public class Gui extends Module {
   public static final int bind = 54;
   public static Slider ar, ag, ab;
  
   public static Tick toggleNotification;
   public static Tick rainbowNotification;
   
   public Gui() {
      super("Gui", Module.category.client, 54);
     

      this.registerSetting(ar = new Slider("Accent Red", 69.0D, 0.0D, 255.0D, 1.0D));
      this.registerSetting(ag = new Slider("Accent Green", 69.0D, 0.0D, 255.0D, 1.0D));
      this.registerSetting(ab = new Slider("Accent Blue", 69.0D, 0.0D, 255.0D, 1.0D));
      
      this.registerSetting(toggleNotification = new Tick("Toggle Notifications", true));
      this.registerSetting(rainbowNotification = new Tick("Rainbow Notifications", true));
   }

   public void onEnable() {
      if (Utils.Player.isPlayerInGame() && mc.currentScreen != NotAName.clickGui) {
         mc.displayGuiScreen(NotAName.clickGui);
            NotAName.clickGui.initMain();
      }

      this.disable();
   }
   
   public void guiUpdate() {
      
   }
   

}
