//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.8.9"!

package me.kopamed.lunarkeystrokes.clickgui.raven.components;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import org.lwjgl.input.Keyboard;

import me.kopamed.lunarkeystrokes.clickgui.raven.Component;
import me.kopamed.lunarkeystrokes.module.Module;
import me.kopamed.lunarkeystrokes.module.modules.AutoConfig;
import me.kopamed.lunarkeystrokes.module.modules.client.Gui;
import me.kopamed.lunarkeystrokes.module.setting.Setting;
import me.kopamed.lunarkeystrokes.module.setting.settings.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ButtonModule extends Component {
   private final int c1 = (new Color(0, 85, 255)).getRGB();
   private final int c2 = (new Color(154, 2, 255)).getRGB();
   private final int c3 = (new Color(220, 220, 220) ).getRGB();
   public Module mod;
   public ButtonCategory category;
   public int o;
   private final ArrayList<Component> settings;
   public boolean po;

   public ButtonModule(Module mod, ButtonCategory p, int o) {
      this.mod = mod;
      this.category = p;
      this.o = o;
      this.settings = new ArrayList();
      this.po = false;
      int y = o + 16;
      if (!mod.getSettings().isEmpty()) {
         for (Setting v : mod.getSettings()) {
            if (v instanceof Slider) {
               Slider n = (Slider) v;
               ButtonSlider s = new ButtonSlider(n, this, y);
               this.settings.add(s);
               y += 12;
            } else if (v instanceof Tick) {
               Tick b = (Tick) v;
               ButtonTick c = new ButtonTick(mod, b, this, y);
               this.settings.add(c);
               y += 12;
            } else if (v instanceof Description) {
               Description d = (Description) v;
               ButtonDesc m = new ButtonDesc(d, this, y);
               this.settings.add(m);
               y += 12;
            } else if (v instanceof RangeSlider) {
               RangeSlider n = (RangeSlider) v;
               ButtonMinMaxSlider s = new ButtonMinMaxSlider(n, this, y);
               this.settings.add(s);
               y += 12;
            }else if (v instanceof Mode) {
               Mode n = (Mode) v;
               ButtonMode s = new ButtonMode(n, this, y);
               this.settings.add(s);
               y += 12;
            }

         }
      }

      this.settings.add(new AutoConfig(this, y));
   }

   public void setModuleStartAt(int n) {
      this.o = n;
      int y = this.o + 16;
      Iterator var3 = this.settings.iterator();

      while(true) {
         while(var3.hasNext()) {
            Component co = (Component)var3.next();
            co.setModuleStartAt(y);
            if (co instanceof ButtonSlider  || co instanceof ButtonMinMaxSlider) {
               y += 16;
            } else if (co instanceof ButtonTick || co instanceof AutoConfig || co instanceof ButtonDesc || co instanceof ButtonMode) {
               y += 12;
            }
         }
         
         return;
      }
   }

   public static void e() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void f() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
      GL11.glEdgeFlag(true);
   }

   public static void g(int h) {
      float a = 0.0F;
      float r = 0.0F;
      float g = 0.0F;
      float b = 0.0F;
     
      GL11.glColor4f(r, g, b, a);
   }

   public static void v(float x, float y, float x1, float y1, int t, int b) {
      e();
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      g(t);
      GL11.glVertex2f(x, y1);
      GL11.glVertex2f(x1, y1);
      g(b);
      GL11.glVertex2f(x1, y);
      GL11.glVertex2f(x, y);
      GL11.glEnd();
      GL11.glShadeModel(7424);
      f();
   }

   public void draw() {
      v((float)this.category.getX(), (float)(this.category.getY() + this.o), (float)(this.category.getX() + this.category.getWidth()), (float)(this.category.getY() + 15 + this.o), this.mod.isEnabled() ? this.c2 : -12829381, this.mod.isEnabled() ? this.c2 : -12302777);
      GL11.glPushMatrix();
      // module text button
      int button_rgb = this.c3;
      if (this.mod.isEnabled()) {
    	  net.minecraft.client.gui.Gui.drawRect(this.category.getX(), (this.category.getY() + this.o), (this.category.getX() + this.category.getWidth()), (this.category.getY() + 15 + this.o), new Color((int)Gui.ar.getInput(), (int)Gui.ag.getInput(), (int)Gui.ab.getInput()).getRGB());
      }
      
      int kc = this.mod.getKeybind();
      int kw = Minecraft.getMinecraft().fontRendererObj.getStringWidth(Keyboard.getKeyName(kc));
      if (this.mod.getKeybind() != 0 && !this.po) {
    	  //net.minecraft.client.gui.Gui.drawRect( this.category.getX() + this.category.getWidth() - 6 - kw, (this.category.getY() + this.o) + 3, (this.category.getX() + this.category.getWidth() - 3), (this.category.getY() + 12 + this.o), (new Color(15, 15, 15, 100).getRGB()));
    	  Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(Keyboard.getKeyName(kc), this.category.getX() + this.category.getWidth() - 4 - kw,this.category.getY() + 4 + this.o, (new Color(250, 250, 250)).getRGB());
      }
      if (this.po && !this.settings.isEmpty()) {

    	  net.minecraft.client.gui.Gui.drawRect(this.category.getX() + 1, (this.category.getY() + this.o + 15), (this.category.getX() + this.category.getWidth() - 1), (this.category.getY() + this.o + getHeight() - 2), (new Color(39, 37, 38)).getRGB());
	  }
      
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.mod.getName(), this.category.getX() + 4,this.category.getY() + 4 + this.o, this.c3);
      GL11.glPopMatrix();
      if (this.po && !this.settings.isEmpty()) {
         for (Component c : this.settings) {
            c.draw();
         }
      }

   }
   
   public int getHeight() {
      if (!this.po) {
         return 16;
      } else {
         int h = 16;
         Iterator var2 = this.settings.iterator();

         while(true) {
            while(var2.hasNext()) {
               Component c = (Component)var2.next();
               if (c instanceof ButtonSlider || c instanceof ButtonMinMaxSlider) {
                  h += 16;
               } else if (c instanceof ButtonTick || c instanceof AutoConfig || c instanceof ButtonDesc || c instanceof ButtonMode) {
                  h += 12;
               }
            }

            return h;
         }
      }
   }

   public void compute(int mousePosX, int mousePosY) {
      if (!this.settings.isEmpty()) {
         for (Component c : this.settings) {
            c.compute(mousePosX, mousePosY);
         }
      }

   }

   public void mouseDown(int x, int y, int b) {

      if (this.ii(x, y) && b == 0) {
         this.mod.toggle();
      }

      if (this.ii(x, y) && b == 1) {
         this.po = !this.po;
         this.category.r3nd3r();
      }

      for (Component c : this.settings) {
         c.mouseDown(x, y, b);
      }

   }

   public void mouseReleased(int x, int y, int m) {
      for (Component c : this.settings) {
         c.mouseReleased(x, y, m);
      }

   }

   public void ky(char t, int k) {
      for (Component c : this.settings) {
         c.ky(t, k);
      }

   }

   public boolean ii(int x, int y) {
      return x > this.category.getX() && x < this.category.getX() + this.category.getWidth() && y > this.category.getY() + this.o && y < this.category.getY() + 16 + this.o;
   }
}
