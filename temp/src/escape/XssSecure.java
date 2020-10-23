package escape;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class XssSecure {
	public XssSecure(){
		String a = "<scr3ipt>src=</scr3ipt>(lily)'z'z'";
		System.out.println("default : " + a);
		System.out.println("cleanXSS : " + cleanXSS(a));
		System.out.println("unescape : " + unescape(cleanXSS(a)));
		
		System.out.println("///////////////////////////////////");
		System.out.println("///////////////////////////////////");
		System.out.println("///////////////////////////////////");

		HashMap<String, Object> b = new HashMap<String, Object>();
		b.put(">", "&gt;");
		b.put("<", "&lt;");
		b.put("(", "&#40;");
		b.put(")", "&#41;");
		b.put("'", "&#39;");
		b.put(">_<", "&gt;_&lt;");
		b.put("i'm u", "i&#39;m u");
		b.put("()><'", "&#40;&#41;&gt;&lt;&#39;");

		System.out.println("default : " + b);
		System.out.println("unescape : " + unescape(b));
		
		System.out.println("///////////////////////////////////");
		System.out.println("///////////////////////////////////");
		System.out.println("///////////////////////////////////");
		
		String[] c = {"&gt;_&lt;", "i&#39;m u", "&#40;&#41;&gt;&lt;&#39;"};
		
		System.out.print("default : ");
		for(int i = 0 ; i < c.length ; i++){
			System.out.print(c[i]);
			if(i+1 != c.length)
				System.out.print(", ");
		}
		c = (String[])unescape(c);
		System.out.print("\nunescape : ");
		for(int i = 0 ; i < c.length ; i++){
			System.out.print(c[i]);
			if(i+1 != c.length)
				System.out.print(", ");
		}
		
	}

	
	public static Object unescape(Object obj){
		try{
			if(obj.getClass() == String.class)
				return convertXSS((String)obj);
			else if(obj.getClass() == String[].class){
					String[] res = (String[])obj;
					for(int i = 0 ; i < res.length ; i++)
						res[i] = (String)convertXSS(res[i]);
					return res;
			}
			else if(obj.getClass() == HashMap.class){
				@SuppressWarnings("unchecked")
				HashMap<Object, Object> res = (HashMap<Object, Object>)obj;
				res.entrySet().forEach(new Consumer<Entry<Object, Object>>() {
					@Override
					public void accept(Entry<Object, Object> entry) {
						entry.setValue(unescape(entry.getValue()));
					}
				});
				return res;
			}
			else{
				return obj;
			}
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	private static String convertXSS(String value){		
    	value = value.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
    	value = value.replaceAll("&#40;", "(").replaceAll("&#41;", ")");
    	value = value.replaceAll("&#39;", "'");
    	return value;
	}
	
	
    private String cleanXSS(String value) {
        //You'll need to remove the spaces from the html entities below
    	value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    	value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
    	value = value.replaceAll("'", "&#39;");
    	value = value.replaceAll("eval\\((.*)\\)", "");
    	value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
    	value = value.replaceAll("script", "");
    	
    	return value;
	}
}
