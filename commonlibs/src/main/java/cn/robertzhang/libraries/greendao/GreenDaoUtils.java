package cn.robertzhang.libraries.greendao;

import java.util.List;

/**
 * Created by robertzhang on 16/1/22.
 * email: robertzhangsh@gmail.com
 */
public interface GreenDaoUtils<T> {

    /**
     * 加载实例通过，通过实例ID
     * @param id
     * @return T
     */
    public T loadById(long id);

    /**
     * 加载所有实例
     * @return List<T>
     */
    public List<T> loadAll();

    /**
     * 通过条件查找实例列表
     * @param where
     * @param params
     * @return List<T>
     */
    public List<T> query(String where, String... params);

    /**
     * 插入或者更新实例
     * @param param 实例
     * @return 返回实例id
     */
    public long save(T param);

    /**
     * 批量插入或者更新实例list
     * @param list
     */
    public void saveByLists(final List<T> list);

    /**
     * 删除所有实例
     */
    public void deleteAll();

    /**
     * 通过实例ID删除
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过实例删除
     * @param entity
     */
    public void deleteByEntity(T entity);

    public void updateEntity(T entity);

}
