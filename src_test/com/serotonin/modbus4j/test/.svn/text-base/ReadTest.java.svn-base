/*
    Copyright (C) 2006-2007 Serotonin Software Technologies Inc.
 	@author Matthew Lohbihler
 */
package com.serotonin.modbus4j.test;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ReadResponse;
import com.serotonin.modbus4j.code.RegisterRange;

/**读取测试
 * @author Matthew Lohbihler
 */
public class ReadTest {
    public static void main(String[] args) throws Exception {
        IpParameters ipParameters = new IpParameters();
        // ipParameters.setHost("99.247.60.96");
        // ipParameters.setHost("193.109.41.121");
        ipParameters.setHost("127.0.0.1");
        ipParameters.setPort(9977);
        ipParameters.setEncapsulated(true);//设置封装

        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createUdpMaster(ipParameters);
       // ModbusMaster master = modbusFactory.createTcpMaster(ipParameters, false);
        master.setTimeout(500);
        master.setRetries(5);
        master.init();

        for (int i = 1; i < 5; i++) {
          //  System.out.print("Testing " + i + "... ");
           // System.out.println(master.testSlaveNode(i));
           // BatchRead batchRead= new BatchRead<Integer>();
          //  BatchResults<Integer> results = master.send(batchRead);
          //  System.out.println(results);
            
            ModbusRequest mreq = new ModbusFactory().createReadRequest(1, RegisterRange.HOLDING_REGISTER, 40001, 10);

            master.init();
            ReadResponse mres = (ReadResponse) master.send(mreq);
            System.out.println(mres.getSlaveId());
            System.out.println(mres.getBooleanData());
            System.out.println(mres.getData());
        }

        // try {
        // System.out.println(master.send(new ReadHoldingRegistersRequest(1, 0, 1)));
        // }
        // catch (Exception e) {
        // e.printStackTrace();
        // }

        // try {
        // // ReadCoilsRequest request = new ReadCoilsRequest(2, 65534, 1);
        // ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master
        // .send(new ReadHoldingRegistersRequest(2, 0, 1));
        // System.out.println(response);
        // }
        // catch (Exception e) {
        // e.printStackTrace();
        // }

        // System.out.println(master.scanForSlaveNodes());

        master.destroy();
    }
}
