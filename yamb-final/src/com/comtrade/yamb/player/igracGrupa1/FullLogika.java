package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class FullLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static KentaLogika kentaLogika=new KentaLogika();
	static PokerLogika pokerLogika=new PokerLogika();
	static FullLogika fullLogika=new FullLogika();
	static TrillingLogika trillingLogika=new TrillingLogika();
	static MinimumLogika minLogika=new MinimumLogika();
	
	public static Response logikaFull(Request request) { //metod koji vrsi logiku upisivanja full-a
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(12)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(5)){
					return SesticeLogika.sestice(request);
				}
			}
			if(metode.full()) {
				if((YambUtils.ucestalostBrojeva(request, 1,2) && YambUtils.ucestalostBrojeva(request, 2,3)) || (YambUtils.ucestalostBrojeva(request, 1,3) && YambUtils.ucestalostBrojeva(request, 2,2))) {
					return MinimumLogika.min(request);
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
				int[] redosledFull = new int[] {6, 5, 3, 2, 4, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledFull, request, 12);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(12)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(11)){
					return TrillingLogika.logikaTrilling(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
			}
			if(metode.full()) {
				if(YambUtils.ucestalostBrojeva(request, 1,2) && YambUtils.ucestalostBrojeva(request, 2,3) || (YambUtils.ucestalostBrojeva(request, 1,3) && YambUtils.ucestalostBrojeva(request, 2,2))) {
					return MinimumLogika.min(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 1,3) ) {
					return KeceviLogika.kecevi(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 2,3)) {
					return DvojkeLogika.dvojke(request);
				}
				int[] redosledFull = new int[] {3, 2, 4, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledFull, request, 12);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE) {
			if(metode.full()) {
				if(YambUtils.ucestalostBrojeva(request, 1,2) && YambUtils.ucestalostBrojeva(request, 2,3) || (YambUtils.ucestalostBrojeva(request, 1,3) && YambUtils.ucestalostBrojeva(request, 2,2))) {
					return MinimumLogika.min(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 1,3)) {
					return KeceviLogika.kecevi(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 2,3)) {
					return DvojkeLogika.dvojke(request);
				}
				int[] redosledFull = new int[] {3, 2, 4, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledFull, request, 12);
			}
		}
		return null;
	}
}
