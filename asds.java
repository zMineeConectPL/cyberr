package net.zminee.scoreboard;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.killrank.managers.PlayerRank;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

public class Score implements Listener{
	SimpleClans sc = SimpleClans.getInstance();
	public static Score s;
	
	protected void run() {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				for (Player players : Bukkit.getOnlinePlayers()) {
					updateScore(players.getScoreboard(), players);
				}
			}
		}.runTaskTimer(Main.m, 0, 5);
	}
	
	public void build(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = score.registerNewObjective("scoreboard", "dummy");
		obj.setDisplayName("§6§lFULLPVP RAIZ");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		// LINHA VAZIA
		FastOfflinePlayer lvazia1 = new FastOfflinePlayer(ChatColor.AQUA + "");
		FastOfflinePlayer lvazia2 = new FastOfflinePlayer(ChatColor.BOLD + "");
		FastOfflinePlayer lvazia3 = new FastOfflinePlayer(ChatColor.GOLD + "");
		FastOfflinePlayer lvazia4 = new FastOfflinePlayer(ChatColor.BLUE + "");
		
		
		if(!Main.m.hasClan(p)) {
		obj.getScore(lvazia1).setScore(1);
		obj.getScore(lvazia2).setScore(5);
		obj.getScore(lvazia3).setScore(7);
		obj.getScore(lvazia4).setScore(9);

		// On

		FastOfflinePlayer on = new FastOfflinePlayer(ChatColor.WHITE + " Online: §a");
		obj.getScore(on).setScore(8);


		// semclan
		FastOfflinePlayer semclan = new FastOfflinePlayer(" §cAtualmente sem clã.");
		obj.getScore(semclan).setScore(6);

		// nv
		FastOfflinePlayer nivel = new FastOfflinePlayer(ChatColor.WHITE + " Nível: §a" + PlayerRank.get(p).getRank());
		obj.getScore(nivel).setScore(4);

		// coins
		
		
		
		FastOfflinePlayer lcoins = new FastOfflinePlayer(ChatColor.WHITE + " Coins: §a");
		obj.getScore(lcoins).setScore(3);
		
		FastOfflinePlayer lcash = new FastOfflinePlayer(ChatColor.WHITE + " Cash: §a");
		obj.getScore(lcash).setScore(2);


		// Site
		FastOfflinePlayer lsite = new FastOfflinePlayer("§cwww.cybersvbr.com");
		obj.getScore(lsite).setScore(0);
		
		
		}else {
			
				obj.getScore(lvazia1).setScore(1);
				obj.getScore(lvazia2).setScore(5);
				obj.getScore(lvazia3).setScore(9);
				obj.getScore(lvazia4).setScore(11);

				// Fase-Atual

				FastOfflinePlayer on = new FastOfflinePlayer(ChatColor.WHITE + " Online: §a");
				obj.getScore(on).setScore(10);

				// Fase
				String lclan = Main.ClanName(p);
				FastOfflinePlayer clan = new FastOfflinePlayer("§e [" + Main.ClanTag(p) + "§e] " + Main.ClanName(p));
				obj.getScore(clan).setScore(8);

				// Clan
				
				FastOfflinePlayer membros = new FastOfflinePlayer("   §fMembros: §e" + sc.getClanManager().getClanPlayer(p).getClan().getOnlineMembers().size() + "/" + sc.getClanManager().getClanPlayer(p).getClan().getMembers().size());
				obj.getScore(membros).setScore(7);

				// Vivos-Clan
				FastOfflinePlayer kdr = new FastOfflinePlayer("   §fKDR: §e" + sc.getClanManager().getClanPlayer(p).getClan().getTotalKDR());
				obj.getScore(kdr).setScore(6);

				// Abates-Clan
				FastOfflinePlayer nivel = new FastOfflinePlayer(ChatColor.WHITE + " Nível: §a" + PlayerRank.get(p).getRank());
				obj.getScore(nivel).setScore(4);

				// Abates
				FastOfflinePlayer lcoins = new FastOfflinePlayer(ChatColor.WHITE + " Coins: §a");
				obj.getScore(lcoins).setScore(3);
				
				FastOfflinePlayer lcash = new FastOfflinePlayer(ChatColor.WHITE + " Cash: §a");
				obj.getScore(lcash).setScore(2);

				// Site
				FastOfflinePlayer lsite = new FastOfflinePlayer("§cwww.cybersvbr.com");
				obj.getScore(lsite).setScore(0);
				
				
				
		}
		p.setScoreboard(score);
		
		

	}

	public void updateScore(final Scoreboard score, Player p) {
		long pontos = Main.m.playerPoints.getAPI().look(p.getName());
		Thread th = new Thread(new Runnable() {
			long coinsa = (long)Main.m.econ.getBalance(p);
			@Override
			public void run() {
		
             if(Main.m.hasClan(p)) {
            	 

                
            	 
            	 SimpleClans sc = SimpleClans.getInstance();
            	 
            	 Team on = score.getTeam("line10");
            	 on.setSuffix(Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
            	 
            	 Team clan = score.getTeam("line8");
            	 clan.setSuffix("[" +sc.getClanManager().getClanPlayer(p).getClan().getColorTag() + "§e] " + Main.m.ClanName(p));
            	 
            	 Team ckdr = score.getTeam("line7");
            	 ckdr.setSuffix("" + sc.getClanManager().getClanPlayer(p).getClan().getTotalKDR());
            	 
            	 Team con = score.getTeam("line6");
            	 con.setSuffix("" + sc.getClanManager().getClanPlayer(p).getClan().getOnlineMembers().size() + "/" + sc.getClanManager().getClanPlayer(p).getClan().getMembers().size());
            	 
            	 Team nivel = score.getTeam("line4");
            	 nivel.setSuffix(PlayerRank.get(p).getRank());
            	 
            	 Team coins = score.getTeam("lcash");
            	 coins.setSuffix(NumberFormat.getInstance().format(coinsa));
            	 
            	 Team cash = score.getTeam("lsite");
            	 cash.setSuffix(NumberFormat.getInstance().format(pontos));
            	 
             }else {
            	 
            	 
            	 Team on2 = score.getTeam("on");
            	 on2.setSuffix(Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
            	 
            	 Team nivel2 = score.getTeam("line4");
            	 nivel2.setSuffix(PlayerRank.get(p).getRank());
            	 
            	 Team coins2 = score.getTeam("line3");
            	 coins2.setSuffix(NumberFormat.getInstance().format(coinsa));
            	 
            	 Team cash2 = score.getTeam("line2");
            	 cash2.setSuffix(NumberFormat.getInstance().format(pontos));
            	 
             }
		}
		});
		th.start();

	}
	@EventHandler
	public void evento(PlayerJoinEvent e) {
		build(e.getPlayer());
	}

}
