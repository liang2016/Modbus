/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2006-2011 Serotonin Software Technologies Inc. http://serotoninsoftware.com
 * @author Matthew Lohbihler
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.serotonin.modbus4j.msg;

import com.serotonin.modbus4j.base.ModbusUtils;
import com.serotonin.modbus4j.code.FunctionCode;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.util.queue.ByteQueue;

public class ReadHoldingRegisters_88Response extends ReadResponse {
	private long timestamp;
	private long nowTimestamp;
    public long getNowTimestamp() {
		return nowTimestamp;
	}

	public void setNowTimestamp(long nowTimestamp) {
		this.nowTimestamp = nowTimestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	ReadHoldingRegisters_88Response(int slaveId, byte[] data,long timestamp) throws ModbusTransportException {
        super(slaveId, data);
        this.timestamp=timestamp;
    }

    ReadHoldingRegisters_88Response(int slaveId) throws ModbusTransportException {
        super(slaveId);
    }

    @Override
    public byte getFunctionCode() {
        return FunctionCode.READ_HOLDING_REGISTERS_88;
    }
    @Override
    public void enhanceReadResponse(ByteQueue queue) {
    	byte[] time=new byte[4];
    	queue.pop(time);
    	short[] shortTime=convertToShorts(time);
    	timestamp=(shortTime[0]<<16)+(0xffff &shortTime[1]);
    	
    	queue.pop(time);
    	shortTime=convertToShorts(time);
    	nowTimestamp=(shortTime[0]<<16)+(0xffff &shortTime[1]);
    	//将时间赋值给父类
    	super.setTimes(new long[]{timestamp,nowTimestamp});

    }

	@Override
	protected int enhanceGetNumberOfBytes(ByteQueue queue) {
		byte[] num=new byte[2];
    	queue.pop(num);
    	short[] numberOfBytes=convertToShorts(num);
//		int num1=queue.pop()<<8;
//		int num2=queue.pop() & 0xffff;
		return numberOfBytes[0];
	}

	@Override
	protected void enhanceWriteResponse(ByteQueue queue) {
		ModbusUtils.pushShort(queue, (short)(0xffff & (timestamp>>16)));
		ModbusUtils.pushShort(queue, (short)(0xffff & timestamp));
		ModbusUtils.pushShort(queue, (short)(0xffff & (nowTimestamp>>16)));
		ModbusUtils.pushShort(queue, (short)(0xffff & nowTimestamp));
		
	}
}
