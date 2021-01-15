package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DirectorTablet {
   public void printAdvertisementProfit(){
      Map<String, Double> mapProfitReverse = StatisticManager.getInstance().totalProfit();
      double totalProfit = 0;
      for (String date : mapProfitReverse.keySet()){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(date);
         stringBuilder.append(" - ");
         stringBuilder.append(new DecimalFormat("0.00").format(mapProfitReverse.get(date)).replaceAll(",", "."));
         ConsoleHelper.writeMessage(stringBuilder.toString());
         totalProfit += mapProfitReverse.get(date);
      }
      ConsoleHelper.writeMessage("Total - " + new DecimalFormat("#0.00")
              .format(totalProfit)
              .replaceAll(",", "."));
   }


   public void printCookWorkloading(){
      Map<String, Map<String, Integer>> resultMap = StatisticManager.getInstance().cookWork();
      for (String date : resultMap.keySet()){
         ConsoleHelper.writeMessage(date);
         Map<String, Integer> cookMap = resultMap.get(date);
         for (String cookName : cookMap.keySet()){
            if (cookMap.get(cookName) != 0) {
               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(cookName);
               stringBuilder.append(" - ");
               stringBuilder.append(cookMap.get(cookName));
               stringBuilder.append(" min");
               ConsoleHelper.writeMessage(stringBuilder.toString());
            }
         }
         ConsoleHelper.writeMessage("");
      }
   }


   public void printActiveVideoSet(){
      List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveAd();
      for (Advertisement advertisement : list){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(advertisement.getName());
         stringBuilder.append(" - ");
         stringBuilder.append(advertisement.getHits());
         ConsoleHelper.writeMessage(stringBuilder.toString());
      }
      ConsoleHelper.writeMessage("");
   }


   public void printArchivedVideoSet(){
      List<Advertisement> list = StatisticAdvertisementManager.getInstance().getPassiveAd();
      list.sort(new Comparator<Advertisement>() {
         @Override
         public int compare(Advertisement o1, Advertisement o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
         }
      });
      for (Advertisement advertisement : list){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(advertisement.getName());
         ConsoleHelper.writeMessage(stringBuilder.toString());
      }
      ConsoleHelper.writeMessage("");
   }
}
