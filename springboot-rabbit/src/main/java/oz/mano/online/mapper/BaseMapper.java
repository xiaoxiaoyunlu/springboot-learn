package oz.mano.online.mapper;


/**
 * 所有mapper的父接口
 * 
 * @author zj
 *
 * @param <T>
 */
public interface BaseMapper<T> {

	/**
	 * 保存t对象
	 * 
	 * @param t
	 */
	public void save(T t) throws Exception;

	/**
	 * 修改t对象
	 * 
	 * @param t
	 */
	public void update(T t) throws Exception;

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delete(Long id) throws Exception;

	/**
	 * 根据ID获取t对象
	 * 
	 * @param id
	 * @return
	 */
	public T get(Long id) throws Exception;


}
