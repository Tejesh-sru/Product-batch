import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Customer c = new Customer();
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.print("***************welcome to todo list***************\n");
        System.out.print("1.Admin\n2.User\nSelect your option: ");
        int option = sc.nextInt();
        ArrayList<Customer> list = new ArrayList<>();
        ArrayList<Task> task = new ArrayList<>();
        boolean logvalue = false;
        if (option==1) {
            System.out.print("enter username: ");
            String username = sc.next();
            System.out.print("enter password: ");
            String password = sc.next();

            if (username.equals("admin") && password.equals("admin")) {

                System.out.print("Welcome Admin\n");
                System.out.println("1.addcustomers");
                System.out.println("2.removecustomer");
                System.out.println("3.editcustomers");
                System.out.println("4.viewcustomer");
                System.out.println("5.logout");

                for (int i = 0; i < 1; i++) {
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        Customer c = new Customer();
                        System.out.print("enter customer id: ");
                        int cid = sc.nextInt();
                        System.out.print("enter customer email: ");
                        String email = sc.next();
                        System.out.print("enter customer password: ");
                        String pass = sc.next();
                        c.setCus_id(cid);
                        c.setEmail(email);
                        // changed password -> pass
                        c.setPassword(pass);
                        list.add(c);
                        System.out.print("added successfully");
                    }
                    else if (choice == 2) {
                        int id = sc.nextInt();
                        boolean found = false;
                        // use index instead of removing inside for-each
                        for (int i1 = 0; i1 < list.size(); i1++) {
                            Customer c = list.get(i1);
                            if (c.getCus_id() == id) {
                                list.remove(i1);
                                System.out.print("removed successfully");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.print("customer not found");
                        }
                    }
                    else if (choice == 3) {
                        // update customer
                        int id = sc.nextInt();
                        boolean found = false;
                        for (Customer c : list) {
                            if (c.getCus_id() == id) {
                                System.out.print("enter new email: ");
                                String email = sc.next();
                                System.out.print("enter new password: ");
                                String pass = sc.next();
                                c.setEmail(email);
                                c.setPassword(pass);
                                System.out.print("updated successfully");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.print("customer not found");
                        }
                    }
                    else if (choice == 4) {
                        // view customers
                        for (Customer c : list) {
                            System.out.println("id:" + c.getCus_id());
                            System.out.println("email:" + c.getEmail());
                            System.out.println("password:" + c.getPassword());
                        }
                    }
                    else if (choice == 5) {
                        logvalue = false;
                    }
                }
            }
            else {
                System.out.println("Invalid admin username or password");
            }
        }
        else if (option == 2) {
            System.out.print("enter username: ");
            String name = sc.next();
            System.out.print("enter password: ");
            String pass = sc.next();
            if (name.equals("customer") && pass.equals("customer")) {
                System.out.print("Welcome Customer\n");
                System.out.println("1.addtask");
                System.out.println("2.removetask");
                System.out.println("3.updatetask");
                System.out.println("4.viewtask");
                System.out.println("5.logout");
                int choice = sc.nextInt();
                if (choice == 1) {
                    Task t = new Task();
                    // consume newline
                    sc.nextLine();
                    System.out.print("enter task name: ");
                    String taskname = sc.nextLine();
                    System.out.print("enter task id: ");
                    int taskid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter description: ");
                    String description = sc.nextLine();
                    System.out.print("enter status: ");
                    String status = sc.nextLine();
                    t.setTaskname(taskname);
                    t.setTaskid(taskid);
                    t.setDescription(description);
                    t.setStatus(status);
                    task.add(t);
                    System.out.print("added successfully");
                }
                else if (choice == 2) {
                    // remove task
                    int id = sc.nextInt();
                    boolean found = false;
                    // use index instead of removing inside for-each
                    for (int i1 = 0; i1 < task.size(); i1++) {
                        Task t = task.get(i1);
                        if (t.getTaskid() == id) {
                            task.remove(i1);
                            System.out.print("removed successfully");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.print("task not found");
                    }
                }
                else if (choice == 3) {
                    // update task
                    int id = sc.nextInt();
                    boolean found = false;
                    for (Task t : task) {
                        if (t.getTaskid() == id) {
                            sc.nextLine();
                            System.out.print("enter new task name: ");
                            String taskname = sc.nextLine();
                            System.out.print("enter new description: ");
                            String description = sc.nextLine();
                            System.out.print("enter new status: ");
                            String status = sc.nextLine();
                            t.setTaskname(taskname);
                            t.setDescription(description);
                            t.setStatus(status);
                            System.out.print("updated successfully");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.print("task not found");
                    }
                }
                else if (choice == 4) {
                    // view tasks
                    for (Task t : task) {
                        System.out.println("task name: " + t.getTaskname());
                        System.out.println("task id: " + t.getTaskid());
                        System.out.println("description: " + t.getDescription());
                        System.out.println("status: " + t.getStatus());
                    }
                }
                else if (choice == 5) {
                    logvalue = false;
                }
            }
            else {
                System.out.println("Invalid customer username or password");
            }
        }
    }
}

