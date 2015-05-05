// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		ParkingLotCount.java
 * Author:	sjambudi
 */


public class ParkingLotCount
{
	public static void main(String args[]){
		
		int disableCount = 0;
		int regularCount = 0 ;
		int electricCount = 0;
		int otherCount =0;
		
		ParkingSpotCountFactory factory = new SimpleParkingSpotFactory();
		
		factory.useParkingLot(1);
		factory.useParkingLot(1);
		factory.useParkingLot(1);
		
		factory.useParkingLot(2);
		factory.useParkingLot(3);
		factory.useParkingLot(4);
		
		factory.freeParkingLot(2);
		factory.useParkingLot(2);
		
		disableCount= factory.getParkingLotCount(1);
		regularCount = factory.getParkingLotCount(2);
		electricCount = factory.getParkingLotCount(3);
		otherCount = factory.getParkingLotCount(4);
		
		System.out.println(disableCount);
		System.out.println(regularCount);
		System.out.println(electricCount);
		System.out.println(otherCount);
	}
}

