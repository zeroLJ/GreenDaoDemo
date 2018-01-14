package zero.com.greendaodemo.SQL;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by jj on 2018/1/10.
 */

public class UserDaoUtils {
    /**
     * 获取对User表进行增删改的实例
     * @return
     */
    public static UserDao getUserDao(){
        return GreenDaoManager.getInstance().getDaoSession().getUserDao();
    }


    /**
     * 插入一条记录
     * @param user
     */
    public static boolean insert(User user){
        boolean flag = false;
        try {
            getUserDao().insert(user);
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
            getUserDao().queryBuilder()
                    .where(condition, condMore).buildDelete().executeDeleteWithoutDetachingEntities();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 更新某条记录
     * @param user 必须通过query查询出来，修改后再调用此方法，不能直接new
     */
    public static boolean updata(User user){
        boolean flag = false;
        try {
            getUserDao().update(user);
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
    public static List<User> query(WhereCondition condition, WhereCondition... condMore){
        return getUserDao().queryBuilder()
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
    public static List<User> loadAll(){
        return getUserDao().loadAll();
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public static User loadAll(Long id){
        return getUserDao().load(id);
    }
}
