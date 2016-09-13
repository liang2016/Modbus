package com.serotonin.modbus4j.locator;

import java.nio.charset.Charset;

import com.serotonin.modbus4j.base.ModbusUtils;
import com.serotonin.modbus4j.base.RangeAndOffset;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.serotonin.modbus4j.exception.ModbusIdException;
import com.serotonin.modbus4j.exception.ModbusTransportException;

abstract public class BaseLocator<T> {
    //
    //
    // Factory methods
    //
    public static BaseLocator<Boolean> coilStatus(int slaveId, int offset) {
        return new BinaryLocator(slaveId, RegisterRange.COIL_STATUS, offset);
    }

    public static BaseLocator<Boolean> inputStatus(int slaveId, int offset) {
        return new BinaryLocator(slaveId, RegisterRange.INPUT_STATUS, offset);
    }

    public static BaseLocator<Number> inputRegister(int slaveId, int offset, int dataType) {
        return new NumericLocator(slaveId, RegisterRange.INPUT_REGISTER, offset, dataType);
    }

    public static BaseLocator<Boolean> inputRegisterBit(int slaveId, int offset, int bit) {
        return new BinaryLocator(slaveId, RegisterRange.INPUT_REGISTER, offset, bit);
    }

    public static BaseLocator<Number> holdingRegister(int slaveId, int offset, int dataType) {
        return new NumericLocator(slaveId, RegisterRange.HOLDING_REGISTER, offset, dataType);
    }
    public static BaseLocator<Number> holdingRegister_88(int slaveId, int offset, int dataType,long timestamp) {
        return new NumericLocator(slaveId, RegisterRange.HOLDING_REGISTER_88, offset, timestamp,dataType);
    }
    public static BaseLocator<Boolean> holdingRegisterBit(int slaveId, int offset, int bit) {
        return new BinaryLocator(slaveId, RegisterRange.HOLDING_REGISTER, offset, bit);
    }

    public static BaseLocator<?> createLocator(int slaveId, int registerId, int dataType, int bit, int registerCount) {
        RangeAndOffset rao = new RangeAndOffset(registerId);
        return createLocator(slaveId, rao.getRange(), rao.getOffset(), dataType, bit, registerCount,
                StringLocator.ASCII);
    }

    public static BaseLocator<?> createLocator(int slaveId, int registerId, int dataType, int bit, int registerCount,
            Charset charset) {
        RangeAndOffset rao = new RangeAndOffset(registerId);
        return createLocator(slaveId, rao.getRange(), rao.getOffset(), dataType, bit, registerCount, charset);
    }

    public static BaseLocator<?> createLocator(int slaveId, int range, int offset, int dataType, int bit,
            int registerCount) {
        return createLocator(slaveId, range, offset, dataType, bit, registerCount, StringLocator.ASCII);
    }

    public static BaseLocator<?> createLocator(int slaveId, int range, int offset, int dataType, int bit,
            int registerCount, Charset charset) {
        if (dataType == DataType.BINARY) {
            if (BinaryLocator.isBinaryRange(range))
                return new BinaryLocator(slaveId, range, offset);
            return new BinaryLocator(slaveId, range, offset, bit);
        }
        if (dataType == DataType.CHAR || dataType == DataType.VARCHAR)
            return new StringLocator(slaveId, range, offset, dataType, registerCount, charset);
        return new NumericLocator(slaveId, range, offset, dataType);
    }
    public static BaseLocator<?> createLocator(int slaveId, int range, int offset, long timestamp,int dataType, int bit,
            int registerCount, Charset charset) {
        if (dataType == DataType.BINARY) {
        	//TODO:add time
            if (BinaryLocator.isBinaryRange(range))
                return new BinaryLocator(slaveId, range, offset,timestamp);
            return new BinaryLocator(slaveId, range, offset,timestamp, bit);
        }
    	//TODO:add time
        if (dataType == DataType.CHAR || dataType == DataType.VARCHAR){
            return new StringLocator(slaveId, range, offset,timestamp, dataType, registerCount, charset);
        }
        return new NumericLocator(slaveId, range, offset,timestamp, dataType);
    }
    private final int slaveId;
    protected final int range;
    protected final int offset;
    protected final long timestamp;
    public BaseLocator(int slaveId, int range, int offset) {
        this.slaveId = slaveId;
        this.range = range;
        this.offset = offset;
        this.timestamp=0xffffffff;//	// TODO: handle exception
    }
    public BaseLocator(int slaveId, int range, int offset,long timestamp) {
        this.slaveId = slaveId;
        this.range = range;
        this.offset = offset;
        this.timestamp=timestamp;
    }
    protected void validate(int registerCount) {
        try {
            ModbusUtils.validateOffset(offset);
            ModbusUtils.validateEndOffset(offset + registerCount - 1);
        }
        catch (ModbusTransportException e) {
            throw new ModbusIdException(e);
        }
    }

    abstract public int getDataType();

    abstract public int getRegisterCount();

    public int getSlaveId() {
        return slaveId;
    }

    public int getRange() {
        return range;
    }

    public int getOffset() {
        return offset;
    }

    //    public SlaveAndRange getSlaveAndRange() {
    //        return slaveAndRange;
    //    }

    public long getTimestamp() {
		return timestamp;
	}
    
	public int getEndOffset() {
        return offset + getRegisterCount() - 1;
    }

    public T bytesToValue(byte[] data, int requestOffset) {
        // Determined the offset normalized to the response data.
        return bytesToValueRealOffset(data, offset - requestOffset);
    }

    abstract public T bytesToValueRealOffset(byte[] data, int offset);

    abstract public short[] valueToShorts(T value);
}
