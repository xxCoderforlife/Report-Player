package me.Coderforlife.Report;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor{
	  public final String prefix = ChatColor.DARK_RED + "[" + ChatColor.RED + "Report Player" + ChatColor.DARK_RED + "] ";
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
	  
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String Commandlabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("report")){
			if(sender instanceof Player){
				String myString = "";
				for(int i = 0; i < args.length; i++){
				    String arg = args[i] + " ";
				    myString = myString + arg;
				}
				Player p = (Player) sender;
				if(p.hasPermission("report.command")){
					if(args.length == 0){
						p.sendMessage(prefix + "Not enough Args");
						return true;
					}else{
						Player target = p.getServer().getPlayerExact(args[0]); 
						if(target!= null){
							if(target !=null){
							target.sendMessage(prefix + "You have been reported.");
						}
						p.sendMessage(prefix + "Report has been sent.");
						/*(try { ****COMING SOON, REPORT LOGGING****
							@SuppressWarnings("resource")
							PrintWriter writer = new PrintWriter("reports.txt", "UTF-8");
							writer.println(p.getName() + "reported"  + target.getName());
						} catch (FileNotFoundException e) {
						System.out.println("File not found");
						} catch (UnsupportedEncodingException e) {
							System.out.println("Not used");
						}*/
						Player online = (Player) sender;
						if(online.hasPermission("report.view")){
							online.sendMessage(prefix + p.getName() + " has reported " + target.getName() + myString.replace(target.getName(), ""));
						}
					}else{
						sender.sendMessage(prefix + args[0] + " isn't online");
					}
						return true;
					}
				}
				
			}else{
				System.out.println("Only players may use this command.");
				return true;
			}
		}
		return false;
	  }
}
