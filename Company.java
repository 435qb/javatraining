
/**
 * @author 侯易杭
 * @date 2021_06_29
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class FormatException extends RuntimeException {
    FormatException(String message) {
        super(message);
    }
}

// 两个arraylist必须保持一致
public class Company {
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<DataInfo> dataInfos = new ArrayList<DataInfo>();

    public void init() {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("employees.txt");
        } catch (FileNotFoundException fe) {
            System.out.println("未找到employees.txt文件");
            System.exit(1);
        }
        Scanner scanner = new Scanner(fs);
        try {
            while (scanner.hasNextLine()) {
                int id = scanner.nextInt();
                String name = scanner.next();
                for (Employee employee : employees) {
                    if (employee.getId() == id) {
                        throw new FormatException("不能有重复id");
                    }
                }
                employees.add(new Employee(id, name));
                dataInfos.add(new DataInfo(id));
            }
            System.out.println("初始化成功");
        } catch (InputMismatchException ime) {
            System.out.println("格式错误!");
            System.exit(1);
        } catch (FormatException fe) {
            System.out.println(fe.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }
    }

    // id应当调用前做检测
    public Company addEmployee(int id, String name) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("已有此人");
            }
        }
        employees.add(new Employee(id, name));
        dataInfos.add(new DataInfo(id));
        System.out.println("操作成功");
        return this;
    }

    // id应当调用前做检测
    public Company removeEmployee(int id) {
        boolean remove_flag = false;
        int i = 0;
        for (; i < employees.size(); ++i) {
            if (employees.get(i).getId() == id) {
                remove_flag = true;
            }
        }
        if (remove_flag == false)
            System.out.println("已无此人");
        else {
            employees.remove(i);
            dataInfos.remove(i);
        }
        System.out.println("操作成功");
        return this;
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("成功查找到此员工");
                return employee;
            }
        }
        System.out.println("查无此人");
        return new Employee();
    }

    public DataInfo getDataInfo(int id) {
        for (DataInfo dataInfo : dataInfos) {
            if (dataInfo.getId() == id) {
                System.out.println("操作成功");
                return dataInfo;
            }
        }
        System.out.println("查无此人");
        return new DataInfo();
    }

    public void displayEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("查无此人");
    }

    public ArrayList<Integer> getAllId() {
        ArrayList<Integer> idList = new ArrayList<Integer>();
        for (Employee employee : employees) {
            idList.add(employee.getId());
        }
        return idList;
    }

}