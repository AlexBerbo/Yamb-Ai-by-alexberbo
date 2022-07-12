package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class YambLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static KentaLogika kentaLogika=new KentaLogika();
	static PokerLogika pokerLogika=new PokerLogika();
	static FullLogika fullLogika=new FullLogika();
	static TrillingLogika trillingLogika=new TrillingLogika();
	
	public static Response logikaYamb(Request request) { //metod koji vrsi logiku upisivanja yamb-a
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(metode.fiveOfaKind()) {
				int[] redosledYamb = new int[] {2, 4, 6, 5, 3, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledYamb, request, 14);
			}
			if(metode.kenta()) {
				return KentaLogika.logikaKenta(request);
			}
			if(metode.fourOfaKind()) {
				return PokerLogika.logikaPoker(request);
			}
			if(metode.full()) {
				return FullLogika.logikaFull(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 1,3)) {
				return KeceviLogika.kecevi(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 2,3)) {
				return DvojkeLogika.dvojke(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 3,3)) {
				return TrojkeLogika.trojke(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 4,3)) {
				return CetvorkeLogika.cetvorke(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 5,3)) {
				return PeticeLogika.petice(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 6,3)) {
				return SesticeLogika.sestice(request);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(metode.fiveOfaKind()) {
				int[] redosledYamb = new int[] {2, 4, 3, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledYamb, request, 14);
			}
			if(YambUtils.ucestalostBrojeva(request, 1,3)) {
				return KeceviLogika.kecevi(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 2,3)) {
				return DvojkeLogika.dvojke(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 3,3)) {
				return TrojkeLogika.trojke(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 4,3)) {
				return CetvorkeLogika.cetvorke(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 5,3)) {
				return PeticeLogika.petice(request);
			}
			if(YambUtils.ucestalostBrojeva(request, 6,3)) {
				return SesticeLogika.sestice(request);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE) {
			if(metode.fiveOfaKind()) {
				int[] redosledYamb = new int[] {2, 4, 1, 3, 0};
				return YambUtils.findResponseByPriorityTrece(redosledYamb, request, 14);
			}
			if(metode.fourOfaKind()) {
				return PokerLogika.logikaPoker(request);
			}
			if(metode.full()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.threeOfaKind()) {
				return TrillingLogika.logikaTrilling(request);
			}
		}
		return null;
	}
}
