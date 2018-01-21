package zero.com.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zero.com.greendaodemo.SQL.DaoUtils;
import zero.com.greendaodemo.SQL.Student;
import zero.com.greendaodemo.SQL.StudentDao;
import zero.com.greendaodemo.SQL.User;
import zero.com.greendaodemo.SQL.UserDao;
import zero.com.utillib.utils.Logs;

/**
 * Created by zero on 2018/1/20.
 */

public class Sample2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    public void insert(View view) {
        DaoUtils.insert(new User(null,"zero",18,0,"中国") );
        DaoUtils.insert(new Student(null,"zero2",18,"男") );
        Map<String, Object> map = new HashMap<>();
//        map.put("id", 10L);
        map.put("name", "zero");
        map.put("age", 22);
        map.put("sex", 0);
        map.put("country", "中国");
        DaoUtils.insert(User.class,map);


        Map<String, Object> map2 = new HashMap<>();
//        map.put("id", 10L);
        map2.put("name", "zero");
        map2.put("age", 22);
        map2.put("sex", "男");
        DaoUtils.insert(Student.class, map2);

    }

    public void updata(View view) {
        User user = DaoUtils.load(User.class,1L);
        if (user != null){
            user.setAge(19);
            DaoUtils.updata(user);
        }else {
            Toast.makeText(Sample2Activity.this,"没有此记录",Toast.LENGTH_SHORT).show();
        }

        Student student = DaoUtils.load(Student.class,1L);
        if (student != null){
            student.setAge(19);
            DaoUtils.updata(student);
        }else {
            Toast.makeText(Sample2Activity.this,"没有此记录",Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        DaoUtils.delete(User.class, UserDao.Properties.Name.like("z%"));
        DaoUtils.delete(Student.class, StudentDao.Properties.Name.like("z%"));
    }

    public void search(View view) {
        Logs.JLlog(""+DaoUtils.getCount(User.class));
        if (DaoUtils.getCount(User.class) <= 0){
            Toast.makeText(Sample2Activity.this,"没有记录",Toast.LENGTH_SHORT).show();
            return;
        }

        for (User s : DaoUtils.loadAll(User.class)){
            Logs.JLlog(s.toString());
        }


        Logs.JLlog("按条件查询");
        List<User> users = DaoUtils.query(User.class,UserDao.Properties.Name.like("z%"));
        for (User s : users){
            Logs.JLlog(s.toString());
        }

        List<Student> students = DaoUtils.query(Student.class, StudentDao.Properties.Name.like("z%"));
        for (Student s : students){
            Logs.JLlog(s.toString());
        }
    }

    public void deleteBy(View view) {
        DaoUtils.delete(User.class, UserDao.Properties.Name.like("z%"));
        DaoUtils.delete(Student.class, StudentDao.Properties.Name.like("z%"));
    }
}
