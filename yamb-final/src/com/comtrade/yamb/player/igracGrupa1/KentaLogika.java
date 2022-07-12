package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class KentaLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	
	public static Response logikaKenta(Request request) { //metod koji vrsi logiku upisivanja kente
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(metode.kenta()) {
				int[] redosledKenta = new int[] {6, 3, 1, 0, 5, 2, 4};
				return YambUtils.findResponseByPriorityTrece(redosledKenta, request, 10);
				}
			}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(metode.kenta()) {
				int[] redosledKenta = new int[] {3, 1, 0, 2, 4};
				return YambUtils.findResponseByPriorityTrece(redosledKenta, request, 10);
				}
			}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(metode.kenta()) {
				int[] redosledKenta = new int[] {3, 1, 0, 2, 4};
				return YambUtils.findResponseByPriorityTrece(redosledKenta, request, 10);
				}
			}
		return null;
	}
}
