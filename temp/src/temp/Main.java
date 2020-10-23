package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@SuppressWarnings("unused")
public class Main {

	public Main(){
		post();
		
//		Vector<String> vs = new Vector<String>();
		//		System.out.println(a.substring(a.charAt(0)+1, a.charAt(a.length()-1)));
		
//		calculatePlus(1048575);
//		calculatePlus(1);
//		calculatePlus(1048575);
//		calculatePlus(1);

//		calculatePow(30);
//		calculatePow(1200);
		
//		System.out.println();
//		Calendar cl = Calendar.getInstance(Locale.JAPANESE);
		
//		System.out.println(Locale.getDefault());
//		System.out.println(cl.getCalendarType());
		
/*
		String str1 = "&lt;i love steak&gt;";
		String str2 = "i love steak";
		String str3 = "i love steak";
		String str4 = "i love steak";
		String str5 = "i love steak";
		String str6 = "i love steak";
		String str7 = "i love steak";
		String str8 = "i love steak";
		String str9 = "i love steak";
		String str0 = "i love steak";
		System.out.println(unescape(str1));
		System.out.println(str0.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println(str5.hashCode());
		System.out.println(str6.hashCode());
		System.out.println(str7.hashCode());
		System.out.println(str8.hashCode());
*/
	}
	
	public static void main(String[] args) {
		new Main();
/*		boolean a = true;
		boolean b = true;
		boolean c = true;
		boolean d = true;
		if((a = reverse(a)) && (b = reverse(b)) || (c = reverse(c)) || (d = reverse(d)))
			System.out.println("result is true");
		else
			System.out.println("result is false");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		*/
	}
	
	private static boolean reverse(boolean flag){
		if(flag)
			return false;
		else
			return true;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T a(T b){
		if(b.getClass() == String.class) {
			System.out.println("it is String");
			return (T) ((String)b + 1);
		}
		else if(b.getClass() == Integer.class) {
			System.out.println("it is Integer");
//			return (T) ((Integer)b + 1);
		}
		else if(b.getClass() == Map.class) {
			System.out.println("it is Map");
		}
		else if(b.getClass() == Vector.class) {
			System.out.println("it is Vector");
		}
		else
			System.out.println("i don't know !!");
		return b;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T unescape(T obj){
		try{
			if(obj.getClass() == String.class)
				return (T) convertXSS((String)obj);
			else if(obj.getClass() == String[].class){
					String[] res = (String[])obj;
					for(int i = 0 ; i < res.length ; i++)
						res[i] = (String)convertXSS(res[i]);
					return (T) res;
			}
			else if(obj instanceof HashMap){
				HashMap<Object, Object> res = (HashMap<Object, Object>)obj;
				res.forEach((a, b)->{
					res.replace(a, unescape(b));
				});
				return (T) res;
			}
			else {
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
	
	private void calculatePlus(int num){

		long start = Calendar.getInstance().getTimeInMillis();
		int j = 0;
		for(int k = 0 ; k < Integer.MAX_VALUE ; k++)
			for(int i = 0 ; i < Integer.MAX_VALUE ; i++)
				j = num + 1;
		System.out.println(j);
		System.out.println(Integer.toBinaryString(num) + " : "  + (start - Calendar.getInstance().getTimeInMillis()));
	}
	
	private void calculatePow(int num){
		long start = Calendar.getInstance().getTimeInMillis();
		for(int k = 0 ; k < Integer.MAX_VALUE ; k++)
			for(int i = 0 ; i < Integer.MAX_VALUE ; i++)
				Math.pow(2, num);
		System.out.println(num + " : "  + (start - Calendar.getInstance().getTimeInMillis()));
	}
	
	private void get() {
		try {
			HttpURLConnection conn = (HttpURLConnection)(new URL("http://localhost:8080/js/rest/ilove").openConnection());
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
//			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			
//			OutputStream os = conn.getOutputStream();
//			VO vo = new VO("a","name","description","makeCompany","distributeCompany",10);
//			os.write(vo.toString().getBytes("UTF-8"));
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String inputLine = null;
			StringBuffer outResult = new StringBuffer();
			while((inputLine = in.readLine()) != null)
				outResult.append(inputLine);
			System.out.println(outResult.toString());
			System.out.println(conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void post() {
		try {
			HttpURLConnection conn = (HttpURLConnection)(new URL("http://localhost:8080/js/rest/mango").openConnection());
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			
			OutputStream os = conn.getOutputStream();
			VO vo = new VO("abbbcc", "ilovesteak", "ireallylovesteak", "outback", "amazon", 99000);
			os.write(vo.toString().getBytes());
			System.out.println(vo.toString());
			os.flush();
			
			System.out.println(conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
