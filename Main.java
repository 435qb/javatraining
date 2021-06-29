import java.util.*;
/**
 * @author 侯易杭
 * @date 2021_06_29
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static Company company = new Company();

    public static void main(String[] args) {
        company.init();
        while (true) {
            System.out.println("----员工打卡系统----");
            System.out.println("0---------退出");
            System.out.println("1---------签到");
            System.out.println("2---------签退");// 无记录
            System.out.println("3---------查看签到信息");
            System.out.println("请输入想执行的操作:");
            if (!scanner.hasNextInt()) {
                if(scanner.hasNext()) scanner.next();
                System.out.println("输入非法字符");
                continue;
            }
            int i = scanner.nextInt();
            boolean exit_flag = false;
            switch (i) {
                case 0:
                    System.out.println("已退出");
                    exit_flag = true;
                    break;
                case 1:
                    signUp();
                    break;
                case 2:
                    signOut();
                    break;
                case 3:
                    info();
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
            if (exit_flag) {
                break;
            }
        }
    }

    private static Employee getEmployee() {
        if (!scanner.hasNextInt()) {
            System.out.println("输入非法字符");
            scanner.next();
            return new Employee();
        }
        int i = scanner.nextInt();
        if (!Employee.valid_id(i)) {
            System.out.println("不是合法的工号");
            return new Employee();
        }
        Employee employee = company.getEmployee(i);
        if (employee.getId() == 0) {
            return new Employee();
        }
        return employee;
    }

    // 工号为112 姓名为xx
    // 签到
    private static void signUp() {
        System.out.println("请输入签到员工ID");
        Employee employee = getEmployee();
        if (employee.getId() == 0) {
            return;
        }
        DataInfo dataInfo = company.getDataInfo(employee.getId());
        // 非必要 company相耦合
        // if (!dataInfo.is_valid()) {
        // return;
        // }
        if (dataInfo.hasSignUp()) {
            System.out.println("您已签过到，请明天再来");
            return;
        }
        dataInfo.signUp();
        System.out.println("工号：" + employee.getId() + " 打卡成功");
    }

    private static void signOut() {
        System.out.println("请输入签退员工ID");
        Employee employee = getEmployee(); // Employee可能是空的
        if (employee.getId() == 0) {
            return;
        }
        DataInfo dataInfo = company.getDataInfo(employee.getId());
        if (!dataInfo.hasSignUp()) {
            System.out.println("今天还没有签到，无法签退");
            return;
        }
        if (dataInfo.hasSignOut()) {
            System.out.println("您已签过退，无需再签");
        }
        dataInfo.signOut();
        System.out.println("工号：" + employee.getId() + " 签退成功");
    }

    private static void info() {
        ArrayList<Integer> idList = company.getAllId();
        for (Integer id : idList) {
            System.out.println(company.getEmployee(id));
            DataInfo dataInfo = company.getDataInfo(id);
            System.out.print("签到时间为：");
            if (!dataInfo.hasSignUp())
                System.out.println(" 无记录");
            else
                System.out.println(dataInfo.signUpInfo());
            System.out.print("签退时间为：");
            if (!dataInfo.hasSignOut())
                System.out.println(" 无记录");
            else
                System.out.println(dataInfo.signOutInfo());
        }
    }
}
