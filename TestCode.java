import java.io.*;
public class TestCode
{
	public static void TestCheckValidDay()
	{
		boolean actual;
		actual=ProductionCode.CheckValidDay(1,4,2004);
		assert actual==true: "Sth is wrong with CheckValidDay(1,4,2004). ";
		actual=ProductionCode.CheckValidDay(31,4,2004);
		assert actual==false: "Sth is wrong with CheckValidDay(31,4,2004). ";
		actual=ProductionCode.CheckValidDay(1,1,2004);
		assert actual==true: "Sth is wrong with CheckValidDay(1,1,2004). ";
		actual=ProductionCode.CheckValidDay(32,1,2004);
		assert actual==false: "Sth is wrong with CheckValidDay(32,1,2004). ";
		actual=ProductionCode.CheckValidDay(1,2,2004);
		assert actual==true: "Sth is wrong with CheckValidDay(1,2,2004). ";
		actual=ProductionCode.CheckValidDay(30,2,2004);
		assert actual==false: "Sth is wrong with CheckValidDay(30,2,2004). ";
		actual=ProductionCode.CheckValidDay(1,2,2003);
		assert actual==true: "Sth is wrong with CheckValidDay(1,2,2003). ";
		actual=ProductionCode.CheckValidDay(30,2,2003);
		assert actual==false: "Sth is wrong with CheckValidDay(30,2,2003). ";
		actual=ProductionCode.CheckValidDay(0,1,2004);
		assert actual==false: "Sth is wrong with CheckValidDay(0,1,2004). ";
		
		//White box testing
		actual=ProductionCode.CheckValidDay(1,1,2004);
		assert actual==true: "This is wrong.";
		actual=ProductionCode.CheckValidDay(-1,-1,2004);
		assert actual==false: "This is wrong.";
		actual=ProductionCode.CheckValidDay(1,4,2004);
		assert actual==true: "This is wrong.";
		actual=ProductionCode.CheckValidDay(-1,4,2004);
		assert actual==false: "This is wrong.";
		actual=ProductionCode.CheckValidDay(1,2,2004);
		assert actual==true: "This is wrong.";
		actual=ProductionCode.CheckValidDay(4,1,2003);
		assert actual==true: "This is wrong.";
		actual=ProductionCode.CheckValidDay(0,0,0);
		assert actual==false: "This is wrong.";
	}
	
	public static void TestCheckValidMonth()
	{
		boolean actual;
		actual=ProductionCode.CheckValidMonth(1);
		assert actual==true: "There's a mistake in CheckValidMonth(1)";
		actual=ProductionCode.CheckValidMonth(0);
		assert actual==false: "There's a mistake in CheckValidMonth(0)";
		actual=ProductionCode.CheckValidMonth(13);
		assert actual==false: "There's a mistake in CheckValidMonth(13)";
	}
	
	public static void TestCheckValidYear()
	{
		boolean actual;
		actual=ProductionCode.CheckValidYear(1902);
		assert actual==true: "There's a mistake in CheckValidYear(1902)";
		actual=ProductionCode.CheckValidYear(1900);
		assert actual==false: "There is a mistake in CheckValidYear(1900)";
		actual=ProductionCode.CheckValidYear(2025);
		assert actual==false: "There is a mistake in CheckValidYear(2025)";
		actual=ProductionCode.CheckValidYear(3213);
		assert actual==false: "There is a mistake in CheckValidYear(3213)";
	}
	
	public static void TestCalLifePathNum()
	{
		int actual;
		actual=ProductionCode.CalLifePathNum(10,1,2004);
		assert actual==8 : "Sth wrong with LifePathNum(10,1,2004)";
		actual=ProductionCode.CalLifePathNum(3,2,2004);
		assert actual==11 : "Sth wrong with LifePathNum(3,2,2004)";
		actual=ProductionCode.CalLifePathNum(3,1,2004);
		assert actual==1 : "Sth wrong with LifePathNum(3,1,2004)";
		
		//White box testing
		actual=ProductionCode.CalLifePathNum(11,11,1901);
		assert actual==33 : "This is wrong";
		actual=ProductionCode.CalLifePathNum(11,11,1999);
		assert actual==5 : "This is wrong";
		actual=ProductionCode.CalLifePathNum(11,9,2000);
		assert actual==22 : "This is wrong";
		actual=ProductionCode.CalLifePathNum(11,9,2001);
		assert actual==5 : "This is wrong";
		actual=ProductionCode.CalLifePathNum(18,11,2000);
		assert actual==22 : "This is wrong";
		actual=ProductionCode.CalLifePathNum(18,11,2001);
		assert actual==5 : "This is wrong";
	}
	
