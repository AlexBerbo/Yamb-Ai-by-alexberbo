package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Response;

public class IgracResponse implements Response {
	private boolean moveOver;
	private boolean[] kockice;
	private FieldData fieldData;
	
	public IgracResponse(boolean moveOver, boolean[] kockice, FieldData fieldData) {
		super();
		this.moveOver=moveOver;
		this.kockice=kockice;
		this.fieldData=fieldData;
	}
	@Override
	public boolean isMoveOver() {
		return moveOver;
	}
	@Override
	public boolean[] getDice() {
		return kockice;
	}
	@Override
	public FieldData getFieldData() {
		return fieldData;
	}
}
