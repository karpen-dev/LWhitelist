package com.karpen.lWhitelist.listeners;

import com.karpen.lWhitelist.services.ListManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainListeners implements Listener {

    private ListManager manager;

    public MainListeners(ListManager manager){
        this.manager = manager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if (manager.getUser(player.getName()) == null) {
            player.kickPlayer(ChatColor.RED + "Чтобы играть на сервере подай заявку lastvibe.ru/ds");

            return;
        }

        if (manager.getUser(player.getName()).isBaned()){
            player.kickPlayer(ChatColor.RED + "Вы были забанены, причина lastvibe.ru/bans");

            return;
        }

        if (!manager.getUser(player.getName()).isAccess()){
            player.kickPlayer(ChatColor.RED + "Чтобы играть на сервере подай заявку lastvibe.ru/ds");

            return;
        }
    }
}
