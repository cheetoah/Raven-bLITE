//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.8.9"!

package me.kopamed.lunarkeystrokes.clickgui.raven.components;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import me.kopamed.lunarkeystrokes.clickgui.raven.Component;
import me.kopamed.lunarkeystrokes.main.Ravenbplus;
import me.kopamed.lunarkeystrokes.module.Module;
import me.kopamed.lunarkeystrokes.module.modules.client.Gui;
import me.kopamed.lunarkeystrokes.module.modules.HUD;
import me.kopamed.lunarkeystrokes.utils.Utils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ButtonCategory {
   public ArrayList<Component> modulesInCategory = new ArrayList();
   public Module.category categoryName;
   private boolean categoryOpened;
   private int width;
   private int y;
   private int x;
   private final int bh;
   private int c = (new Color(24, 22, 26)).getRGB();
   public boolean inUse;
   public int xx;
   public int yy;
   public boolean n4m = false;
   public String pvp;
   public boolean pin = false;
   private int chromaSpeed;
   private double marginY, marginX;

   public ButtonCategory(Module.category category) {
      this.categoryName = category;
      
      this.width = 75;
      this.x = 5;
      this.y = 5;
      this.bh = 13;
      this.xx = 0;
      this.categoryOpened = false;
      this.inUse = false;
      this.chromaSpeed = 3;
      int tY = this.bh + 3;
      this.marginX = 80;
      this.marginY = 4.5;

      for(Iterator<Module> var3 = Ravenbplus.notAName.getm0dmanager().inCateg(this.categoryName).iterator(); var3.hasNext(); tY += 16) {
         Module mod = (Module) var3.next();
         ButtonModule b = new ButtonModule(mod, this, tY);
         this.modulesInCategory.add(b);
      }

   }

   public ButtonCategory(String d) {
      this.width = 75;
      this.x = 5;
      this.y = 5;
      this.bh = 13;
      this.xx = 0;
      this.categoryOpened = false;
      this.inUse = false;
      int tY = this.bh;
      this.pvp = d;
      this.n4m = true;
   }

   public ArrayList<Component> getModules() {
      return this.modulesInCategory;
   }

   public void setX(int n) {
      this.x = n;
      if(Ravenbplus.clientConfig != null){
         Ravenbplus.clientConfig.saveConfig();
      }
   }

   public void setY(int y) {
      this.y = y;
      if(Ravenbplus.clientConfig != null){
         Ravenbplus.clientConfig.saveConfig();
      }
   }

   public void mousePressed(boolean d) {
      this.inUse = d;
   }

   public boolean p() {
      return this.pin;
   }

   public void cv(boolean on) {
      this.pin = on;
   }

   public boolean isOpened() {
      return this.categoryOpened;
   }

   public void setOpened(boolean on) {
      this.categoryOpened = on;
      if(Ravenbplus.clientConfig != null){
         Ravenbplus.clientConfig.saveConfig();
      }
   }

   public void rf(FontRenderer renderer) {
      this.width = 110;
      if (!this.modulesInCategory.isEmpty() && this.categoryOpened) {
         int categoryHeight = 0;

         Component moduleRenderManager;
         for(Iterator moduleInCategoryIterator = this.modulesInCategory.iterator(); moduleInCategoryIterator.hasNext(); categoryHeight += moduleRenderManager.getHeight()) {
            moduleRenderManager = (Component)moduleInCategoryIterator.next();
         }

         //drawing the background for every module in the category
         net.minecraft.client.gui.Gui.drawRect(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.bh + categoryHeight + 3, Utils.Client.astolfoColorsDraw(25, 24));
         net.minecraft.client.gui.Gui.drawRect(this.x, this.y + 4, this.x + this.width, this.y + this.bh + categoryHeight + 2, (new Color(31, 29, 30)).getRGB());
      } else {
    	  net.minecraft.client.gui.Gui.drawRect(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.bh + 4, (new Color(10, 10, 10)).getRGB());
      }

     
    	net.minecraft.client.gui.Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.bh + 3, (new Color(22, 20, 21)).getRGB());
    	if (this.categoryName.name() == "hud") {
    		renderer.drawString("TEXT HUD", (float)(this.x + 2 + (this.width / 3)- (Minecraft.getMinecraft().fontRendererObj.getStringWidth("TEXT HUD")) / 2), (float)(this.y + marginY), (new Color(255, 255, 245)).getRGB(), false);
    		
    	} else
    		renderer.drawString(this.n4m ? this.pvp : this.categoryName.name().toUpperCase(), (float)(this.x + 2 + (this.width / 3)- (Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.categoryName.name().toUpperCase())) / 2), (float)(this.y + marginY), (new Color(255, 255, 245)).getRGB(), false);
      //renderer.drawString(this.n4m ? this.pvp : this.categoryName.name(), (float)(this.x + 2), (float)(this.y + 4), ay.astolfoColorsDraw(10, 14), false);
      if (!this.n4m) {
         GL11.glPushMatrix();
         //Opened/closed unicode... :yes: :holsum: :evil:
         renderer.drawString(this.categoryOpened ? "-" : "+", (float)(this.x + this.width - 15), (float)((double)this.y + marginY), (new Color(150, 150, 150)).getRGB(), false);
         GL11.glPopMatrix();
         if (this.categoryOpened && !this.modulesInCategory.isEmpty()) {
        	net.minecraft.client.gui.Gui.drawRect(this.x, this.y + this.bh + 2, this.x + this.width, this.y + this.bh + 3, (new Color(42, 40, 41)).getRGB());
            Iterator var5 = this.modulesInCategory.iterator();

            while(var5.hasNext()) {
               Component c2 = (Component)var5.next();
               c2.draw();
            }
         }

      }
   }

   public void r3nd3r() {
      int o = this.bh + 3;

      Component c;
      for(Iterator var2 = this.modulesInCategory.iterator(); var2.hasNext(); o += c.getHeight()) {
         c = (Component)var2.next();
         c.setModuleStartAt(o);
      }

   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }
   
   public int getHeight() {
	   return this.bh + 4;
   }
   public int getWidth() {
      return this.width;
   }

   public void up(int x, int y) {
      if (this.inUse) {
         this.setX(x - this.xx);
         this.setY(y - this.yy);
      }

   }

   public boolean i(int x, int y) {
      return x >= this.x + 92 - 13 && x <= this.x + this.width && (float)y >= (float)this.y + 2.0F && y <= this.y + this.bh + 1;
   }

   public boolean mousePressed(int x, int y) {
      return x >= this.x + 77 && x <= this.x + this.width - 6 && (float)y >= (float)this.y + 2.0F && y <= this.y + this.bh + 1;
   }

   public boolean insideArea(int x, int y) {
      return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.bh;
   }
}
