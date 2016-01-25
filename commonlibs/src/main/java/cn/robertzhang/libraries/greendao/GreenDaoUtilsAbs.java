package cn.robertzhang.libraries.greendao;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoMaster;

/**
 * Created by robertzhang on 16/1/22.
 * email: robertzhangsh@gmail.com
 */
public abstract class GreenDaoUtilsAbs<T,E extends AbstractDao<T,Long>> implements GreenDaoUtils<T>{

    protected E dao;

    protected abstract void setDao();

    /**
     * 加载实例通过，通过实例ID
     * @param id
     * @return T
     */
    public T loadById(long id){
        return dao.load(id);
    }

    /**
     * 加载所有实例
     * @return List<T>
     */
    public List<T> loadAll(){
        return dao.loadAll();
    }

    /**
     * 通过条件查找实例列表
     * @param where
     * @param params
     * @return List<T>
     */
    public List<T> query(String where, String... params){
        return dao.queryRaw(where, params);
    }

    /**
     * 插入或者更新实例
     * @param param 实例
     * @return 返回实例id
     */
    public long save(T param){
        return dao.insertOrReplace(param);
    }

    /**
     * 批量插入或者更新实例list
     * @param list
     */
    public void saveByLists(final List<T> list){
        if(null == list || list.isEmpty()){
            return;
        }
        dao.getSession().runInTx(new Runnable(){

            @Override
            public void run() {
                for(T note : list){
                    dao.insertOrReplace(note);
                }
            }

        });
    }

    /**
     * 删除所有实例
     */
    public void deleteAll(){
        dao.deleteAll();
    }

    /**
     * 通过实例ID删除
     * @param id
     */
    public void deleteById(long id){
        dao.deleteByKey(id);
    }

    /**
     * 通过实例删除
     * @param entity
     */
    public void deleteByEntity(T entity){
        dao.delete(entity);
    }

    public void updateEntity(T entity){
        dao.update(entity);
    }

}