	public static void TestIsMasterNumber()
	{
		// white box testing
		boolean actual;
		actual=ProductionCode.IsMasterNumber(11);
		assert actual==true: "Sth wrong with IsMasterNumber(11)";
		actual=ProductionCode.IsMasterNumber(22);
		assert actual==true: "Sth wrong with IsMasterNumber(22)";
		actual=ProductionCode.IsMasterNumber(33);
		assert actual==true: "Sth wrong with IsMasterNumber(33)";
		actual=ProductionCode.IsMasterNumber(9);
		assert actual==false: "Sth wrong with IsMasterNumber(9)";
	}
	
	public static void TestCalculateNumOfRows()
	{
		int row;
		row=ProductionCode.CalculateNumOfRows("LuckyColour.csv");
		assert row==12: "The row is wrong";
	} 
	
	public static void TestLuckyColour()
	{
		String colour;
		colour=ProductionCode.LuckyColour(1,12);
		assert colour.equals("Red"): "Lucky colour is wrong for life path number 1";
		colour=ProductionCode.LuckyColour(0,12);
		assert colour.equals("none"): "Lucky colour is wrong for life path number 0";
		colour=ProductionCode.LuckyColour(2,12);
		assert colour.equals("Orange"): "Lucky colour is wrong for life path number 2";
		colour=ProductionCode.LuckyColour(3,12);
		assert colour.equals("Yellow"): "Lucky colour is wrong for life path number 1";
	}
	
	public static void TestGeneration()
	{
		String gen;
		gen=ProductionCode.Generation(1902);
		assert gen.equals("Silent Generation"): "Sth is wrong with silent generation. ";
		gen=ProductionCode.Generation(1948);
		assert gen.equals("Baby Boomers"): "Sth is wrong with baby boomers. ";
		gen=ProductionCode.Generation(1970);
		assert gen.equals("Generation X"): "Sth is wrong with generation x. ";
		gen=ProductionCode.Generation(1990);
		assert gen.equals("Millennials"): "Sth is wrong with millennials. ";
		gen=ProductionCode.Generation(2000);
		assert gen.equals("Generation Z"): "Sth is wrong with generation z. ";
		gen=ProductionCode.Generation(2014);
		assert gen.equals("Generation Alpha"): "Sth is wrong with generation alpha. ";
		
		//BVA 
		gen=ProductionCode.Generation(1945);
		assert gen.equals("Silent Generation"): "Sth is wrong with silent generation. ";
		gen=ProductionCode.Generation(1946);
		assert gen.equals("Baby Boomers"): "Sth is wrong with baby boomers. ";
		gen=ProductionCode.Generation(1964);
		assert gen.equals("Baby Boomers"): "Sth is wrong with baby boomers. ";
		gen=ProductionCode.Generation(1965);
		assert gen.equals("Generation X"): "Sth is wrong with generation x. ";
		gen=ProductionCode.Generation(1979);
		assert gen.equals("Generation X"): "Sth is wrong with generation x. ";
		gen=ProductionCode.Generation(1980);
		assert gen.equals("Millennials"): "Sth is wrong with millennials. ";
		gen=ProductionCode.Generation(1994);
		assert gen.equals("Millennials"): "Sth is wrong with millennials. ";
		gen=ProductionCode.Generation(1995);
		assert gen.equals("Generation Z"): "Sth is wrong with generation z. ";
		gen=ProductionCode.Generation(2009);
		assert gen.equals("Generation Z"): "Sth is wrong with generation z. ";
		gen=ProductionCode.Generation(2010);
		assert gen.equals("Generation Alpha"): "Sth is wrong with generation alpha. ";
	}
	
	public static void main(String[] args)
	{
		TestCheckValidDay();
		TestCheckValidMonth();
		TestCheckValidYear();
		TestCalLifePathNum();
		TestIsMasterNumber();
		TestCalculateNumOfRows();
		TestLuckyColour();
		TestGeneration();
		System.out.println("You have passed the test!!");
		ProductionCode.Ask_User();
	}
}
