package de.telran.hw_2024_09_02.task1;

public class MonthsSeasonDiet {
    public static void getDiet(MonthsEnum month){
        String season = "";
        switch (month){
// Winter more vegetables and meat
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                season = "Зима ";
                break;
// Spring more
            case MARCH:
            case APRIL:
            case MAY:
                season = "Весна ";
                break;
// Summer more
            case JUNE:
            case JULY:
            case AUGUST:
                season = "Лето ";
                break;
// Autumn more
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                season = "Осень ";
                break;
        }
        System.out.print(season + month.getTitle() + ", кушаем больше - ");
        System.out.println(getFoodRecommendation(month));

    }

    private static String getFoodRecommendation(MonthsEnum month){
        String food = "";
        switch (month){
// Winter more vegetables and meat
            case DECEMBER:
                food = "картофель с мясом.";
                break;
            case JANUARY:
                food = "заготовки, соленья, варенья.";
                break;
            case FEBRUARY:
                food = "макароны с сосисками.";
                break;
// Spring more
            case MARCH:
                food = "свежую зелень.";
                break;
            case APRIL:
                food = "свежие салаты";
                break;
            case MAY:
                food = "свежие огуры, помидоры.";
                break;
// Summer more
            case JUNE:
                food = "клубнику.";
                break;
            case JULY:
                food = "экзотические фрукты.";
                break;
            case AUGUST:
                food = "свежую картошку.";
                break;
// Autumn more
            case SEPTEMBER:
                food = "грибы и ягоды.";
                break;
            case OCTOBER:
                food = "кашу.";
                break;
            case NOVEMBER:
                food = "суп из овошей с мясом.";
                break;
        }
        return food;
    }
}
