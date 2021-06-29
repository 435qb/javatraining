
import java.util.Date;
import java.text.*;
/**
 */
public class DataInfo {
    private int id = 0; // 工号
    private Date signUpDate  = new Date(0L); // 签到时间  0表示没签
    private Date signOutDate = new Date(0L);// 签退时间  0表示没签
    public DataInfo(int id){
        this.id = id;
    }
    public DataInfo(){}
    /**
     * 
     * @return
     */
    public boolean is_valid() {
        return Employee.valid_id(id);
    }
    /**
     * 
     * @return
     */
    public boolean hasSignUp(){
        return signUpDate.getTime() != 0;
    }
    public boolean hasSignOut(){
        return signOutDate.getTime() != 0;
    }
    public void signUp(){
        signUpDate = new Date();
    }
    public void signOut(){
        signOutDate = new Date();
    }
    public Date getSignUpDate(){
        return signUpDate;
    }
    public Date getSignOutDate(){
        return signOutDate;
    }
    public int getId(){
        return id;
    }
    private static SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public String signUpInfo(){
        return ft.format(signUpDate);
    }
    public String signOutInfo(){
        return ft.format(signOutDate);
    }
}
