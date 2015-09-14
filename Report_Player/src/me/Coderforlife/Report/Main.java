package me.Coderforlife.Report;

import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public void onEnable()
  {
    getCommand("report").setExecutor(new Report(this));
    }
  
  
  public void onDisable() {
	  
  }
}
