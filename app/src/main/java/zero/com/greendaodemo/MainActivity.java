package zero.com.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import zero.com.greendaodemo.SQL.Student;
import zero.com.greendaodemo.SQL.StudentDao;
import zero.com.greendaodemo.SQL.StudentDaoUtils;
import zero.com.greendaodemo.SQL.User;
import zero.com.greendaodemo.SQL.UserDao;
import zero.com.greendaodemo.SQL.UserDaoUtils;
import zero.com.utillib.utils.Logs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view) {
        UserDaoUtils.insert(new User(null,"刘嘉亮",18,0,"中国"));
        StudentDaoUtils.insert(new Student(null,"刘嘉明",20,"男"));
    }

    public void updata(View view) {
        User user = UserDaoUtils.getUserDao().load(1L);
        if (user != null){
            user.setAge(19);
            UserDaoUtils.updata(user);
        }else {
            Toast.makeText(MainActivity.this,"没有此记录",Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        User user = UserDaoUtils.getUserDao().load(1L);
        if (user != null){
            UserDaoUtils.getUserDao().delete(user);
        }else {
            Toast.makeText(MainActivity.this,"没有此记录",Toast.LENGTH_SHORT).show();
        }
    }

    public void search(View view) {
        if (UserDaoUtils.getCount() <= 0){
            Toast.makeText(MainActivity.this,"没有记录",Toast.LENGTH_SHORT).show();
            return;
        }
        for (User s : UserDaoUtils.loadAll()){
            Logs.JLlog(s.getId()+" "+ s.getName()+" "+ s.getAge()+" " + s.getSex()+" " + s.getCountry()+" ");
        }
        Logs.JLlog("按条件查询");
        List<User> users = UserDaoUtils.query(UserDao.Properties.Name.like("刘%"));
        for (User s : users){
            Logs.JLlog(s.getId()+" "+ s.getName()+" "+ s.getAge()+" " + s.getSex()+" " + s.getCountry()+" ");
        }

        List<Student> user2s = StudentDaoUtils.query(StudentDao.Properties.Name.like("刘%"));
        for (Student s : user2s){
            Logs.JLlog(s.getId()+" "+ s.getName()+" "+ s.getAge()+ s.getSex());
        }
    }

    public void deleteBy(View view) {
        UserDaoUtils.delete(UserDao.Properties.Name.like("刘%"));
    }
}
