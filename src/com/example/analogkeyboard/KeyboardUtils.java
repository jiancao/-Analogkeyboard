package com.example.analogkeyboard;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;


/**
 * 模拟键盘
 * @author caojian
 * @date 2016-3-5 下午5:04:41
 */
public class KeyboardUtils {
	private Dialog dialog;
	private Context ctx;
	private List<View> allViews=new CopyOnWriteArrayList<View>();//保存�?有的key
	private View convertView;
	private LinearLayout ll_keyboard1;
	private LinearLayout ll_keyboard2;
	private LinearLayout ll_keyboard3;
	private LinearLayout ll_keyboard4;
	private EditText et;
	private boolean isShift=false;//大小写切�?
	
	public KeyboardUtils(Context ctx,EditText et){
		this.ctx=ctx;
		this.et=et;
		convertView=LayoutInflater.from(ctx).inflate(R.layout.layout_keyboard, null);
		ll_keyboard1=(LinearLayout) convertView.findViewById(R.id.ll_keyboard1);
		ll_keyboard2=(LinearLayout) convertView.findViewById(R.id.ll_keyboard2);
		ll_keyboard3=(LinearLayout) convertView.findViewById(R.id.ll_keyboard3);
		ll_keyboard4=(LinearLayout) convertView.findViewById(R.id.ll_keyboard4);
		initLL(ll_keyboard1,1,1,1,0,initKeys(initNumberKeys1()));
		initLL(ll_keyboard2,1,0,1,0,initKeys(initNumberKeys2()));
		initLL(ll_keyboard3,1,0,1,0, initKeys(initNumberKeys3()));
		initLL(ll_keyboard4,1,0,1,1, initKeys(initNumberKeys4()));
		convertView.findViewById(R.id.tv_finish).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(dialog!=null){
					dialog.dismiss();
				}
			}
		});
	}

	/**
	 * 键盘对话�?
	 * date 2016-3-9下午4:26:23
	 * params @return
	 * return Dialog
	 */
	public Dialog showKeyBoard(){
		dialog = new Dialog(ctx, R.style.action_keyboard);
		dialog.show();
		dialog.setContentView(convertView);
		dialog.setCanceledOnTouchOutside(true);
		Window window = dialog.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
		lp.width = dm.widthPixels;
		window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位�?
		window.setWindowAnimations(R.style.action_sheet_animation); // 添加动画
		return dialog;
	}
	
	/**
	 * 数字键盘1
	 * date 2016-3-9下午4:28:53
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initNumberKeys1(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("1", "1",1.0f));
		keys.add(new KeyBoradBean("2", "2",1.0f));
		keys.add(new KeyBoradBean("3", "3",1.0f));
		return keys;
	}
	
	/**
	 * 数字键盘2
	 * date 2016-3-9下午4:29:34
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initNumberKeys2(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("4", "4",1.0f));
		keys.add(new KeyBoradBean("5", "5",1.0f));
		keys.add(new KeyBoradBean("6", "6",1.0f));
		return keys;
	}
	
	/**
	 * 数字键盘3
	 * date 2016-3-9下午4:29:42
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initNumberKeys3(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("7", "7",1.0f));
		keys.add(new KeyBoradBean("8", "8",1.0f));
		keys.add(new KeyBoradBean("9", "9",1.0f));
		return keys;
	}
	
	/**
	 * 数字键盘4
	 * date 2016-3-9下午4:29:54
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initNumberKeys4(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("zimu", "abc",1.0f));
		keys.add(new KeyBoradBean("0", "0",1.0f));
		keys.add(new KeyBoradBean("chexiao", R.drawable.key_delete_black,1.0f));
		return keys;
	}
	
	/**
	 * 字母键盘1
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initletterKeys1(boolean isUpperCase){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("q"):"q", isUpperCase?StringUtils.upperCase("q"):"q",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("w"):"w", isUpperCase?StringUtils.upperCase("w"):"w",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("e"):"e", isUpperCase?StringUtils.upperCase("e"):"e",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("r"):"r", isUpperCase?StringUtils.upperCase("r"):"r",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("t"):"t", isUpperCase?StringUtils.upperCase("t"):"t",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("y"):"y", isUpperCase?StringUtils.upperCase("y"):"y",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("u"):"u", isUpperCase?StringUtils.upperCase("u"):"u",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("i"):"i", isUpperCase?StringUtils.upperCase("i"):"i",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("o"):"o", isUpperCase?StringUtils.upperCase("o"):"o",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("p"):"p", isUpperCase?StringUtils.upperCase("p"):"p",1.0f));
		return keys;
	}
	
	/**
	 * 字母键盘2
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initletterKeys2(boolean isUpperCase){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("a"):"a", isUpperCase?StringUtils.upperCase("a"):"a",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("s"):"s", isUpperCase?StringUtils.upperCase("s"):"s",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("d"):"d", isUpperCase?StringUtils.upperCase("d"):"d",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("f"):"f", isUpperCase?StringUtils.upperCase("f"):"f",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("g"):"g", isUpperCase?StringUtils.upperCase("g"):"g",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("h"):"h", isUpperCase?StringUtils.upperCase("h"):"h",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("j"):"j", isUpperCase?StringUtils.upperCase("j"):"j",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("k"):"k", isUpperCase?StringUtils.upperCase("k"):"k",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("l"):"l", isUpperCase?StringUtils.upperCase("l"):"l",1.0f));
		return keys;
	}
	
	/**
	 * 字母键盘3
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initletterKeys3(boolean isUpperCase){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("shift", R.drawable.key_shift_white,1.5f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("z"):"z", isUpperCase?StringUtils.upperCase("z"):"z",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("x"):"x", isUpperCase?StringUtils.upperCase("x"):"x",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("c"):"c", isUpperCase?StringUtils.upperCase("c"):"c",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("v"):"v", isUpperCase?StringUtils.upperCase("v"):"v",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("b"):"b", isUpperCase?StringUtils.upperCase("b"):"b",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("n"):"n", isUpperCase?StringUtils.upperCase("n"):"n",1.0f));
		keys.add(new KeyBoradBean(isUpperCase?StringUtils.upperCase("m"):"m", isUpperCase?StringUtils.upperCase("m"):"m",1.0f));
		keys.add(new KeyBoradBean("chexiao", R.drawable.key_delete_white,1.5f));
		return keys;
	}
	
	/**
	 * 字母键盘4
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initletterKeys4(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("123", R.drawable.key_123_white,3f));
		keys.add(new KeyBoradBean("kongge",R.drawable.key_kongge,5.0f));
		keys.add(new KeyBoradBean("zifu", R.drawable.key_fuhao_white,3f));
		return keys;
	}
	
	/**
	 * 字符键盘1
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initCharKeys1(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("!", "!",1.0f));
		keys.add(new KeyBoradBean("@", "@",1.0f));
		keys.add(new KeyBoradBean("#", "#",1.0f));
		keys.add(new KeyBoradBean("$", "$",1.0f));
		keys.add(new KeyBoradBean("%", "%",1.0f));
		keys.add(new KeyBoradBean("^", "^",1.0f));
		keys.add(new KeyBoradBean("&", "&",1.0f));
		keys.add(new KeyBoradBean("*", "*",1.0f));
		keys.add(new KeyBoradBean("(", "(",1.0f));
		keys.add(new KeyBoradBean(")", ")",1.0f));
		
		return keys;
	}
	
	/**
	 * 字符键盘1
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initCharKeys2(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("'", "'",1.0f));
		keys.add(new KeyBoradBean("-", "-",1.0f));
		keys.add(new KeyBoradBean("/", "/",1.0f));
		keys.add(new KeyBoradBean(":", ":",1.0f));
		keys.add(new KeyBoradBean("_", "_",1.0f));
		keys.add(new KeyBoradBean("\"", "\"",1.0f));
		keys.add(new KeyBoradBean(".", ".",1.0f));
		keys.add(new KeyBoradBean(",", ",",1.0f));
		keys.add(new KeyBoradBean("?", "?",1.0f));
		return keys;
	}
	
	/**
	 * 字符键盘1
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initCharKeys3(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("`", "`",1.5f));
		keys.add(new KeyBoradBean("~", "~",1.0f));
		keys.add(new KeyBoradBean("{", "{",1.0f));
		keys.add(new KeyBoradBean("}", "}",1.0f));
		keys.add(new KeyBoradBean("[", "[",1.0f));
		keys.add(new KeyBoradBean("]", "]",1.0f));
		keys.add(new KeyBoradBean("<", "<",1.0f));
		keys.add(new KeyBoradBean(">", ">",1.0f));
		keys.add(new KeyBoradBean("+", "+",1.5f));
		return keys;
	}
	
	/**
	 * 字符键盘1
	 * date 2016-3-9下午4:30:11
	 * params @param isUpperCase
	 * params @return
	 * return ArrayList<KeyBoradBean>
	 */
	private ArrayList<KeyBoradBean> initCharKeys4(){
		ArrayList<KeyBoradBean> keys=new ArrayList<KeyBoradBean>();
		keys.add(new KeyBoradBean("zimu", R.drawable.key_abc_white,3.0f));
		keys.add(new KeyBoradBean("kongge",R.drawable.key_kongge,5.0f));
		keys.add(new KeyBoradBean("chexiao", R.drawable.key_delete_white,3.0f));
		return keys;
	}
	
	/**
	 * 正常文字�?
	 * date 2016-3-9下午4:31:40
	 * params @param key
	 * params @return
	 * return View
	 */
	private View initTextView(KeyBoradBean key){
		View v=LayoutInflater.from(ctx).inflate(R.layout.keyboard_textview_item, null);
		TextView tv=(TextView) v.findViewById(R.id.tv_item);
		LayoutParams params=new LayoutParams(0, LayoutParams.WRAP_CONTENT, key.getWidth());
		v.setLayoutParams(params);
		if(key.getStr()!=null){
			tv.setText(key.getStr());
			v.setTag(key.getCode());
		}
		setOnclick(v,null,tv);
		allViews.add(v);
		return v;
	}
	
	/**
	 * 正常图片�?
	 * date 2016-3-9下午4:31:40
	 * params @param key
	 * params @return
	 * return View
	 */
	private View initImageView(KeyBoradBean key){
		View v=LayoutInflater.from(ctx).inflate(R.layout.keyboard_imageview_item, null);
		ImageView iv=(ImageView) v.findViewById(R.id.iv_item);
		LayoutParams params=new LayoutParams(0, LayoutParams.WRAP_CONTENT, key.getWidth());
		v.setLayoutParams(params);
		if(key.getStr()==null){
			iv.setImageResource(key.getIcon());
			v.setTag(key.getCode());
		}
		setOnclick(v,null,null);
		allViews.add(v);
		return v;
	}
	
	/**
	 * 椭圆文字�?
	 * date 2016-3-9下午4:31:40
	 * params @param key
	 * params @return
	 * return View
	 */
	private View initFilletTextView(KeyBoradBean key){
		View v=LayoutInflater.from(ctx).inflate(R.layout.keyboard_fillet_textview_item, null);
		TextView tv=(TextView) v.findViewById(R.id.tv_item);
		LayoutParams params=new LayoutParams(0, LayoutParams.WRAP_CONTENT, key.getWidth());
		v.setLayoutParams(params);
		if(key.getStr()!=null){
			tv.setText(key.getStr());
			v.setTag(key.getCode());
		}
		setOnclick(v,null,tv);
		allViews.add(v);
		return v;
	}
	
	/**
	 * 椭圆图片�?
	 * date 2016-3-9下午4:31:40
	 * params @param key
	 * params @return
	 * return View
	 */
	private View initFilletImageView(KeyBoradBean key){
		View v=LayoutInflater.from(ctx).inflate(R.layout.keyboard_fillet_imageview_item, null);
		ImageView iv=(ImageView) v.findViewById(R.id.iv_item);
		LayoutParams params=new LayoutParams(0, LayoutParams.WRAP_CONTENT, key.getWidth());
		v.setLayoutParams(params);
		if(key.getStr()==null){
			if(key.getCode().equals("shift")){
				if(isShift){
					iv.setImageResource(R.drawable.key_shift_black);
				}else{
					iv.setImageResource(R.drawable.key_shift_white);
				}
			}else{
				iv.setImageResource(key.getIcon());
			}
			v.setTag(key.getCode());
		}
		setOnclick(v,iv,null);
		allViews.add(v);
		return v;
	}
	
	/**
	 * 键点击事�?
	 * date 2016-3-9下午4:34:53
	 * params @param v
	 * params @param iv
	 * return void
	 */
	private void setOnclick(View v,final ImageView iv,final TextView tv){
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String tag=(String) v.getTag();
				String etStr=et.getText().toString();
				switch (tag) {
				case "zimu"://字母
					allViews.clear();
					ll_keyboard1.removeAllViews();
					ll_keyboard2.removeAllViews();
					ll_keyboard3.removeAllViews();
					ll_keyboard4.removeAllViews();
					initLL(ll_keyboard1, 3,3,3,0, initFilletKeys(initletterKeys1(false)));
					initLL(ll_keyboard2, 15,0,15,0, initFilletKeys(initletterKeys2(false)));
					initLL(ll_keyboard3, 3,0,3,0, initFilletKeys(initletterKeys3(false)));
					initLL(ll_keyboard4,3,0,3,3, initFilletKeys(initletterKeys4()));
					break;
				case "chexiao"://撤销
					if(etStr.length()>0){
						etStr=etStr.substring(0, etStr.length()-1);
						et.setText(etStr);
					}
					break;
				case "123"://数字
					allViews.clear();
					ll_keyboard1.removeAllViews();
					ll_keyboard2.removeAllViews();
					ll_keyboard3.removeAllViews();
					ll_keyboard4.removeAllViews();
					initLL(ll_keyboard1,1,1,1,0,initKeys(initNumberKeys1()));
					initLL(ll_keyboard2, 1,0,1,0,initKeys(initNumberKeys2()));
					initLL(ll_keyboard3,1,0,1,0, initKeys(initNumberKeys3()));
					initLL(ll_keyboard4,1,0,1,1, initKeys(initNumberKeys4()));
					break;
				case "zifu"://字符
					allViews.clear();
					ll_keyboard1.removeAllViews();
					ll_keyboard2.removeAllViews();
					ll_keyboard3.removeAllViews();
					ll_keyboard4.removeAllViews();
					initLL(ll_keyboard1,3,3,3,0, initFilletKeys(initCharKeys1()));
					initLL(ll_keyboard2,15,0,15,0, initFilletKeys(initCharKeys2()));
					initLL(ll_keyboard3,3,0,3,0, initFilletKeys(initCharKeys3()));
					initLL(ll_keyboard4,3,0,3,3, initFilletKeys(initCharKeys4()));
					break;
				case "shift"://大小�?
					isShift=!isShift;
					if(iv!=null){
						if(isShift){
							iv.setImageResource(R.drawable.key_shift_black);
							allViews.clear();
							ll_keyboard1.removeAllViews();
							ll_keyboard2.removeAllViews();
							ll_keyboard3.removeAllViews();
							ll_keyboard4.removeAllViews();
							initLL(ll_keyboard1,3,3,3,0, initFilletKeys(initletterKeys1(true)));
							initLL(ll_keyboard2,15,0,15,0, initFilletKeys(initletterKeys2(true)));
							initLL(ll_keyboard3,3,0,3,0, initFilletKeys(initletterKeys3(true)));
							initLL(ll_keyboard4,3,0,3,3, initFilletKeys(initletterKeys4()));
						}else{
							iv.setImageResource(R.drawable.key_shift_white);
							allViews.clear();
							ll_keyboard1.removeAllViews();
							ll_keyboard2.removeAllViews();
							ll_keyboard3.removeAllViews();
							ll_keyboard4.removeAllViews();
							initLL(ll_keyboard1,3,3,3,0, initFilletKeys(initletterKeys1(false)));
							initLL(ll_keyboard2,15,0,15,0, initFilletKeys(initletterKeys2(false)));
							initLL(ll_keyboard3,3,0,3,0, initFilletKeys(initletterKeys3(false)));
							initLL(ll_keyboard4,3,0,3,3, initFilletKeys(initletterKeys4()));
						}
					}
					break;
				case "kongge":
					break;
				default:
					et.setText(etStr+tag);
					break;
				}
				Editable etext = et.getText();
				Selection.setSelection(etext, etext.length());
				}
		});
		
	}
	
	/**
	 * 初始化键�?
	 * date 2016-3-9下午4:35:07
	 * params @param keys
	 * params @return
	 * return List<View>
	 */
	private List<View> initKeys(List<KeyBoradBean> keys){
		ArrayList<View> views=new ArrayList<View>();
		for(KeyBoradBean key:keys){
			if(key.getStr()!=null){
				views.add(initTextView(key));
			}else{
				views.add(initImageView(key));
			}
		}
		return views;
	}
	
	/**
	 * 初始化椭圆键�?
	 * date 2016-3-9下午4:35:07
	 * params @param keys
	 * params @return
	 * return List<View>
	 */
	private List<View> initFilletKeys(List<KeyBoradBean> keys){
		ArrayList<View> views=new ArrayList<View>();
		for(KeyBoradBean key:keys){
			if(key.getStr()!=null){
				views.add(initFilletTextView(key));
			}else{
				views.add(initFilletImageView(key));
			}
		}
		return views;
	}
	
	
	/**
	 * 初始化布�?
	 * date 2016-3-9下午4:35:32
	 * params @param ll
	 * params @param left
	 * params @param top
	 * params @param right
	 * params @param bottom
	 * params @param views
	 * return void
	 */
	private void initLL(LinearLayout ll,int left,int top,int right,int bottom,List<View> views){
		ll.setPadding(left, top, right, bottom);
		for(int i=0;i<views.size();i++){
			ll.addView(views.get(i), i);
		}
	}
	
}
