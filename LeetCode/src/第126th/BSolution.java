package ��126th;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class BSolution {
	public boolean isValid(String S) {
		StringBuilder cur=new StringBuilder(S);
		String string="abc";
		boolean ok=true;
		while(ok) {
			int idx=cur.indexOf(string);
			if(idx==-1)
				ok=false;
			else cur=cur.delete(idx, idx+3);
			//System.out.println(cur);
			
			if(cur.length()==0) return ok;
		}
		return ok;
	}
	
	public static void main(String[] agrs) {
		String s="cababc";
		//System.out.print(new String(s).indexOf("xy"));
		System.out.println(new BSolution().isValid(s));
	}
}
