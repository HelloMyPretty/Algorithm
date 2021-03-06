package ��126th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AMain {
	int time[]=new int[30];
	public List<String>commonChars(String []A) {
		Arrays.fill(time, 0xfff);
		List<String> list=new ArrayList<String>();
		
		for(int i=0;i<A.length;i++) {
			
			String cur=A[i];
			int num[]=new int[30];
			for(int j=0;j<cur.length();j++) {
				num[cur.charAt(j)-'a']++;
			}
			
			for(int j=0;j<26;j++)
				time[j]=Math.min(time[j], num[j]);
		}
		for(int i=0;i<26;i++) {
			for(int j=0;j<time[i];j++)
				if(time[i]!=0xfff)
				list.add(""+(char)(i+'a'));
		}
		return list;
	}
	public static void main(String[] args) {
		String[] test= {"cool","lock","cook"};
		List list=new AMain().commonChars(test);
		System.out.println(list);
	}
}
