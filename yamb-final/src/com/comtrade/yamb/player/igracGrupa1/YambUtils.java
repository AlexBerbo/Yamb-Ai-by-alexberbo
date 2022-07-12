package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Die;
import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.RequestType;

public class YambUtils {
	public static int[] generisiBrojacKockica(Request request) {
		int[] brojacKockica = null;
		if(request.getType()==RequestType.THROW) {
			Die[] kockica=request.getDice();
			int i;
			brojacKockica=new int[Constants.DICE_COUNT+1];
	
		for(i=0;i<Constants.DICE_COUNT;i++) {
			brojacKockica[kockica[i].getValue()]++;
			}
		}
		return brojacKockica;
	}
	
	public static boolean ucestalostBrojeva(Request request, int broj, int minUslov) {
		int[] brojKockica;
		brojKockica=generisiBrojacKockica(request);
		
		boolean brojevi=false;
		
		for(int i=1; i<=Constants.DICE_COUNT; i++) {
			if(brojKockica[broj]>=minUslov) {
				brojevi=true;
			}
		}
		return brojevi;
	}
	
	public static boolean isPlayable(Request request, int kolona, int red) {
		return request.getBoard().getColumns()[kolona].getFields().get(red).isPlayable();
	}
	
	public static boolean isNotPlayable(Request request, int kolona, int red) {
		return !request.getBoard().getColumns()[kolona].getFields().get(red).isPlayable();
	}
	
	public static boolean isPlayed(Request request, int kolona, int red) {
		return request.getBoard().getColumns()[kolona].getFields().get(red).isPlayed();
	}
	
	public static int vrednostPolja(Request request, int kolona, int red) {
		return request.getBoard().getColumns()[kolona].getFields().get(red).getValue();
	}
	
	public static IgracResponse findResponseByPriorityPrvo(int[] redosled, Request request, int red, int kockica) {
		YambMetode metode=new YambMetode(request);
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red)) {
				if(redosled[i]==6) {
					return new IgracResponse(true, null, new FieldData(redosled[i], red));
				}
				if(redosled[i]==5) {
					return new IgracResponse(false, metode.cuvajKockice(kockica), new FieldData(redosled[i], red));
				}
				return new IgracResponse(false, metode.cuvajKockice(kockica), null);
			}
		}
		return null;
	}
	
	public static IgracResponse findResponseByPriorityDrugo(int[] redosled, Request request, int red, int kockica) {
		YambMetode metode=new YambMetode(request);
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red))
				return new IgracResponse(false, metode.cuvajKockice(kockica), null);
		}
		return null;
	}
	
	public static IgracResponse findResponseByPriorityTrece(int[] redosled, Request request, int red) {
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red))
				return new IgracResponse(true, null, new FieldData(redosled[i], red));
		}
		return null;
	}
	
	public static IgracResponse findResponseByPriorityPrvoMax(int[] redosled, Request request, int red) {
		YambMetode metode=new YambMetode(request);
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red)) {
				if(redosled[i]==6) {
					return new IgracResponse(true, null, new FieldData(redosled[i], red));
				}
				if(redosled[i]==5) {
					return new IgracResponse(false, metode.cuvajKockiceMax(), new FieldData(redosled[i], red));
				}
				return new IgracResponse(false, metode.cuvajKockiceMax(), null);
			}
		}
		return null;
	}
	
	public static IgracResponse findResponseByPriorityDrugoMax(int[] redosled, Request request, int red) {
		YambMetode metode=new YambMetode(request);
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red))
				return new IgracResponse(false, metode.cuvajKockiceMax(), null);
		}
		return null;
	}
	
	public static IgracResponse findResponseByPriorityPrvoMin(int[] redosled, Request request, int red) {
		YambMetode metode=new YambMetode(request);
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red)) {
				if(redosled[i]==6) {
					return new IgracResponse(true, null, new FieldData(redosled[i], red));
				}
				if(redosled[i]==5) {
					return new IgracResponse(false, metode.cuvajKockiceMin(), new FieldData(redosled[i], red));
				}
				return new IgracResponse(false, metode.cuvajKockiceMin(), null);
			}
		}
		return null;
	}
	
	public static IgracResponse findResponseByPriorityDrugoMin(int[] redosled, Request request, int red) {
		YambMetode metode=new YambMetode(request);
		for(int i = 0; i < redosled.length; i++) {
			if(YambUtils.isPlayable(request, redosled[i], red))
				return new IgracResponse(false, metode.cuvajKockiceMin(), null);
		}
		return null;
	}
	
}
