package com.Loan.Main;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.Loan.Enitity.LoanApplication;
import com.Loan.Enitity.User;
import com.Loan.Service.*;

public class MainApp {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static UserService userService = new UserServiceImpl();
    static LoanService loanService = new LoanServiceImpl();

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.out.println("Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 🔐 REGISTER
    static void register() throws Exception {
        System.out.print("Enter Username: ");
        String username = br.readLine();

        System.out.print("Enter Password: ");
        String password = br.readLine();

        System.out.print("Enter Role (ADMIN/AGENT/CUSTOMER): ");
        String role = br.readLine().toUpperCase();

        User user = new User(0, username, password, role);

        userService.register(user);
        System.out.println("✅ Registration Done!");
    }

    // 🔐 LOGIN
    static void login() throws Exception {
        System.out.print("Enter Username: ");
        String username = br.readLine();

        System.out.print("Enter Password: ");
        String password = br.readLine();

        User user = userService.login(username, password);

        if (user == null) {
            System.out.println("❌ Invalid Credentials!");
            return;
        }

        System.out.println("✅ Login Successful! Role: " + user.getRole());

        switch (user.getRole()) {
            case "ADMIN":
                adminMenu();
                break;
            case "AGENT":
                agentMenu();
                break;
            case "CUSTOMER":
                customerMenu(user.getId());
                break;
        }
    }

    // 👤 CUSTOMER MENU
    static void customerMenu(int userId) throws Exception {
        while (true) {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. Apply Loan");
            System.out.println("2. View My Loans");
            System.out.println("3. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Amount: ");
                    double amount = Double.parseDouble(br.readLine());

                    System.out.print("Enter Duration (months): ");
                    int duration = Integer.parseInt(br.readLine());

                    LoanApplication loan = new LoanApplication(0, userId, amount, duration, "APPLIED");

                    loanService.applyLoan(loan);
                    System.out.println("✅ Loan Applied!");

                    break;

                case 2:
                    List<LoanApplication> list = loanService.getUserLoans(userId);

                    for (LoanApplication l : list) {
                        l.displayForCustomer();
                    }
                    break;

                case 3:
                    return;
            }
        }
    }

    // 🧑‍💼 AGENT MENU
    static void agentMenu() throws Exception {
        while (true) {
            System.out.println("\n===== AGENT MENU =====");
            System.out.println("1. View Applied Loans");
            System.out.println("2. Approve Loan");
            System.out.println("3. Reject Loan");
            System.out.println("4. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    List<LoanApplication> list = loanService.getAppliedLoans();

                    for (LoanApplication l : list) {
                        System.out.println("ID: " + l.getId() +
                                " User: " + l.getUserId() +
                                " Amount: " + l.getAmount() +
                                " Status: " + l.getStatus());
                    }
                    break;

                case 2:
                    System.out.print("Enter Loan ID: ");
                    int approveId = Integer.parseInt(br.readLine());

                    loanService.approveLoan(approveId);
                    System.out.println("✅ Loan Approved!");

                    break;

                case 3:
                    System.out.print("Enter Loan ID: ");
                    int rejectId = Integer.parseInt(br.readLine());

                    loanService.rejectLoan(rejectId);
                    System.out.println("❌ Loan Rejected!");

                    break;

                case 4:
                    return;
            }
        }
    }

    // 👨‍💻 ADMIN MENU
    static void adminMenu() throws Exception {
        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View All Loans");
            System.out.println("2. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    List<LoanApplication> list = loanService.getAllLoans();

                    for (LoanApplication l : list) {
                        l.displayFull();;
                    }
                    break;

                case 2:
                    return;
            }
        }
    }
}
