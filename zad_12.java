public class zad_12 {
    public static void main(String[] args) {
        MyMass arr = new MyMass();
        String[] messages = arr.GetStrMas();
        replaces(messages);
    }

    public static void replaces (String[] messages) {
        String[] patterns = {"[бБ]удем говорить", "[нН]у", "[тТ]уто", "[Кк]ороче", "[Тт]ипа"};
        String[] sleng = {"[кК]ат[ак][а-я]+","[кК]ек[а-я]+","[кК]раш[а-я]*","[лЛ]ол[а-я]*",
                "[нН]уб[а-я]*","ОМГ", "[Сс]трим[а-я]*","[фФ]лекс[а-я]*",
                "[чЧ]ил[а-я]*","[пП]адр[а-я]+","[дД]нокл[а-я]*"};
        for(String message: messages){
            System.out.println("Исходный текст: " + message);
            message = message.replaceAll("\\s{2,}"," ");
            String[] words = message.split("\\s+");
            for(String pattern: patterns){
                message = message.replaceAll(pattern+"[.,!?]?\\s*", "");
            }
            words = message.split("\\s+");
            for (String word: words) {
                String clearWord = word.replaceAll("[^А-Яа-я]", "");
                message = message.replaceAll(clearWord + ",?\\s+,?" + clearWord, clearWord);
                message = message.replaceAll(clearWord.substring(0,1).toUpperCase()
                        + clearWord.substring(1) + ",?\\s+,?" + clearWord, clearWord);
                message = message.replaceAll(clearWord + ",?\\s+,?" + clearWord.substring(0,1).toUpperCase()
                        + clearWord.substring(1), clearWord.substring(0,1).toUpperCase()
                        + clearWord.substring(1));
            }
            words = message.split("\\s+");
            String NEWmessage = "";
            for (int i = 0; i < words.length;i++){
                String word = words[i];
                if (word.equals(words[0])){
                    word = word.substring(0,1).toUpperCase() + word.substring(1);
                } else if(words[i-1].charAt(words[i-1].length()-1) == '.' ||
                        words[i-1].charAt(words[i-1].length()-1) == '?' ||
                        words[i-1].charAt(words[i-1].length()-1) == '!') {
                    word = word.substring(0,1).toUpperCase() + word.substring(1);
                }
                String clearWord = word.replaceAll("[^А-Яа-я]", "");
                word = word.replaceAll(sleng[0],clearWord+"(играть)");
                word = word.replaceAll(sleng[1],clearWord+"(смеяться)");
                word = word.replaceAll(sleng[2],clearWord+"(пример подражания)");
                word = word.replaceAll(sleng[3],clearWord+"(очень смешно)");
                word = word.replaceAll(sleng[4],clearWord+"(новичек)");
                word = word.replaceAll(sleng[5],clearWord+"(крайнее удивление)");
                word = word.replaceAll(sleng[6],clearWord+"(трансляция)");
                word = word.replaceAll(sleng[7],clearWord+"(быть увлеченным)");
                word = word.replaceAll(sleng[8],clearWord+"(отдых)");
                word = word.replaceAll(sleng[9],clearWord+"(подруга)");
                word = word.replaceAll(sleng[10],clearWord+"(одноклассник)");
                NEWmessage += word+" ";
            }
            for (String word: NEWmessage.split("\\s+")){
                String clearWord = word.replaceAll("[^А-Яа-я]", "");
                NEWmessage = NEWmessage.replaceAll(clearWord+",?\\s*[А-Яа-я]*\\)?\\s+,?"+clearWord, clearWord);
                NEWmessage = NEWmessage.replaceAll(clearWord.substring(0,1).toUpperCase()+",?[А-Яа-я]*\\)?\\s+,?"
                        +clearWord.toLowerCase(), clearWord);
            }
            System.out.println("Исправленный текст: "+NEWmessage);
        }

    }

}
