import java.util.HashMap;

public class TaskManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    int nextId = 1;

    // Добавление новой задачи
    public void addTask(Task task) {
        task.setId(nextId++);
        task.setStatus(String.valueOf(Status.NEW));
        tasks.put(task.getId(), task);
    }

    // Печать списка всех задач, подзадач и эпиков
    public void printAllTasksAndEpics() {
        System.out.println("Список всех задач/подзадач/эпиков:");
        for (Integer type : tasks.keySet()) {
            System.out.println(tasks.get(type));
        }
        for (Integer type : epics.keySet()) {
            System.out.println(epics.get(type));
        }
        for (Integer type : subtasks.keySet()) {
            System.out.println(subtasks.get(type));
        }
    }

    // Удаление всех задач, подзадач и эпиков
    public void clearAllTasksAndEpics() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
        System.out.println("Все задачи, подзадачи и эпики удалены");
    }

    // Поиск задачи, подзадачи и эпика по ID
    public void searchById(int searchNumber) {
        for (Integer id : tasks.keySet()) {
            if (searchNumber == id) {
                System.out.println(tasks.get(searchNumber));
            }
        }
        for (Integer id : subtasks.keySet()) {
            if (searchNumber == id) {
                System.out.println(subtasks.get(searchNumber));
            }
        }
        for (Integer id : epics.keySet()) {
            if (searchNumber == id) {
                System.out.println(epics.get(searchNumber));
            }
        }
    }

    // Удаление задачи, подзадачи и эпика по ID
    public void removeById(int removeNumber) {
        for (Integer id : tasks.keySet()) {
            if (removeNumber == id) {
                tasks.remove(removeNumber);
                System.out.println("Задача с номером " + removeNumber + " удалена");
                break;
            }
        }
        for (Integer id : subtasks.keySet()) {
            if (removeNumber == id) {
                subtasks.remove(removeNumber);
                System.out.println("Подзадача с номером " + removeNumber + " удалена");
                break;
            }
        }
        for (Integer id : epics.keySet()) {
            if (removeNumber == id) {
                epics.remove(removeNumber);
                System.out.println("Эпик с номером " + removeNumber + " удалена");
              for (Integer i : subtasks.keySet()) {
                    Subtask subtask = subtasks.get(i);
                    if (removeNumber == subtask.epicId) {
                        subtasks.remove(subtask.getId());
                        System.out.println("Подзадача с номером Эпика " + removeNumber + " удалена");

                    }
                }
            }
        }
    }

    // Обновление Задачи/Task
    public void update(Task task, int idTask, String newStatus) {
        for (Integer id : tasks.keySet()) {
            if (idTask == id) {
                task.setId(idTask);
                tasks.put(idTask, task);
                task.setStatus(String.valueOf(newStatus));
               // System.out.println(tasks.get(idTask));
                break;
            }
        }
    }

    // Как вставляют эпик
    // Создали epic без подзадач
    // .add(epic) // <- выставился ему id
    // Создали подзадачу с subtask.epicId = epic.id
    // .add(subtask)

    // Добавление Эпика/Epic
    public void addEpic(Epic epic) {
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
        epic.setStatus(String.valueOf(Status.NEW));
    }

    // Добавление Позадачи/Subtask
    public void addSubtask(Subtask subtask) {
        subtask.setId(nextId++);
        subtasks.put(subtask.getId(), subtask);
        subtask.setStatus(String.valueOf(Status.NEW));
        Epic epic = epics.get(subtask.epicId);
        epic.subtasksIds.add(subtask.epicId);
    }

    // Обновление Эпика/Epic
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);

    }

    // Обновление подзадачи/Subtask
    public void updateSubtask(Subtask subtask, int idSubtask, String newStatus) {
        for (Integer id : subtasks.keySet()) {
            if (idSubtask == id) {
                subtask.setId(idSubtask);
                subtasks.put(idSubtask, subtask);
                subtask.setStatus(String.valueOf(newStatus));
                // System.out.println(tasks.get(idSubtask));
                break;
            }
        }
    }


    // Печать списка всех подзадач определённого эпика по ID эпика
    public void printSubtasksByEpics(int numberEpic) {
        for (Integer i : subtasks.keySet()) {
            Subtask subtask = subtasks.get(i);
            if (subtask.epicId == numberEpic) {
                System.out.println(subtask);
            }
        }
    }
}





