public class Main {

    private static void printAllTasks(TaskManager manager) {

        System.out.println("Задачи:");

        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }

        System.out.println("Эпики:");

        for (Epic epic : manager.getEpics()) {
            System.out.println(epic);
            for (Subtask subtask : manager.getSubtasksByEpic(epic.getId())) {
                System.out.println("--> " + subtask);
            }
        }

        System.out.println("Подзадачи:");

        for (Subtask subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");

        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {

        TaskManager manager = Managers.getDefault();

        Epic epic1 = new Epic("Эпик 1","Нужно сделать");
        manager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Subtask1 создания ", "Написать что то ", epic1.getId());
        manager.createSubtask(subtask1);

        Subtask subtask2 = new Subtask("Subtask2 создания ", "Написать что то ", epic1.getId());
        manager.createSubtask(subtask2);

        System.out.println(epic1);

        subtask1.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateSubtask(subtask1);
        System.out.println(epic1);

        subtask2.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask2);
        System.out.println(epic1);

        subtask1.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask1);
        System.out.println(epic1);

        subtask2.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask2);
        System.out.println(epic1);

        Epic epic = new Epic("Переезд", "Организация переезда на новую квартиру.");
        manager.createEpic(epic);

        Subtask subtask3 = new Subtask("Собрать коробки", "Упаковать вещи в коробки.", epic.getId());
        Subtask subtask4 = new Subtask("Упаковать кошку", "Убедиться, что кошка в переноске.", epic.getId());
        Subtask subtask5 = new Subtask("Сказать слова прощания", "Попрощаться с соседями.", epic.getId());

        manager.createSubtask(subtask3);
        manager.createSubtask(subtask4);
        manager.createSubtask(subtask5);

        subtask3.setStatus(TaskStatus.DONE);
        subtask4.setStatus(TaskStatus.DONE);
        subtask5.setStatus(TaskStatus.DONE);

        manager.updateEpic(epic);

        printAllTasks(manager);
    }
}