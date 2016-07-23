/**
 * IEnum.java site.lovecode.wechat.common.enums Copyright (c) 2014, .
 */

package site.lovecode.wechat.support.enums;


/**
 * 定义所有枚举类的接口类型
 * <p>
 * 所有枚举类必须实现此接口
 * 
 * @author yangpeng
 * @date 2014-11-11
 * @version 1.0.0
 */
public interface IEnum {

	/**
	 * 定义枚举值
	 */
	public int key();


	/**
	 * 定义枚举描述
	 */
	public String desc();

}
