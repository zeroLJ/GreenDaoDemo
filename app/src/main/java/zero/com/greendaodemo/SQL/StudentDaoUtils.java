package zero.com.greendaodemo.SQL;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import static zero.com.greendaodemo.SQL.UserDaoUtils.getUserDao;

/**
 * Created by zero on 2018/1/10.
 */

public class StudentDaoUtils {
    /**
     * 获取对User表进行增删改的实例
     * @return
     */
    public static StudentDao getStudentDao(){
        return GreenDaoManager.getInstance().getDaoSession().getStudentDao();
    }


    /**
     * 插入一条记录
     * @param student
     */
    public static boolean insert(Student student){
        boolean flag = false;
        try {
            getStudentDao().insert(student);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

//    public static void delete(WhereCondition condition){
//        GreenDaoManager.getInstance().getDaoSession().getUserDao().queryBuilder()
//                .where(condition).buildDelete().executeDeleteWithoutDetachingEntities();
//    }

    /**
     * 根据条件删除记录
     * @param condition 匹配条件，若为空，会删除所有记录
     * @param condMore  可增加复数条件
     */

    public static boolean delete(WhereCondition condition,WhereCondition... condMore){
        boolean flag = false;
        try {
            getStudentDao().queryBuilder()
                    .where(condition, condMore).buildDelete().executeDeleteWithoutDetachingEntities();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 更新某条记录
     * @param student 必须通过query查询出来，修改后再调用此方法，不能直接new
     */
    public static boolean updata(Student student){
        boolean flag = false;
        try {
            getStudentDao().update(student);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据条件查询
     * @param condition 匹配条件，若为空，会查询所有记录
     * @param condMore 可增加复数条件
     * @return
     */
    public static List<Student> query(WhereCondition condition, WhereCondition... condMore){
        return getStudentDao().queryBuilder()
                .where(condition, condMore).list();
    }

    /**
     * 获取记录总数量
     * @return
     */
    public static long getCount(){
       return getUserDao().count();
    }

    /**
     * 获取所有记录记录
     * @return
     */
    public static List<Student> loadAll(){
        return getStudentDao().loadAll();
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public static Student load(Long id){
        return getStudentDao().load(id);
    }
}
