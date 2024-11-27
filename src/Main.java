public class Main {

    static TaskManager ts;

    public static void main(String[] args) {
      ts = new TaskManager();
      ts.addTask(new Task("Task1", "Task1"));
      //ts.update(new  Task("nameNew", "descNew" ), 1, "DONE" );
      ts.addEpic(new Epic("Epic1", "Epic1"));
      ts.addEpic(new Epic("Epic2", "Epic2"));
      ts.addSubtask(new Subtask("Subtask1", "Subtask1",2));
      ts.addSubtask(new Subtask("Subtask2", "Subtask2",3));
      ts.addSubtask(new Subtask("Subtask3", "Subtask3",3));

       // ts.printAllTasksAndEpics(); // Получение списка всех задач, подзадач и эпиков
      //  ts.updateSubtask(new Subtask("NewSubtask2", "NewSubtask2", 3), 5, "DONE");
        //ts.printSubtasksByEpics(1);
        ts.printAllTasksAndEpics();

        //ts.searchById(6); //Поиск по ID
         ts.removeById(2); // Удаление по ID
        ts.printAllTasksAndEpics();

    }
}
