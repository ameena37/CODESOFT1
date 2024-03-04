import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<String> schedule;
    private List<String> enrolledStudents;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public int getCapacity() {
        return capacity;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(String studentName) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentName);
            System.out.println(studentName + " has been enrolled in " + title);
        } else {
            System.out.println("Course " + title + " is already full.");
        }
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent(name);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println(name + " has dropped " + course.getTitle());
    }
}

class CourseRegistrationSystem {
    public static void main(String[] args) {
        Course mathCourse = new Course("MATH101", "Mathematics", "Introduction to Mathematics", 30, List.of("Mon", "Wed", "Fri"));
        Course physicsCourse = new Course("PHYS101", "Physics", "Introduction to Physics", 25, List.of("Tue", "Thu"));
        
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        student1.registerCourse(mathCourse);
        student1.registerCourse(physicsCourse);
          student2.registerCourse(mathCourse);
        student2.dropCourse(mathCourse);

        System.out.println("\nCourses:");
        displayCourseInfo(mathCourse);
        displayCourseInfo(physicsCourse);
    }

    public static void displayCourseInfo(Course course) {
        System.out.println("Code: " + course.getCode());
        System.out.println("Title: " + course.getTitle());
        System.out.println("Description: " + course.getDescription());
        System.out.println("Capacity: " + course.getCapacity());
        System.out.println("Schedule: " + course.getSchedule());
        System.out.println("Enrolled Students: " + course.getEnrolledStudents());
        System.out.println();
 }
}

