//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.8.9"!

package me.kopamed.lunarkeystrokes.module;

import me.kopamed.lunarkeystrokes.module.modules.client.*;

import me.kopamed.lunarkeystrokes.utils.Utils;
import me.kopamed.lunarkeystrokes.module.modules.*;
import me.kopamed.lunarkeystrokes.module.modules.combat.*;
import me.kopamed.lunarkeystrokes.module.modules.debug.Click;

import me.kopamed.lunarkeystrokes.module.modules.minigames.*;
import me.kopamed.lunarkeystrokes.module.modules.player.*;
import me.kopamed.lunarkeystrokes.module.modules.render.*;

import me.kopamed.lunarkeystrokes.module.modules.client.AntiBot;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModuleManager {
   public static List<Module> modsList = new ArrayList<>();
   public static List<Module> enModsList = new ArrayList<>();
   public static Module nameHider;
   public static Module fastPlace;
   public static Module antiShuffle;
   public static Module antiBot;
   public static Module noSlow;
   public static Module autoClicker;
   public static Module hitBox;
   public static Module reach;
   public static Module hud;
   public static Module timer;
   public static Module fly;
   public static Module noFall;
   public static Module stringEncrypt;
   public static Module playerESP;
   public static Module safeWalk;
   public static Module keepSprint;
   public static int arrayLength = 0;

   public static boolean initialized = false;

   public void r3g1st3r() {
      this.addModule(autoClicker = new AutoClicker());
      this.addModule(new AimAssist());  
      this.addModule(new ClickAssist());
      this.addModule(new DelayRemover());
      this.addModule(hitBox = new HitBox());
      this.addModule(reach = new Reach());
      this.addModule(new Velocity());
      this.addModule(new Sprint());
      this.addModule(new AutoPlace());
      this.addModule(fastPlace = new FastPlace());
      this.addModule(safeWalk = new SafeWalk());
      this.addModule(antiBot = new AntiBot());
      this.addModule(new ChestESP());
      this.addModule(playerESP = new PlayerESP());
      this.addModule(hud = new HUD());
      this.addModule(new BridgeInfo());
      this.addModule(new DuelsStats());
      this.addModule(nameHider = new NameHider());
      this.addModule(new CommandLine());
      this.addModule(new Gui());
      this.addModule(new SelfDestruct());

      this.addModule(new Click());

      this.addModule(new BedwarsOverlay());
      arrayLength = this.getModules().size();
      this.addModule(new ExplicitB9NameTags());  
      this.defEn();
      
      initialized = true;
   }

   private void defEn() {
      antiBot.enable();
   }

   public Module getModuleByName(String name) {
      for (Module module : modsList) {
         if (module.getName().equalsIgnoreCase(name))
            return module;
      }
      return null;
   }

   private void addModule(Module m) {
      modsList.add(m);
   }

   public List<Module> getModules() {
      return this.modsList;
   }

   public List<Module> inCateg(Module.category categ) {
      ArrayList<Module> categML = new ArrayList<>();

      for (Module mod : this.getModules()) {
         if (mod.moduleCategory().equals(categ)) {
            categML.add(mod);
         }
      }

      return categML;
   }


   public static void sort() {
    
         modsList.sort((o1, o2) -> Utils.mc.fontRendererObj.getStringWidth(o2.getName()) - Utils.mc.fontRendererObj.getStringWidth(o1.getName()));
      

   }

   public static int modListSize() {
      return modsList.size();
   }

   public static void sortLongShort() {
      modsList.sort((o2, o1) -> Utils.mc.fontRendererObj.getStringWidth(o2.getName()) - Utils.mc.fontRendererObj.getStringWidth(o1.getName()));
   }

   public static void sortShortLong() {
      modsList.sort((o1, o2) -> Utils.mc.fontRendererObj.getStringWidth(o2.getName()) - Utils.mc.fontRendererObj.getStringWidth(o1.getName()));
   }

   public static int getLongestActiveModule(FontRenderer fr) {
      int length = 0;
      for(Module mod : modsList) {
         if(mod.isEnabled()){
            if(fr.getStringWidth(mod.getName()) > length){
               length = fr.getStringWidth(mod.getName());
            }
         }
      }
      return length;
   }

   public static int getBoxHeight(FontRenderer fr, int margin) {
      int length = 0;
      for(Module mod : modsList) {
         if(mod.isEnabled()){
            length += fr.FONT_HEIGHT + margin;
         }
      }
      return length;
   }
}
