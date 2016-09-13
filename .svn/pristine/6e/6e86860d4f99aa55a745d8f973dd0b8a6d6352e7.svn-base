/*
    Copyright (C) 2006-2007 Serotonin Software Technologies Inc.
 	@author Matthew Lohbihler
 */
package com.serotonin.modbus4j.test;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

/**
 * @author Matthew Lohbihler
 */
public class MasterTest2 {
	public static void main(String[] args) throws Exception {
		IpParameters ipParameters = new IpParameters();
		ipParameters.setHost("localhost");
		// ipParameters.setHost("99.247.60.96");
		// ipParameters.setHost("193.109.41.121");
		// ipParameters.setHost("141.211.194.29");
		ipParameters.setPort(9977);

		ModbusFactory modbusFactory = new ModbusFactory();
		// ModbusMaster master = modbusFactory.createTcpMaster(ipParameters,
		// true);
		ModbusMaster master = modbusFactory.createUdpMaster(ipParameters);
		master.setTimeout(5000);
		master.setRetries(3);

		BatchRead<Integer> batch = new BatchRead<Integer>();
		// batch.addLocator(0, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 2048, DataType.BINARY));
		// batch.addLocator(1, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 2049, DataType.BINARY));
		// batch.addLocator(2, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 2050, DataType.BINARY));
		// batch.addLocator(3, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3584, DataType.BINARY));
		// batch.addLocator(4, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3585, DataType.BINARY));
		// batch.addLocator(5, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3648, DataType.BINARY));
		// batch.addLocator(6, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3649, DataType.BINARY));
		// batch.addLocator(7, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3650, DataType.BINARY));
		// batch.addLocator(8, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3651, DataType.BINARY));
		// batch.addLocator(9, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3652, DataType.BINARY));
		// batch.addLocator(10, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3653, DataType.BINARY));
		// batch.addLocator(11, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3654, DataType.BINARY));
		// batch.addLocator(12, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3661, DataType.BINARY));
		// batch.addLocator(13, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3662, DataType.BINARY));
		// batch.addLocator(15, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3665, DataType.BINARY));
		// batch.addLocator(16, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3668, DataType.BINARY));
		// batch.addLocator(18, new ModbusLocator(1, RegisterRange.COIL_STATUS,
		// 3969, DataType.BINARY));
		long timestamp = 1354934900l;//1350000000
//		batch.addLocator(0, BaseLocator.holdingRegister(1, 40001,
//				DataType.EIGHT_BYTE_FLOAT));
//		batch.addLocator(1, BaseLocator.holdingRegister(1, 40002,
//				DataType.EIGHT_BYTE_INT_SIGNED));
		batch.addLocator(1, BaseLocator.holdingRegister_88(1, 40005,
				DataType.TWO_BYTE_INT_UNSIGNED,timestamp));
		batch.addLocator(2, BaseLocator.holdingRegister_88(1, 40003,
				DataType.TWO_BYTE_INT_UNSIGNED,timestamp));

		try {
			master.init();
			BatchResults<Integer> results = master.send(batch);
			System.out.println("get results:"+results.getValue(1));

		} catch (ErrorResponseException e) {
			System.out.println(e.getErrorResponse().getExceptionMessage());
		} finally {
			master.destroy();
		} 
		
	}
}
