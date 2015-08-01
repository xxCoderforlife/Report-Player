package me.Coderforlife.Report;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  Logger logger = Logger.getLogger("Minecraft");
  public final String prefix = ChatColor.DARK_RED + "[" + ChatColor.RED + "Report Player" + ChatColor.DARK_RED + "] ";
private int i;
  
  public void onEnable()
  {
    PluginDescriptionFile pdffile = getDescription();
    this.logger.info(pdffile.getName() + ChatColor.RED + 
      " Has Been Enabled." + "Version: " + pdffile.getVersion() + " Website: " + pdffile.getWebsite());
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String Commandlabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("report")) {
      if ((sender instanceof Player))
      {
    	  if (sender.getServer().getPlayer(args[0]) != null)
          {
            StringBuilder msg = new StringBuilder();
            for (int i = 1; i < args.length; i++)
            {
              if (i > 1) {
                msg.append(" ");
              }
              msg.append(args[i]);
            }
        Player player = (Player)sender;
        if (player.hasPermission("report.player"))
        {
          if (args.length < 1)
          {
            sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Not enough arguments!");
            sender.sendMessage(this.prefix + ChatColor.RED + "/report " + ChatColor.GREEN + "[Player]");
            return true;
          }
          Player target = sender.getServer().getPlayer(args[0]);
          if (target != null)
          {
            player.sendMessage(this.prefix + "Report Sent!");
                Player online = (Player) sender;
              if (online.hasPermission("report.view"))
              {
                online.sendMessage(this.prefix + ChatColor.GREEN + player.getName() + ChatColor.RED + " has reported " + ChatColor.GREEN + target.getName() + ChatColor.RED + " for "+ args[i]);
              }
            }
        }
        else
        {
          sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You Do Not Have Permission To Do That Command!");
        }
      }
      else
      {
        sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "That Command can not be done by the console");
      }
    }
    return true;
  }
	return true;
 }
}
