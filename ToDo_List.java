package dz.oop_dz;

public class ToDo_List {

    private String[] todo;
    private int count;

    public ToDo_List() {
        this.todo = new String[5];
        this.count = 0;
    }

    public boolean add(String item) {
        if (this.count == this.todo.length) {
            return false;

        } else {
            this.todo[count] = item;
            this.count++;
            return true;
        }
    }

    public int getSize() {
        return count;
    }

    public String remove(int index) {
        if (index < 1 || index > this.count) {
            return null;

        } else {
            index--;
            String deleted = this.todo[index];

            for (int i = index; i < this.count - 1; i++) {
                this.todo[i] = this.todo[i + 1];
            }
            this.count--;
            return deleted;
        }
    }

    public String toString() {
        String output = "ДОБРО ПОЖАЛОВАТЬ В ПЛАНИРОВЩИК\n";
        for (int i = 0; i < this.count; i++) {
            output += (i + 1) + ". " + this.todo[i] + "\n";
        }
        return output;
    }

    public static void main(String[] args) {
        try (java.util.Scanner keybd = new java.util.Scanner(System.in)) {
            ToDo_List list = new ToDo_List();

            int choice = 1;
            while (choice != 0) {

                System.out.println();
                System.out.println(list);

                System.out.println("МЕНЮ:");
                System.out.println("1 - Добавить запись");
                System.out.println("2 - Удалить последний элемент");
                System.out.println("3 - Удалить конкретный элемент");
                System.out.println("0 - Выйти");
                System.out.print("Введите свой выбор меню: ");

                try {
                    choice = keybd.nextInt();
                    keybd.nextLine();
                    switch (choice) {

                        case 1:
                            System.out.print("Введите, что хотите записать: ");
                            String task = keybd.nextLine();
                            boolean added = list.add(task);

                            if (!added) {
                                System.out.println("Извините, но этот список дел уже заполнен!");

                            }
                            break;

                        case 2:
                            String removed = list.remove(list.getSize());
                            if (removed != null) {
                                System.out.println("Удален: " + removed);

                            } else {

                                System.out.println("Список дел уже пуст.");
                            }
                            break;

                        case 3:
                            System.out.print("Введите индекс элемента, который нужно удалить: ");
                            int index = keybd.nextInt();
                            removed = list.remove(index);

                            if (removed != null) {
                                System.out.println("Удален: " + removed);

                            } else {

                                System.out.println("В индексе нет элементов, которые нужно удалить " +
                                        index + ".");
                            }
                            break;

                        case 0:
                            System.out.println("Досвидания!");
                            break;

                        default:
                            System.out.println("Извините, но " + choice + " не является одним из элементов" +
                                    "Выбор меню. Пожалуйста, попробуйте еще раз.");
                            break;
                    }

                } catch (java.util.InputMismatchException ime) {
                    System.out.println("Введите, пожалуйста, число.");
                    keybd.nextLine();
                }
            }
        }
    }
}