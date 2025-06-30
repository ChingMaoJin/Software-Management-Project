import java.util.*;
import java.io.*;
public class ProductionCode
{	
	public static boolean CheckValidDay(int pDay, int pMonth, int pYear)
	{
		boolean isValid=false;
		int [] MonthWith30Days={4,6,9,11};
		int [] MonthWith31Days={1,3,5,7,8,10,12};
		boolean isLeapYear;
		isLeapYear=(pYear%4==0);
		for(int x=0; x<MonthWith31Days.length; x++)
		{
			if(pDay>0 && pDay<=31 && pMonth==MonthWith31Days[x])
			{
				isValid=true;
			}
		}
		
		for(int y=0; y<MonthWith30Days.length; y++)
		{
			if(pDay>0 && pDay<=30 && pMonth==MonthWith30Days[y])
			{
				isValid=true;
			}
		}
		
		if(isLeapYear && pMonth==2 && pDay<=29 && pDay>0)
		{
			isValid=true;
		}
		
		else if(!isLeapYear && pMonth==2 && pDay<=28 && pDay>0)
		{
			isValid=true;
		}
		
		return isValid;
	}
	
	public static boolean CheckValidMonth(int pMonth)
	{
		boolean isValid;
		if(pMonth>0 && pMonth<13)
		{
			isValid=true;
		}
		
		else
		{
			isValid=false;
		}
		return isValid;
	}
	
	public static boolean CheckValidYear(int pYear)
	{
		boolean isValid;
		if(pYear>=1901 && pYear<=2024)
		{
			isValid=true;
		}
		
		else 
		{
			isValid=false;
		}
		return isValid;
	}
	
	public static int CalLifePathNum(int pDay, int pMonth, int pYear)
	{
		String Day=Integer.toString(pDay);
		String Month=Integer.toString(pMonth);
		String Year=Integer.toString(pYear);
		char [] CDay=Day.toCharArray();
		char [] CMonth=Month.toCharArray();
		char [] CYear=Year.toCharArray();
		int [] IDay=new int[Day.length()];
		int [] IMonth=new int[Month.length()];
		int [] IYear=new int[Year.length()];
		int AddDays=0;
		int AddMonth=0;
		int AddYear=0;
		int LifePath=0;
		if(IsMasterNumber(pDay))
		{
			AddDays=pDay;
		}
		if(!IsMasterNumber(pDay))
		{
			for(int x=0; x<Day.length(); x++)
			{
				IDay[x]=Character.getNumericValue(CDay[x]);
			}
			if(Day.length()!=1)
			{
				AddDays=SumDay(IDay);
			}
			if(Day.length()==1)
			{
				AddDays=pDay;
			}
		}
		
		if(IsMasterNumber(pMonth))
		{
			AddMonth=pMonth;
		}
		
		if(!IsMasterNumber(pMonth))
		{
			for(int x=0; x<Month.length(); x++)
			{
				IMonth[x]=Character.getNumericValue(CMonth[x]);
			}
			if(Month.length()!=1)
			{
				AddMonth=IMonth[0] + IMonth[1];
			}
			if(Month.length()==1)
			{
				AddMonth=pMonth;
			}
		}
			
			
		for(int x=0; x<Year.length(); x++)
		{
			IYear[x]=Character.getNumericValue(CYear[x]);
		}
		AddYear=SumYear(IYear);
		LifePath=AddYear+AddMonth+AddDays;
		while(!IsMasterNumber(LifePath) && LifePath>9 && LifePath<100)
		{
			String StrLifePath=Integer.toString(LifePath);
			char [] CharLifePath=StrLifePath.toCharArray();
			int [] iLifePath=new int[StrLifePath.length()];
			for(int x=0; x<StrLifePath.length(); x++)
			{
				iLifePath[x]=Character.getNumericValue(CharLifePath[x]);
			}
			LifePath=iLifePath[0] + iLifePath[1];
		}
		return LifePath;
	}
	
	private static int SumDay(int [] pIDay)
	{
		int AddDay=pIDay[0]+pIDay[1];
		while(AddDay>9 && AddDay<100 && !IsMasterNumber(AddDay))
		{
			String StrDay=Integer.toString(AddDay);
			char [] CharDay=StrDay.toCharArray();
			int [] iDay=new int [StrDay.length()];
			for(int x=0; x<StrDay.length(); x++)
			{
				iDay[x]=Character.getNumericValue(CharDay[x]);
			}
			AddDay=iDay[0]+iDay[1];
		}
		return AddDay;
	}
	
