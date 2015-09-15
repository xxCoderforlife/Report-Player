package me.Coderforlife.Report;

import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report
  implements CommandExecutor
{
  public final String prefix = ChatColor.DARK_RED + "[" + ChatColor.RED + "Report Player" + ChatColor.DARK_RED + "] " + ChatColor.RESET;
  public final String hack = " for hacking";
  private Main plugin;
  
  public Report(Main plugin)
  {
    setPlugin(plugin);
  }
  
  private void setPlugin(Main plugin) {}
  
  public Main getPlugin()
  {
    return this.plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String Commandlabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("report")) {
      if ((sender instanceof Player))
      {
        String myString = "";
        for (int i = 0; i < args.length; i++)
        {
          String arg = args[i] + " ";
          myString = myString + arg;
        }
        Player p = (Player)sender;
        if (p.hasPermission("report.command"))
        {
          if (args.length == 0)
          {
            p.sendMessage(this.prefix + ChatColor.GOLD + "Wrong Syntax: " + ChatColor.WHITE + 
            		"Use /report <player name> [reason]");
            return true;
          }
      	if(!args[0].equalsIgnoreCase(p.getName())){
          Date date = new Date();
          @SuppressWarnings("deprecation")
		Player target = p.getServer().getPlayerExact(args[0]);
          Player online = (Player)sender;
          if (target != null)
          {
            target.sendMessage(this.prefix + ChatColor.GOLD + "You have been reported");
            p.sendMessage(this.prefix + ChatColor.GOLD + "Report has been sent.");
            if (online.hasPermission("report.view")) {
              online.sendMessage(this.prefix + ChatColor.GREEN + p.getName() + ChatColor.GOLD + 
                " has reported " + ChatColor.GREEN + target.getName() + ChatColor.AQUA + 
                myString.replace(target.getName(), "") + ChatColor.GOLD + " on " + date);
            }
          }
          else
          {
            sender.sendMessage(this.prefix + ChatColor.GOLD + args[0] + " isn't online");
          }
          return true;
        }else{
        	p.sendMessage(this.prefix+ "I'm sorry you can not report yourself.");
        }
      }else{
        p.sendMessage("You don't have permission to do this.");
      }
        return true;
      }else{
    	  System.out.println(ChatColor.RED + "Only players may use this command.");
      }
    }
    return false;
  }
}
