package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class PokerLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static YambLogika yambLogika=new YambLogika();
	static KentaLogika kentaLogika=new KentaLogika();
	static PokerLogika pokerLogika=new PokerLogika();
	static FullLogika fullLogika=new FullLogika();
	static TrillingLogika trillingLogika=new TrillingLogika();
	
	public static Response logikaPoker(Request request) { //metod koji vrsi logiku upisivanja poker-a
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(13)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(12)){
					return FullLogika.logikaFull(request);
				}
			}
			if(metode.fourOfaKind()) {
				if(YambUtils.ucestalostBrojeva(request, 1, 3)) {
					return KeceviLogika.kecevi(request);
				}
				int[] redosledPoker = new int[] {6, 5, 2, 4, 3, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledPoker, request, 13);
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
			if(metode.threeOfaKind()) {
				return TrillingLogika.logikaTrilling(request);
			}
			if(metode.threeOfaKind()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.dupliPar()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.dupliPar()) {
				return TrillingLogika.logikaTrilling(request);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(13)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(12)){
					return FullLogika.logikaFull(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(11)){
					return TrillingLogika.logikaTrilling(request);
				}
			}
			if(metode.fourOfaKind()) {
				if(YambUtils.ucestalostBrojeva(request, 1,3)) {
					return KeceviLogika.kecevi(request);
				}
				int[] redosledPoker = new int[] {2, 3, 4, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledPoker, request, 13);
			}
			if(metode.fiveOfaKind()) {
				return YambLogika.logikaYamb(request);
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
			if(metode.threeOfaKind()){
				return TrillingLogika.logikaTrilling(request);
			}
			if(metode.full()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.dupliPar()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.kenta()) {
				return KentaLogika.logikaKenta(request);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE) {
			if(metode.fourOfaKind()) {
				if(YambUtils.ucestalostBrojeva(request, 1,3)) {
					return KeceviLogika.kecevi(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 2,3)) {
					return DvojkeLogika.dvojke(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 3,3)) {
					return TrojkeLogika.trojke(request);
				}
				int[] redosledPoker = new int[] {2, 3, 4, 1, 0};
				return YambUtils.findResponseByPriorityTrece(redosledPoker, request, 13);
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
			if(metode.threeOfaKind()){
				return TrillingLogika.logikaTrilling(request);
			}
			if(metode.full()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.dupliPar()) {
				return FullLogika.logikaFull(request);
			}
			if(metode.kenta()) {
				return KentaLogika.logikaKenta(request);
			}
		}
		return null;
	}
}
