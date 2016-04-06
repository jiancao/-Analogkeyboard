package com.example.analogkeyboard;

/**
 * 键盘bean
 * @author caojian
 * @date 2016-3-5 下午6:49:14
 */
public class KeyBoradBean {
	private String code;//code
	private String str;//显示字符
	private int icon;//图标
	private float width;//宽度�?
	
	public KeyBoradBean(String code, String str, float width) {
		super();
		this.code = code;
		this.str = str;
		this.width=width;
	}
	
	public KeyBoradBean(String code, int icon, float width) {
		super();
		this.code = code;
		this.icon = icon;
		this.width=width;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
	
	

}
