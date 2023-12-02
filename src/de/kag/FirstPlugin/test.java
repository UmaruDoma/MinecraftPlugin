// https://bukkit.gamepedia.com/Plugin_Tutorial/de
package de.kag.FirstPlugin;

import java.util.logging.Logger;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class test extends JavaPlugin implements Listener{
	Logger log = null;
	
	@Override
	public void onEnable()
	{ 
		log = this.getLogger();
		log.info("//////////////////// FirstPlugin enabled");
		getServer().getPluginManager().registerEvents((Listener) this, this);
	}
	@Override
	public void onDisable()
	{ 
		log.info("//////////////////// FirstPlugin disabled");
	}
	/*
	 * @EventHandler public void onPlayerJoin(PlayerJoinEvent event) { Player player
	 * = event.getPlayer(); // Der Spieler // PlayerInventory inventory =
	 * player.getInventory(); // Das Inventar des Spielers // ItemStack diamondstack
	 * = new ItemStack(Material.DIAMOND, 64); // Ein Stack mit Diamanten
	 * 
	 * // if (inventory.contains(diamondstack)) { //Überprüft, ob im Inventar ein
	 * Stack mit Diamanten vorhanden ist // inventory.addItem(diamondstack); // Fügt
	 * dem Inventar einen weiteren Stack Diamanten hinzu
	 * player.sendMessage(ChatColor.AQUA +
	 * "Tach,toll gemacht du kannst Minecraft starten! Yaaay...-_-"); // } }
	 * 
	 * @EventHandler public void onPlayerMove(PlayerMoveEvent event) { Player player
	 * = event.getPlayer(); String[]texte=new String[20]; texte[0] =
	 * "Sei mal nicht zu Sportlich hier!"; texte[1] = "Gotta go fast!"; texte[2] =
	 * "Lauf oder ich stech dich ab!"; texte[3] = "SANIC!!!"; texte[4] =
	 * "*plays Tuba"; texte[5] = "Can't stop won't stop"; texte[6] =
	 * "Is this:Not annoying?"; texte[7] =
	 * "Du musst nur schneller sein als deine Freunde"; texte[8] =
	 * "Vorsicht weniger heiß! Mehr Fettig!"; texte[9] = "DA WAE DA WAE!"; int
	 * number = new Random().nextInt(5); String name=player.getName();
	 * player.sendMessage(ChatColor.AQUA + texte[number]); }
	 */
//public void onPlayerJoinb(PlayerJoinEvent event) 
//{
//    Player player = event.getPlayer(); // Der Spieler
//    PlayerInventory inventory = player.getInventory(); // Das Inventar des Spielers
//    ItemStack diamondstack = new ItemStack(Material.DIAMOND, 64); // Ein Stack mit Diamanten
//        
//    if (inventory.contains(diamondstack)) {
//    //Überprüft, ob im Inventar ein Stack mit Diamanten vorhanden ist
//    	inventory.addItem(diamondstack); // Fügt dem Inventar einen weiteren Stack Diamanten hinzu
//        player.sendMessage(ChatColor.GOLD + "Diamonds Schmiamonds!");
//    }
//    
//    }



@EventHandler
public void onBlockBreak(final BlockBreakEvent e) 
{
	
	Location loc = e.getBlock().getLocation();
	int x = loc.getBlockX();
	int z = loc.getBlockZ();
	if (((x>-160)&&(x<-150))&&((z>40)&&(z<50)))
	{
		e.setCancelled(true);
		log.info("DONT Break the Jail " + e.getPlayer().getName());
		Bukkit.broadcastMessage("DONT Break the Jail " + e.getPlayer().getName());
	}
	//	Player player = e.getPlayer();
//	log.info("Break "+player.getName()  );
//	Material m =e.getBlock().getType();
//	log.info("Break "+m.toString()  );
//	String[]texte=new String[20];
//    texte[0] = "Alter! nicht cool" ;
//    texte[1] = "Wie denkst du fühlen sich die Blöcke dabei? HMMM!?";
//    texte[2] = "Wieso schlägst du mich?";
//    texte[3] = "AUA! Das hat weh getan!";
//    int number = new Random().nextInt(5);
//	String name=player.getName();
//	player.sendMessage(ChatColor.GREEN + texte[number]);
}

//	@EventHandler
//	public void onWorldChange(PlayerChangedWorldEvent e) 
//	{
//		Player player = e.getPlayer();
//		log.info(player.getName()  );
//		player.sendMessage(ChatColor.LIGHT_PURPLE + "Beam me up Scotty!");
//	}
//	@EventHandler
	public void onBlockBurn(BlockBurnEvent e) 
	{
		Material m =e.getBlock().getType();
		//player.sendMessage(ChatColor.LIGHT_PURPLE + "Beam me up Scotty!");
		e.getBlock().setType(Material.DIAMOND_BLOCK);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Material m =event.getBlock().getType();
		
		//player.sendMessage(ChatColor.LIGHT_PURPLE + "Beam me up Scotty!");
		//e.getBlock().setType(Material.DIAMOND_BLOCK);
//		log.info("Place getBlock"+event.getBlock().getType().toString());
//
		log.info("Place Material "+m.toString()  );
		log.info("Place getHand "+event.getHand().toString());
//		log.info("Place getBlockPlaced "+event.getBlockPlaced().getType().toString());
//		log.info("Place getName "+event.getPlayer().getName());
	//	log.info(e.getPlayer());
		//Player player = event.getPlayer();
		//for (ItemStack is : player.getInventory()){
		//	log.info("Place getInventory "+is.getType().toString());
		//}
		
		//event.setCancelled(true);
		
		if((m == Material.TNT)
		|| (m == Material.DISPENSER)		
		|| (m == Material.BOWL)		
		|| (m == Material.BUCKET)		
		|| (m == Material.CREEPER_SPAWN_EGG)		
		|| (m == Material.DRAGON_EGG)		
		|| (m == Material.ELDER_GUARDIAN_SPAWN_EGG)		
		|| (m == Material.FIRE)		
		|| (m == Material.FLINT_AND_STEEL)		
		|| (m == Material.LAVA_BUCKET)		
		|| (m == Material.TNT_MINECART)		
		|| (m == Material.LAVA))
			{
			//event.getBlock().setType(Material.AIR);
			 
			Player teacher = Bukkit.getPlayer("cndrbrbr");
			
			log.info("DONT Place "+ m.toString() +" - "+event.getPlayer().getName());
			Bukkit.broadcastMessage("DONT Place "+ m.toString() +" - "+event.getPlayer().getName());
			//event.getPlayer().kickPlayer("No TNT "); //The message that you want the kicked player to see.
			//event.getPlayer().teleport(new Location(event.getPlayer().getWorld(),-155,74,45));
			if (teacher != null) {
				event.getPlayer().teleport(teacher.getLocation());
			}
			else {
				event.getPlayer().teleport(new Location(event.getPlayer().getWorld(),-155,74,46));
			}
			
			event.setCancelled(true);
		}
		
		
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {
		org.bukkit.entity.Entity en = e.getEntity();
		log.info("Explode entity "+en.getType().toString());
		e.setCancelled(true);
	}
 	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
	//	Material m =e.getClickedBlock().getType();
		//player.sendMessage(ChatColor.LIGHT_PURPLE + "Beam me up Scotty!");
		//e.getBlock().setType(Material.DIAMOND_BLOCK);
		log.info("Place getClickedBlock "+e.getClickedBlock().getType().toString());

	//	log.info("Place Material "+m.toString()  );
		log.info("Place getHand "+e.getMaterial().toString());
		log.info("Place getName "+e.getPlayer().getName());
	//	log.info(e.getPlayer());
	//	Player p = e.getPlayer();
	//	for (ItemStack is : p.getInventory()){
	//		log.info("Place getInventory "+is.getType().toString());
	//	}
		Material m = e.getMaterial();
		if(m == Material.FIREWORK_ROCKET)
			{e.setCancelled(true);
			}
		
		
		
	}
	
	
//	  @EventHandler(priority = EventPriority.HIGH)
//	    public void blockWatchdog(BlockPlaceEvent event) {
//	        /*
//	        if(BlockLava == true){
//	            if(event.getBlock().getType() == Material.LAVA){
//	                event.setCancelled(true);
//	                event.getPlayer().sendMessage("You tried to place LAVA, which is not allowed!");
//	                log.info(event.getPlayer().getDisplayName().toString() + " placed LAVA!");
//	            }
//	        }
//	        if(BlockWater == true){
//	            if(event.getBlock().getType() == Material.WATER){
//	                event.setCancelled(true);
//	                event.getPlayer().sendMessage("You tried to place WATER, which is not allowed!");
//	                log.info(event.getPlayer().getDisplayName().toString() + " placed WATER!");
//	            }
//	        }*/
//	        if(BlockTNT == true){
//	            if(event.getBlock().getType() == Material.TNT) {
//	            event.setCancelled(true);
//	            event.getPlayer().sendMessage("You tried to place TNT, which is not allowed!");
//	            log.info(event.getPlayer().getDisplayName().toString() + " placed TNT!");
//	            }
//	        }
//	        if(BlockBedrock == true){
//	            if(event.getBlock().getType() == Material.BEDROCK) {
//	            event.setCancelled(true);
//	            event.getPlayer().sendMessage("You tried to place BEDROCK, which is not allowed!");
//	            log.info(event.getPlayer().getDisplayName().toString() + " placed BEDROCK!");
//	            }
//	        }
//	        if(BlockFire == true){
//	            if(event.getBlock().getType() == Material.FIRE) {
//	            event.setCancelled(true);
//	            event.getPlayer().sendMessage("You tried to place FIRE, which is not allowed!");
//	            log.info(event.getPlayer().getDisplayName().toString() + " placed FIRE!");
//	            }
//	        }
//	       
//	    }
		@EventHandler
	    public void bucketWatchdog(PlayerBucketEmptyEvent event) {
	        //if(BlockLava == true){
	            if(event.getBucket() == Material.LAVA_BUCKET) {
	                event.setCancelled(true);
	                event.getPlayer().sendMessage("You tried to place LAVA, which is not allowed!");
	                log.info(event.getPlayer().getDisplayName().toString() + " placed LAVA!");
	        		log.info("No LAVA!" );
	        		Bukkit.broadcastMessage("DONT place LAVA " + event.getPlayer().getName());

	    			Player teacher = Bukkit.getPlayer("cndrbrbr");
	    			
	    			if (teacher != null) {
	    				event.getPlayer().teleport(teacher.getLocation());
	    			}
	    			else {
	    				event.getPlayer().teleport(new Location(event.getPlayer().getWorld(),-333,81,-115));
	    			}       		
	        		
	        		
	            }
	       // }
//	        if(BlockWater == true){
//	            if(event.getBucket() == Material.WATER_BUCKET){
//	                event.setCancelled(true);
//	                event.getPlayer().sendMessage("You tried to place WATER, which is not allowed!");
//	                log.info(event.getPlayer().getDisplayName().toString() + " placed WATER!");
//	            }
//	        }
	    }
		@EventHandler
		public void onChat(AsyncPlayerChatEvent e)
		{
//		      on.sendMessage(e.getMessage().replaceAll(on.getName(), ChatColor.GREEN + "@" + ChatColor.UNDERLINE + on.getName()));
//		      on.playNote(on.getLocation(), Instrument.PIANO, Note.natural(1, Tone.A));
			log.info("Chat " + e.getMessage());

			e.setCancelled(true);
		}
		
//		@Override
//		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
//		{
//			this.getLogger().info("Activted "+ cmd.getName() + " for " + sender);
//			return false;
//		}
	
}

	









