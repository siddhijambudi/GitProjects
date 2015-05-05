// Copyright (c) 2015 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		ParkingSpotCount.java
 * Author:	sjambudi
 */

interface PARKING_SPOT_CONST{
	public static final int DISABLE = 1;
	public static final int REGULAR = 2;
	public static final int ELECTRIC = 3;
	public static final int OTHER = 4;
}
public abstract class ParkingSpotCountFactory
{
	public abstract int getParkingLotCount(int parkingSpotId);
	public abstract void useParkingLot(int parkingSpotId);
	public abstract void freeParkingLot(int parkingSpotId);
}
class SimpleParkingSpotFactory extends ParkingSpotCountFactory {
	
	static int disableLotCount;
	static int regularLotCount;
	static int electricLotCount;
	static int otherCount;
	
	int lotCapacity = 5;
	
	@Override
	public int getParkingLotCount(int parkingSpotId)
	{
		switch (parkingSpotId)
		{
			case PARKING_SPOT_CONST.DISABLE:
				return disableLotCount;
			case PARKING_SPOT_CONST.REGULAR:
				return regularLotCount;
			case PARKING_SPOT_CONST.ELECTRIC:
				return electricLotCount;
			case PARKING_SPOT_CONST.OTHER:
				return otherCount;
			default:
				throw new IllegalStateException("Not a valid parking lot id...");
		}
	}

	public void addCounter(int parkingSpotId)
	{
		if((disableLotCount + regularLotCount + electricLotCount + otherCount) > lotCapacity){
			throw new IllegalStateException("lot is full...");
		}
		switch(parkingSpotId){
			case PARKING_SPOT_CONST.DISABLE:
				disableLotCount++;
				break;
			case PARKING_SPOT_CONST.REGULAR:
				regularLotCount++;
				break;
			case PARKING_SPOT_CONST.ELECTRIC:
				electricLotCount++;
				break;
			case PARKING_SPOT_CONST.OTHER:
				otherCount++;		
				break;
			default:
				throw new IllegalStateException("Not a valid parking lot id...");
		}
	}
	
	public void subtractCounter(int parkingSpotId)
	{
		switch(parkingSpotId){
			case PARKING_SPOT_CONST.DISABLE:
				if(disableLotCount > 0)
					disableLotCount--;
				break;
			case PARKING_SPOT_CONST.REGULAR:
				if(regularLotCount > 0)
					regularLotCount--;
				break;
			case PARKING_SPOT_CONST.ELECTRIC:
				if(electricLotCount > 0 )
					electricLotCount--;
				break;
			case PARKING_SPOT_CONST.OTHER:
				if(otherCount > 0 )
					otherCount--;		
				break;
			default:
				throw new IllegalStateException("Not a valid parking lot id...");
		}
	}
	
	public void useParkingLot(int parkingSpotId){
		addCounter(parkingSpotId);
	}
	
	public void freeParkingLot(int parkingSpotId){
		subtractCounter(parkingSpotId);
	}
}