	private static int SumYear(int [] pIYear)
	{
		int AddYear=pIYear[0]+pIYear[1]+pIYear[2]+pIYear[3];
		while(AddYear>9 && AddYear<100 && !IsMasterNumber(AddYear))
		{
				String StrYear=Integer.toString(AddYear);
				char [] CharYear=StrYear.toCharArray();
				int [] iYear=new int [StrYear.length()];
				AddYear=0;
				for(int x=0; x<StrYear.length(); x++)
				{
					iYear[x]=Character.getNumericValue(CharYear[x]);
					AddYear=iYear[x]+AddYear;
				}
		}
		return AddYear;
	}
	
	public static boolean IsMasterNumber(int Num)
	{
		boolean Master=false;
		if(Num==11 || Num==22 || Num==33)
		{
			Master=true;
		}
			
		else
		{
			Master=false;
		}
		return Master;
	}
	
	public static int CalculateNumOfRows(String pFileName)
	{
		String line;
		int LineNum=0;
		try
		{
			FileReader Read=new FileReader(pFileName);
			BufferedReader bufRdr=new BufferedReader(Read);
			line=bufRdr.readLine();
			line=bufRdr.readLine();
			while(line!=null)
			{
				LineNum++;
				line=bufRdr.readLine();
			}
			bufRdr.close();
		}
		
		catch(Exception e)
		{ 
			System.out.println(e.getMessage());
			LineNum=0;
		}
		return LineNum;
	}
	
	public static String LuckyColour(int pLifePath, int pLineNum)
	{
		String line;
		String [] [] Content=new String[pLineNum][2];
		String LuckyColour=null;
		String SLifePath=Integer.toString(pLifePath);
		try
		{
			FileReader Read=new FileReader("LuckyColour.csv");
			BufferedReader bufRdr=new BufferedReader(Read);
			line=bufRdr.readLine();
			line=bufRdr.readLine();
			for(int x=0; x<pLineNum; x++)
			{
				for(int y=0; y<2; y++)
				{
					Content[x][y]=line.split(",")[y];
					
				}
				line=bufRdr.readLine();
			}
			
			for(int a=0; a<pLineNum; a++)
			{	
				if(SLifePath.equals(Content[a][0]))
				{
					 LuckyColour= Content[a][1]; //que
				}	
				
			}
			
			if(pLifePath==0)
			{
				LuckyColour="none";
			}
			Read.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return LuckyColour;
	}	
	
	public static String Generation(int pYear)
	{
		String gen=null;
		if(pYear>=1901 && pYear<=1945)
		{
			gen="Silent Generation";
		}
		
		else if(pYear>=1946 && pYear<=1964)
		{
			gen="Baby Boomers";
		}
		
		else if(pYear>=1965 && pYear<=1979)
		{
			gen="Generation X";
		}
		
		else if(pYear>=1980 && pYear<=1994)
		{
			gen="Millennials";
		}
		
		else if(pYear>=1995 && pYear<=2009)
		{
			gen="Generation Z";
		}
		
		else
		{
			gen="Generation Alpha";
		}
		return gen;
	}
	
	public static void Ask_User()
	{
		Scanner sc=new Scanner(System.in);
		int Day=0;
		int Month=0;
		int Year=0;
		boolean isValid;
		do
		{
			System.out.println("Pls enter the valid month of your birthday: ");
			Month=sc.nextInt();
			isValid=CheckValidMonth(Month);
		}while(!isValid);
		
		do
		{
			System.out.println("Pls enter the valid year where you are born: ");
			Year=sc.nextInt();
			isValid=CheckValidYear(Year);
		}while(!isValid);
		
		do
		{
			System.out.println("Pls enter the valid day of your birthday: ");
			Day=sc.nextInt();
			isValid=CheckValidDay(Day,Month,Year);
		}while(!isValid);
		int LifePath=CalLifePathNum(Day, Month, Year);
		int Rows=CalculateNumOfRows("LuckyColour.csv");
		String LuckyColour=LuckyColour(LifePath, Rows);
		System.out.println("Your lucky colour is: " + LuckyColour);
		String gen=Generation(Year);
		System.out.println("You are in " + gen);
		sc.close();
	}
}
