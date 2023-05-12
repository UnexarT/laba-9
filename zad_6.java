import java.util.Scanner;

public class zad_6 {
    public void zad_6() {
        Scanner scn = new Scanner(System.in);
        String[] stats = {"Страна коллектива","Город коллектива","Стиль","Название коллектива",
                "Наличие солиста", "Возраст солиста","Количество участников",
                "Количество участников младше 21 года",
                "Количество участников с музыкальным образованием",
                "Количество участников с театральным образованием",
                "Число музыкальных инструментов в собственности коллектива",
                "Средний доход коллектива от выступлений за год(млн. руб.)",
                "Наличие премий","Количество премий","Наличие дипломов",
                "Количество дипломов","Наличие грамот","Количество грамот"};
        System.out.printf("Введите количество коллективов(не менее 20): ");
        int count_teams = scn.nextInt();
        while (count_teams < 20){
            System.out.printf("Вы ввели слишком мало коллективов!\n" +
                    "Введите количество коллективов(не менее 20): ");
            count_teams = scn.nextInt();
        }
        String[] teams = new String[count_teams];
        for (int i = 0; i < teams.length; i++) {
            teams[i] = "";
        }
        System.out.printf("Какой тип ввода вы веберете?\n" +
                "1 - Регламентированный\n" +
                "2 - Нерегламентированный\nОтвет: ");
        int fl = scn.nextInt();
        while (fl > 2 || fl < 1) {
            System.out.printf("Недопустимое значение!\n" +
                    "Введите символы \"1\" или \"2\": ");
            fl = scn.nextInt();
        }
        switch (fl) {
            case 1:
                RegInput(teams,stats);
            case 2:
                NotRegInput(teams,stats);
        }

    }
    public static void Check(String[] teams){
        String countries = "";
        int count1 = 0, count2 = 0;
        for(String team: teams){
            String[] facts = team.split(";");
            if ((Integer.parseInt(facts[8])*100/Integer.parseInt(facts[6])) >= 40 &&
                    (Integer.parseInt(facts[9])*100/Integer.parseInt(facts[6])) <= 10 &&
                    Integer.parseInt(facts[15]) <= 5 && Integer.parseInt(facts[13]) >= 1 &&
                    Integer.parseInt(facts[17]) >= 3){
                count1++;
            }
            if (!countries.matches(".*"+ facts[0] + ".*")){
                countries += facts[0]+";";
            }
        }
        System.out.println("Результаты первого условия(среди всех команд): "+count1);
        for(String country: countries.split(";")){
            String styles = "";
            for(String team: teams){
                String[] facts = team.split(";");
                if (team.matches(".*"+country+".*") && !styles.matches(".*"+facts[2].toLowerCase()+".*")){
                    styles += facts[2].toLowerCase()+";";
                    if (Integer.parseInt(facts[7]) >= 1 && Integer.parseInt(facts[11]) > 5){
                        count2++;
                    }
                }
            }
        }
        System.out.println("Результаты второго условия(по странам): "+count2);

    }

    public static void RegInput(String[] text, String[] stats) {
        System.out.printf("\nВведите данные о командах в массив строк.");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < text.length; i++){
            System.out.printf("\nКоманда №%d:\n",i+1);
            for(String stat: stats){
                System.out.printf(stat+": ");
                text[i] += scn.next()+";";
            }
        }
        Check(text);
    }
    public static void NotRegInput(String[] text, String[] stats) {
        String[] facts = new String[18];
        Scanner scn = new Scanner(System.in);
        int count = 0;
        for(String info: stats){
            count++;
            System.out.printf("\n%d) %s",count,info);
        }
        System.out.printf("\n\n");
        for (int i = 0; i < text.length; i++){
            for (int j = 0; j < facts.length; j++) {
                facts[j] = "";
            }
            System.out.printf("\nКоманда №%d:\n",i+1);
            for(int j = 0; j < 18;j++){
                System.out.printf("Выберите заполняемые данные: ");
                int num = scn.nextInt();
                while(((num > 18) || (num < 1)) || !(facts[num-1].equals(""))) {
                        System.out.printf("Введено недопустимое значение! Введите заново: ");
                        num = scn.nextInt();
                }
                System.out.printf("%s: ", stats[num-1]);
                facts[num - 1] = scn.next();
            }
            for(String fact: facts){
                text[i] += fact+";";
            }
        }
        Check(text);
    }
}
