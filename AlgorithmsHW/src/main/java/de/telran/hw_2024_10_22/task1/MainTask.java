package de.telran.hw_2024_10_22.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainTask {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("a",3,10));
        tasks.add(new Task("b",2,8));
        tasks.add(new Task("c",1,5));
        tasks.add(new Task("d",3,11));
        tasks.add(new Task("e",4,15));
        tasks.add(new Task("f",2,10));
        tasks.add(new Task("g",5,17));
        tasks.add(new Task("h",1,4));
        tasks.add(new Task("i",1,6));
        tasks.add(new Task("j",1,4));
        tasks.add(new Task("k",1,4));

        int maxTime = 11; //сколько времени я могу уделить

        System.out.println("\nКритерий макс сумма = "+taskSelectionCost(tasks, maxTime));
        System.out.println("\nКритерий макс сумма (Improved) = "+taskSelectionCostImproved(tasks, maxTime));

        System.out.println("\nКритерий удельная цена  (стоимость / время) = "+taskSelectionRealCost(tasks, maxTime));
        System.out.println("\nКритерий удельная цена  (стоимость / время) (improved) = "+taskSelectionRealCostImproved(tasks, maxTime));

        System.out.println("\nКритерий (макс количество задач) = "+taskSelectionTime(tasks, maxTime));
        System.out.println("\nКритерий (макс количество задач) reversed = "+taskSelectionTimeReverse(tasks, maxTime));
        System.out.println("\nКритерий (макс количество задач) reversed (improved) = "+taskSelectionTimeReverseImproved(tasks, maxTime));

    }

    public static List<Task> taskSelectionTime(List<Task> tasks, int maxTime) {
        System.out.println();
        tasks.sort(Comparator.comparingInt(Task::getTime));
        System.out.println("--taskSelectionTime: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            totalTime += t.getTime();
            if(totalTime <= maxTime) {
                res.add(t);
            }
            else {
                break;
            }
        }
        return res;
    }

    public static List<Task> taskSelectionCost(List<Task> tasks, int maxTime) {
        //System.out.println();
        tasks.sort(Comparator.comparingInt(Task::getCost).reversed());
        //System.out.println("--taskSelectionCost: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            totalTime += t.getTime();
            if(totalTime <= maxTime) {
                res.add(t);
            }
            else {
                break;
            }
        }
        return res;
    }

    public static List<Task> taskSelectionRealCost(List<Task> tasks, int maxTime) { //удельная цена за единицу времени
        //System.out.println();
        tasks.sort((a,b)->{
            float aCost = (float)a.getCost()/a.getTime();
            float bCost = (float)b.getCost()/b.getTime();
            if(aCost > bCost) return -1;
            else if(aCost < bCost) return 1;
            else return 0;
        });
        //System.out.println("--taskSelectionRealCost: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            totalTime += t.getTime();
            if(totalTime <= maxTime) {
                res.add(t);
            }
            else {
                break;
            }
        }
        return res;
    }

    // added !!!
    public static List<Task> taskSelectionTimeReverse(List<Task> tasks, int maxTime) {
        //System.out.println();
        tasks.sort(Comparator.comparingInt(Task::getTime).reversed());
        //System.out.println("--taskSelectionTimeReverse: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            totalTime += t.getTime();
            if(totalTime <= maxTime) {
                res.add(t);
            }
            else {
                break;
            }
        }
        return res;
    }

    public static List<Task> taskSelectionTimeReverseImproved(List<Task> tasks, int maxTime) {
        //System.out.println();
        tasks.sort(Comparator.comparingInt(Task::getTime).reversed());
        //System.out.println("--taskSelectionTimeReverse: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            if(totalTime + t.getTime() <= maxTime) {
                totalTime += t.getTime();
                res.add(t);
            }
            if (totalTime == maxTime){
                break;
            }
        }
        return res;
    }

    public static List<Task> taskSelectionCostImproved(List<Task> tasks, int maxTime) {
        //System.out.println();
        tasks.sort(Comparator.comparingInt(Task::getCost).reversed());
        //System.out.println("--taskSelectionCost: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            if(totalTime + t.getTime() <= maxTime) {
                totalTime += t.getTime();
                res.add(t);
            }
            if (totalTime == maxTime){
                break;
            }
        }
        return res;
    }

    public static List<Task> taskSelectionRealCostImproved(List<Task> tasks, int maxTime) { //удельная цена за единицу времени
        //System.out.println();
        tasks.sort((a,b)->{
            float aCost = (float)a.getCost()/a.getTime();
            float bCost = (float)b.getCost()/b.getTime();
            if(aCost > bCost) return -1;
            else if(aCost < bCost) return 1;
            else return 0;
        });
        //System.out.println("--taskSelectionRealCost: " + tasks);
        int totalTime = 0;
        List<Task> res = new ArrayList<>();
        for(Task t : tasks) {
            if(totalTime + t.getTime() <= maxTime) {
                totalTime += t.getTime();
                res.add(t);
            }
            if (totalTime == maxTime){
                break;
            }
        }
        return res;
    }

}
