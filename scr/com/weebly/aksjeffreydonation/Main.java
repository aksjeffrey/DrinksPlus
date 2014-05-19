/*     */ package com.weebly.aksjeffreydonation;
/*     */ 
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */  public class Main extends JavaPlugin
/*     */   implements Listener
/*     */ {
/*     */   public void onEnable()
/*     */   {
/*  23 */     getConfig().options().copyDefaults(true);
/*  24 */     saveConfig();
/*  25 */     getServer().getPluginManager().registerEvents(this, this);
/*     */   }
/*     */ 
/*     */   public void onDisable()
/*     */   {
/*     */   }
/*     */ 
/*     */   @EventHandler
/*     */   public boolean PlayerInteract(PlayerInteractEvent event) {
/*  34 */     Player p = event.getPlayer();
/*  35 */     PlayerInventory inventory = p.getInventory();
/*  36 */     ItemStack bucket = new ItemStack(Material.BUCKET);
/*  37 */     if ((p.getItemInHand().getType().equals(Material.LAVA_BUCKET)) && (p.hasPermission("drink.lava")) && 
/*  38 */       (event.getAction().equals(Action.RIGHT_CLICK_AIR))) {
/*  39 */       inventory.setItemInHand(bucket);
/*     */ 
/*  41 */       p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(getConfig().getString("lava-effect")), getConfig().getInt("lava-duration"), getConfig().getInt("lava-amplifier")));
/*  42 */       p.sendMessage("You drank " + ChatColor.RED + "lava" + ChatColor.WHITE + ".");
/*  43 */       return true;
/*     */     }
/*     */ 
/*  46 */     if ((p.getItemInHand().getType().equals(Material.WATER_BUCKET)) && (p.hasPermission("drink.water")) && 
/*  47 */       (event.getAction().equals(Action.RIGHT_CLICK_AIR))) {
/*  48 */       inventory.setItemInHand(bucket);
/*     */ 
/*  50 */       p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(getConfig().getString("water-effect")), getConfig().getInt("water-duration"), getConfig().getInt("water-amplifier")));
/*  51 */       p.sendMessage("You drank " + ChatColor.BLUE + "water" + ChatColor.WHITE + ".");
/*  52 */       return true;
/*     */     }
/*     */ 
/*  55 */     if ((p.getItemInHand().getType().equals(Material.MILK_BUCKET)) && (p.hasPermission("drink.milk")) && 
/*  56 */       (event.getAction().equals(Action.RIGHT_CLICK_AIR))) {
/*  57 */       inventory.getItemInHand().setType(Material.BUCKET);
/*     */ 
/*  59 */       p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(getConfig().getString("milk-effect")), getConfig().getInt("milk-duration"), getConfig().getInt("milk-amplifier")));
/*  60 */       p.sendMessage("You drank " + ChatColor.GRAY + "milk" + ChatColor.WHITE + ".");
/*  61 */       return true;
/*     */     }
/*     */ 
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*     */   {
/*  69 */     if (!(sender instanceof Player)) {
/*  70 */       sender.sendMessage(ChatColor.RED + "The console can't drink!");
/*     */     }
/*     */ 
/*  73 */     Player player = (Player)sender;
/*  74 */     PlayerInventory inventory = player.getInventory();
/*  75 */     ItemStack bucket = new ItemStack(Material.BUCKET);
/*     */ 
/*  77 */     if ((cmd.getName().equalsIgnoreCase("drink")) && (player.hasPermission("drink.lava"))) {
/*  78 */       if (inventory.getItemInHand().getType() == Material.LAVA_BUCKET) {
/*  79 */         inventory.setItemInHand(bucket);
/*     */ 
/*  81 */         player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(getConfig().getString("lava-effect")), getConfig().getInt("lava-duration"), getConfig().getInt("lava-amplifier")));
/*  82 */         player.sendMessage("You drank " + ChatColor.RED + "lava" + ChatColor.WHITE + ".");
/*  83 */         return true;
/*     */       }
/*  85 */       if ((inventory.getItemInHand().getType() == Material.WATER_BUCKET) && (player.hasPermission("drink.water"))) {
/*  86 */         inventory.setItemInHand(bucket);
/*     */ 
/*  88 */         player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(getConfig().getString("water-effect")), getConfig().getInt("water-duration"), getConfig().getInt("water-amplifier")));
/*  89 */         player.sendMessage("You drank " + ChatColor.BLUE + "water" + ChatColor.WHITE + ".");
/*  90 */         return true;
/*     */       }
/*  92 */       if ((inventory.getItemInHand().getType() == Material.MILK_BUCKET) && (player.hasPermission("drink.milk"))) {
/*  93 */         inventory.setItemInHand(bucket);
/*     */ 
/*  95 */         player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(getConfig().getString("milk-effect")), getConfig().getInt("milk-duration"), getConfig().getInt("milk-amplifier")));
/*  96 */         player.sendMessage("You drank " + ChatColor.GRAY + "milk" + ChatColor.WHITE + ".");
/*  97 */         return true;
/*     */       }
/*  99 */       if (inventory.getItemInHand().getType() == Material.BUCKET) {
/* 100 */         player.sendMessage("That bucket is empty!");
/* 101 */         return true;
/*     */       }
/* 103 */       if ((inventory.getItemInHand().getType() != Material.LAVA_BUCKET) || (inventory.getItemInHand().getType() != Material.WATER_BUCKET) || (inventory.getItemInHand().getType() != Material.MILK_BUCKET) || (inventory.getItemInHand().getType() != Material.BUCKET)) {
/* 104 */         player.sendMessage("You don't have a drink!");
/* 105 */         return true;
/*     */       


	

}
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ }

/* Location:           /Users/Bhavneet/Documents/Drinks___v1.0__1.7.2__beta.jar
 * Qualified Name:     com.weebly.aksjeffreydonation.Main
 * JD-Core Version:    0.6.2
 */
