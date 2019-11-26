package net.zminee.caixas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.zminee.caixas.json.JSONChatExtra;
import net.zminee.caixas.json.JSONChatHoverEventType;
import net.zminee.caixas.json.JSONChatMessage;
 
public class CaixaMisteriosa implements Listener{
 
    private static List<ItemStack> premios = new ArrayList<ItemStack>();
    private static List<ItemStack> vidros = new ArrayList<ItemStack>();
 
    public static void setItems(){
        premios.add(Criar.add(Material.DIAMOND_SWORD, "", Enchantment.DAMAGE_ALL, 10));
        premios.add(Criar.add(Material.DIAMOND_CHESTPLATE, "§cPeitoral OP", Enchantment.PROTECTION_ENVIRONMENTAL, 10));
        premios.add(Criar.add(Material.DIAMOND_HELMET, "§b§lCAPACETE§c§l P4", Enchantment.PROTECTION_ENVIRONMENTAL, 4));
        premios.add(Criar.add(Material.DIAMOND_CHESTPLATE, "§b§lPEITORAL§c§l P4", Enchantment.PROTECTION_ENVIRONMENTAL, 4));
        premios.add(Criar.add(Material.DIAMOND_LEGGINGS, "§b§lCALCA§c§l P4", Enchantment.PROTECTION_ENVIRONMENTAL, 4));
        premios.add(Criar.add(Material.DIAMOND_BOOTS, "§b§lBOTA§c§l P4", Enchantment.PROTECTION_ENVIRONMENTAL, 4));
        premios.add(Criar.add(Material.DIAMOND_HELMET, "§b§lCAPACETE§c§l P5", Enchantment.PROTECTION_ENVIRONMENTAL, 5));
        premios.add(Criar.add(Material.DIAMOND_CHESTPLATE, "§b§lPEITORAL§c§l P5", Enchantment.PROTECTION_ENVIRONMENTAL, 5));
        premios.add(Criar.add(Material.DIAMOND_LEGGINGS, "§b§lCALCA§c§l P5", Enchantment.PROTECTION_ENVIRONMENTAL, 5));
        premios.add(Criar.add(Material.DIAMOND_BOOTS, "§b§lBOTA§c§l P5", Enchantment.PROTECTION_ENVIRONMENTAL, 5));
        premios.add(Criar.add(Material.DIAMOND_BLOCK, "§b§lDIAMOND BLOCK" , 16 , ""));
        premios.add(Criar.add(Material.GOLD_BLOCK, "§b§lGOLD BLOCK" , 32 , ""));
        premios.add(Criar.add(Material.IRON_BLOCK, "§b§lIRON BLOCK"  , 64 , ""));
        premios.add(Criar.add(Material.GOLDEN_APPLE, 16, 1));
        premios.add(Criar.add(Material.GOLDEN_APPLE, 16, 0));
        premios.add(Criar.add(Material.DIAMOND_SWORD, "§b§lESPADA§c§l AFIADA 6" , Enchantment.DAMAGE_ALL , 6));
        
    }
    
    public static void setVidros() {
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE, 1, 13));
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE, 1, 5));
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE, 1, 15));
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE, 1, 4));
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE, 1, 14));
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE, 1, 1));
    	vidros.add(Criar.add(Material.STAINED_GLASS_PANE));
   
    }
 
    private static int foguete;
    public static void AbrirCaixa(final Player p){
 
        new BukkitRunnable() {
            int rotacao = 0;
            @Override
            public void run() {
                rotacao++;
                if (rotacao <= 20){
                    Inventory inv = Bukkit.createInventory(null, 4*9, "§8Sorteando item..");
                    ItemStack hopper = new ItemStack(Material.HOPPER);
                    ItemMeta meta = hopper.getItemMeta();
                    meta.setDisplayName("§6Sorteando..");
                    hopper.setItemMeta(meta);
                    
                    inv.setItem(4, hopper);
                    
                    
                    ItemStack chest = new ItemStack(Material.CHEST);
                    ItemMeta meta2 = chest.getItemMeta();
                    meta2.setDisplayName("§6Sorteando..");
                    chest.setItemMeta(meta2);
                    
                    inv.setItem(22, chest);
                    inv.setItem(24, chest);
                    
                    ItemStack star = new ItemStack(Material.NETHER_STAR);
                    ItemMeta meta3 = star.getItemMeta();
                    meta3.setDisplayName("§6Sorteando..");
                    star.setItemMeta(meta3);
                    
                    inv.setItem(23, star);
                    
                    for (int i = 10; i < 17 ; i++){
                        ItemStack items = premios.get(new Random().nextInt(premios.size()));
                        inv.setItem(i, items);
                    }
                    
                    for (int i = 0; i < 3 ; i++){
                        ItemStack items = vidros.get(new Random().nextInt(vidros.size()));
                        inv.setItem(i, items);
                    }

                    for(int i = 5; i < 9; i++) {
                    	ItemStack items3 = vidros.get(new Random().nextInt(vidros.size()));
                    	inv.setItem(i, items3);
                    }
                    for(int i = 18; i < 21; i++) {
                    	ItemStack items4 = vidros.get(new Random().nextInt(vidros.size()));
                    	inv.setItem(i, items4);
                    }
                    for(int i = 25; i < 36; i++) {
                    	ItemStack items5 = vidros.get(new Random().nextInt(vidros.size()));
                    	inv.setItem(i, items5);
                    }
                    p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
                    p.openInventory(inv);
                }
                if (rotacao == 21){
                    Inventory inv = Bukkit.createInventory(null, 9, "§8Item sorteado!");
                    ItemStack items = premios.get(new Random().nextInt(premios.size()));
                    for (int i = 0; i < inv.getSize(); i++){
                        inv.setItem(i, items);
                    }
                    p.getInventory().addItem(items);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
                    p.openInventory(inv);
            		for(Player player: Bukkit.getOnlinePlayers()) {
                		

                			JSONChatMessage texto = new JSONChatMessage("   ", null, null);
                			
                			JSONChatExtra item = new JSONChatExtra("§7 "
                					+ "\n"
                					+ "§6§l[CM] §aO jogador " + p.getName() + "§a ganhou um item §6§lÉPICO §ana caixa."
                					+ "\n"
                					+ "§7 ");
                			item.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, items.getItemMeta().getDisplayName());
                			texto.addExtra(item);
                			texto.sendToPlayer(player);
                		
            		}
                    foguete = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
                        int tanto = 0;
                        public void run() {
                            tanto++;
                            if (tanto <= 5){
                                p.getWorld().spawn(p.getLocation(), Firework.class);
                            }
                           
                            if (tanto == 6){
                                Bukkit.getScheduler().cancelTask(foguete);
                            }
                        }
                    }, 0L, 5L);
                }
            }
 
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 5L);
 
    }
   
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (!(e.getWhoClicked() instanceof Player)) return;
        if (e.getInventory().getTitle().equals("§8Sorteando item..")){
            return;
        }
        if(e.getInventory().getTitle().equals("Item sorteado!")) {
        	return;
        }
    }
   
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (!premios.contains(p.getName())){
            Comando.caixa.set(p.getName() + ".Keys", 0);
            Comando.caixa.saveConfig();
        }
    }
 
}
