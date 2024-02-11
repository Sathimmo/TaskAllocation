import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private int taskNo;
    private String name;
    private String description;
    private List<String> requiredSkills;
    private String deadline;

    public Task(int taskNo, String name, String description, List<String> requiredSkills, String deadline) {
        this.taskNo = taskNo;
        this.name = name;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.deadline = deadline;
    }

    public int getTaskNo() {
        return taskNo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Description: %s, Required Skills: %s, Deadline: %s",
                taskNo, name, description, requiredSkills, deadline);
    }
}

class TeamMember {
    private int id;
    private String name;
    private List<String> skills;
    private boolean available;
    private int workload;

    public TeamMember(int id, String name, List<String> skills, boolean available, int workload) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.available = available;
        this.workload = workload;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getWorkload() {
        return workload;
    }

    @Override
    public String toString() {
        return String.format("ID: %d Name: %s, Skills: %s, Available: %b, Workload: %d", id, name, skills, available, workload);
    }
}

public class TaskAssignmentSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Task> tasks = new ArrayList<>();
    private static List<TeamMember> teamMembers = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            clearScreen();
            System.out.println("1. Tasks");
            System.out.println("2. Group members");
            System.out.println("3. Present task assignments");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleTasks();
                    break;
                case 2:
                    handleGroupMembers();
                    break;
                case 3:
                    presentTaskAssignments();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void handleTasks() {
        while (true) {
            clearScreen();
            System.out.println("Tasks:");
            System.out.println("1. Show task data");
            System.out.println("2. Create a task");
            System.out.println("3. Back to main menu");

            System.out.print("Enter your choice: ");
            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (choice) {
                case '1':
                    showTaskData();
                    break;
                case '2':
                    createTask();
                    break;
                case '3':
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void handleGroupMembers() {
        while (true) {
            clearScreen();
            System.out.println("Group Members:");
            System.out.println("1. Show group member data");
            System.out.println("2. Add group member");
            System.out.println("3. Back to main menu");

            System.out.print("Enter your choice: ");
            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (choice) {
                case '1':
                    showGroupMemberData();
                    break;
                case '2':
                    addGroupMember();
                    break;
                case '3':
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void createTask() {
        System.out.print("Enter number of tasks: ");
        int nTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < nTasks; i++) {
            System.out.print("Enter task number: ");
            int taskNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter task name: ");
            String name = scanner.nextLine();
            System.out.print("Enter task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter required skills (comma-separated): ");
            String[] skillsArray = scanner.nextLine().split(",");
            List<String> requiredSkills = new ArrayList<>();
            for (String skill : skillsArray) {
                requiredSkills.add(skill.trim());
            }
            System.out.print("Enter deadline: ");
            String deadline = scanner.nextLine();
            Task task = new Task(taskNo, name, description, requiredSkills, deadline);
            tasks.add(task);
            System.out.println("Task created successfully.");
        }
    }

    private static void showTaskData() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void addGroupMember() {
        System.out.print("Enter number of group members: ");
        int nGroupMembers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < nGroupMembers; i++) {
            System.out.print("Enter member ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter member name: ");
            String name = scanner.nextLine();
            System.out.print("Enter member skills (comma-separated): ");
            String[] skillsArray = scanner.nextLine().split(",");
            List<String> skills = new ArrayList<>();
            for (String skill : skillsArray) {
                skills.add(skill.trim());
            }
            System.out.print("Enter member workload: ");
            int workload = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Is member available? (true/false): ");
            boolean available = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline
            TeamMember member = new TeamMember(id, name, skills, available, workload);
            teamMembers.add(member);
            System.out.println("Member added successfully.");
        }
    }

    private static void showGroupMemberData() {
        if (teamMembers.isEmpty()) {
            System.out.println("No group members available.");
            return;
        }
        for (TeamMember member : teamMembers) {
            System.out.println(member);
        }
    }

    private static void presentTaskAssignments() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Task Assignments:");
        for (Task task : tasks) {
            System.out.println("Task: " + task.getName());
            System.out.println("ID: " + task.getTaskNo());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Required Skills: " + task.getRequiredSkills());
            System.out.println("Deadline: " + task.getDeadline());
            System.out.println("Assigned Team Members:");
            boolean foundMember = false;
            for (TeamMember member : teamMembers) {
                if (member.isAvailable() && hasRequiredSkills(member, task)) {
                    System.out.print("ID : " + member.getId());
                    System.out.println(" - Name: " + member.getName());
                    System.out.println("   Skills: " + member.getSkills());
                    System.out.println("   Workload: " + member.getWorkload());
                    foundMember = true;
                }
            }
            if (!foundMember) {
                System.out.println("No available team members with required skills for this task.");
            }
            System.out.println();
        }
    }

    private static boolean hasRequiredSkills(TeamMember member, Task task) {
        List<String> memberSkills = member.getSkills();
        List<String> requiredSkills = task.getRequiredSkills();
        for (String skill : requiredSkills) {
            if (!memberSkills.contains(skill)) {
                return false;
            }
        }
        return true;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
