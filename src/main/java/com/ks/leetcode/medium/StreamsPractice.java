package com.ks.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamsPractice {
	
	private String name;
	private String type;
	private int quantity;
	private int amount;
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getAmount() {
		return String.valueOf(amount);
	}

	public static int getCash() {
		return cash;
	}

	private static int cash;
	
	public StreamsPractice(String name, String type, int quantity, int amount) {
		this.name=name;
		this.type=type;
		this.quantity=quantity;
		this.amount= amount;	
	}
	
		final static List<StreamsPractice> values=new ArrayList<>();
		static {
		values.add(new StreamsPractice("iphone","SELL",2,30));
		values.add(new StreamsPractice("iphone","BUY",3,20));
		values.add(new StreamsPractice("galaxy","SELL",3,40));
		values.add(new StreamsPractice("galaxy","BUY",3,40));
		values.add(new StreamsPractice("pixel","SELL",4,50));
		values.add(new StreamsPractice("pixel","BUY",1,90));
		values.add(new StreamsPractice("pixel","SELL",2,50));
		values.add(new StreamsPractice(null,"DEP",0,2000));
		values.add(new StreamsPractice(null,"WDL",0,10));		
	}
	
	public static void caluculateTotalCash() {
			int cash=
				values.stream()
				.mapToInt(value ->{
					if(value.type=="SELL" || value.type=="DEP") return value.amount;
					else return -value.amount;})
				.sum();
		StreamsPractice.cash=cash;
		System.out.println("cash is="+cash);
		}
	
	public static void calcTotalSellAmount() {
		
		int sellAmount = values.stream()
				.filter(value->value.type.equals("SELL"))
				.mapToInt(value->value.amount)
				.sum();
	System.out.println("total sell amount="+sellAmount);
	}

	public static void calcItemizedTrades() {
		
		Map<String, Integer>itemizedTrades=values.stream()
		.filter(value->value.name!=null)
		.collect(Collectors.groupingBy(StreamsPractice::getName,Collectors.summingInt(StreamsPractice::getQuantity)));
		System.out.println("itemized trades"+itemizedTrades);
	} 
	
	public static void groupingByPratice() {
		
		//in mapping function 
		 Map<String,Map<String,Double>>map =values.stream()
		.filter(value->value.name!=null)
		.collect(Collectors.groupingBy(StreamsPractice::getName,
				Collectors.groupingBy(StreamsPractice::getType,
				Collectors.summingDouble(StreamsPractice::getQuantity))));
	
	System.out.println(map);
	}
	
	public static void main(String[] args) {	
		//StreamsPractice.caluculateTotalCash();
		//StreamsPractice.calcTotalSellAmount();
		
		//StreamsPractice.calcItemizedTrades();
		StreamsPractice.groupingByPratice();
	}
	
}

