/*
    Copyright (C) 2006-2007 Serotonin Software Technologies Inc.
 	@author Matthew Lohbihler
 */
package com.serotonin.modbus4j.test;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

/**
 * @author Matthew Lohbihler
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        IpParameters params = new IpParameters();
        params.setHost("127.0.0.1");
        params.setPort(9977);

        ModbusMaster master = new ModbusFactory().createUdpMaster(params);
        master.init();

        System.out.println(master.testSlaveNode(1));

        // Define the point locator.
        BaseLocator<Number> loc = BaseLocator.holdingRegister(1, 0, DataType.TWO_BYTE_INT_UNSIGNED);

        // Set the point value
        master.setValue(loc, 1800);

        // Get the point value
        System.out.println(master.getValue(loc));
    }
}
