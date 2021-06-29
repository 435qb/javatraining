/**
 * @author 侯易杭
 * @date 2021_06_29
 */
public class Employee {
    private int id = 0; // 工号
    private String name = null; // 姓名

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public static boolean valid_id(int id) {
        return id > 0 && id <= 999;
    }

    public boolean is_valid() {
        return valid_id(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) throws IllegalArgumentException {
        if (!valid_id(id)) {
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString()
    {
        return "工号为：" + id + " 姓名:" + name;
    }
}
