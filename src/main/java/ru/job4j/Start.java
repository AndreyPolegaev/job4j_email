package ru.job4j;

import java.util.*;

public class Start {
    private String name;
    private String email;

    Map<String, String[]> emailPersonMap = new HashMap<>();
    List<User> listUser = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    private void add() {
        boolean menu = true;
        while (menu) {
            listUser.forEach(System.out::println);
            this.showMenu();
            int value = Integer.parseInt(in.nextLine());
            if (value == 0) {
                menu = false;
                System.out.println(listUser);
                rsl();
            } else if (value == 1) {
                createUser();
            }
        }

    }

    void rsl() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < listUser.size(); i++) {
            List<String> list = listUser.get(i).getEmails();
            for (int j = 1; j < listUser.size() - 1; j++) {
                List<String> list2 = listUser.get(j).getEmails();
                if (!Collections.disjoint(list, list2)) {
                    set.addAll(list);
                    set.addAll(list2);
                    list.addAll(list2);
                    listUser.get(j).getEmails().clear();
                    String[] data = set.toArray(new String[0]);
                    emailPersonMap.put(listUser.get(i).getName(), data);
                }
            }
            set.clear();
        }
        emailPersonMap.forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(Arrays.toString(v));
                    System.out.println();
                }
        );
    }

    private void createUser() {
        String userName = "";
        List<String> emailList = new ArrayList<>();
        System.out.println("Введите нового пользователя -  перейти в главное меню - 0");
        userName = in.nextLine();
        if (userName.equals("0")) {
            return;
        }
        User user = new User(userName, emailList);  // создаем юзера
        listUser.add(user);
        boolean run = true;
        while (run) {
            System.out.println("введите Email - вернуться в главное меню введите E");
            String email = in.nextLine();
            if (email.equals("E")) {
                break;
            }
            emailList.add(email);
        }
    }

    private void showMenu() {
        System.out.println(
                "1 - создать нового пользователя \n"
                        + "0 - Выйти и показать результат"
        );
    }

    public static void main(String[] args) {
        new Start().add();
    }
}