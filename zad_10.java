import java.text.SimpleDateFormat;
import java.util.Date;

public class zad_10 {
    public static void main(String[] args) {
        String text = "Иванов;Иван;Иванович;М;Украинец;180;75;1986,3,12;+380971234567;Динамо;9;нападающий;30;100." +
                "Петров;Петр;Петрович;М;Русский;175;70;1987,5,23;+380931234565;Шахтер;5;защитник;5;70." +
                "Сидоров;Сергей;Александрович;М;Белорус;190;90;1988,8,5;+375291234564;Динамо;2;вратарь;0;20." +
                "Коваленко;Ольга;Николаевна;Ж;Украинка;170;65;1990,1,20;+380991234563;Спартак;8;полузащитник;15;70." +
                "Шевченко;Андрей;Михайлович;М;Украинец;185;80;1976,9,29;+380631234566;Милан;7;нападающий;120;300.";
        String[] persons = text.split("\\.");
    /* индексы info
    0 - фамилия
    1 - имя
    2 - отчество
    3 - пол
    4 - национальность
    5 - рост
    6 - вес
    7 - год, месяц, день
    8 - номер
    9 - команда
    10 - номер в команде
    11 - амплуа
    12 - кол-во голов
    13 - кол-во игр
     */
        int countNum = 0;
        Date date = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy/MM/dd/");
        String[] NowDate = DateFormat.format(date).split("/");
        System.out.println("Спортсмены с более 50 игр и более 20 голов: ");
        for (String persInfo: persons){
            String[] info = persInfo.split(";");
            String[] BF = info[7].split(",");
            int year;
            if ((Integer.parseInt(NowDate[1]) >= Integer.parseInt(BF[1])) &&
                    (Integer.parseInt(NowDate[2]) >= Integer.parseInt(BF[2]))){
                year = Integer.parseInt(NowDate[0]) - Integer.parseInt(BF[0]);
            } else {
                year = Integer.parseInt(NowDate[0]) - Integer.parseInt(BF[0]) - 1;
            }
            if (info[8].matches("\\+38\\d+"+String.valueOf(year%10))){
                countNum++;
            }
            if (Integer.parseInt(info[13]) > 50 && Integer.parseInt(info[12]) > 20){
                System.out.println(persInfo);
            }
        }
        System.out.printf("\nВсего %d спортсменов имет номер начинающийся с +38 и заканчивающиеся последней цифрой возраста",countNum);
    }
}
