package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class MinimumLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static KentaLogika kentaLogika=new KentaLogika();
	static YambLogika yambLogika=new YambLogika();
	static PokerLogika pokerLogika=new PokerLogika();
	static FullLogika fullLogika=new FullLogika();
	static TrillingLogika trillingLogika=new TrillingLogika();
	static MinimumLogika minLogika=new MinimumLogika();
	static MaximumLogika maxLogika=new MaximumLogika();
	
	public static Response min(Request request) { //metod koji vrsi logiku upisivanja minimum-a
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(8)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(metode.min()<=10) {
				int[] redosledMin = new int[] {3, 6, 5, 1, 4, 2, 0};
				return YambUtils.findResponseByPriorityTrece(redosledMin, request, 8);
			}
			else if(metode.min()>14 && YambUtils.ucestalostBrojeva(request, 1, 1) && YambUtils.ucestalostBrojeva(request, 2, 1) && YambUtils.isPlayable(request, 0, 8)){
				return new IgracResponse(false, metode.cuvajKockiceMin(), new FieldData(0,8));
			}
			else if(metode.min()>14 && YambUtils.ucestalostBrojeva(request, 1, 1) && YambUtils.ucestalostBrojeva(request, 2, 1) && YambUtils.isPlayable(request, 2, 8)){
				return new IgracResponse(false, metode.cuvajKockiceMin(), new FieldData(2,8));
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(8)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(metode.min()<=10) {
				int[] redosledMin = new int[] {3, 1, 4, 0, 2};
				return YambUtils.findResponseByPriorityTrece(redosledMin, request, 8);
			}
			else if(metode.min()>14 && YambUtils.ucestalostBrojeva(request, 1, 1) && YambUtils.ucestalostBrojeva(request, 2, 1) && YambUtils.isPlayable(request, 0, 8)){
				return new IgracResponse(false, metode.cuvajKockiceMin(), new FieldData(0,8));
			}
			else if(metode.min()>14 && YambUtils.ucestalostBrojeva(request, 1, 1) && YambUtils.ucestalostBrojeva(request, 2, 1) && YambUtils.isPlayable(request, 2, 8)){
				return new IgracResponse(false, metode.cuvajKockiceMin(), new FieldData(2,8));
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(8)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(2)){
					return TrojkeLogika.trojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(metode.min()<=11) {
				int[] redosledMin = new int[] {3, 1, 4, 0, 2};
				return YambUtils.findResponseByPriorityTrece(redosledMin, request, 8);	
			}
			else {
				if(YambUtils.ucestalostBrojeva(request, 1,3)) {
					return KeceviLogika.kecevi(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 2,2)) {
					return DvojkeLogika.dvojke(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 4,3)) {
					return TrillingLogika.logikaTrilling(request);
				}
				if(YambUtils.ucestalostBrojeva(request, 5,3)) {
					return TrillingLogika.logikaTrilling(request);
				}
			}
			if(metode.min()<=12) {
				int[] redosledMin = new int[] {3, 1, 4, 0, 2};
				return YambUtils.findResponseByPriorityTrece(redosledMin, request, 8);
			}
			if(metode.min()>=13){
				if(metode.fiveOfaKind()) {
					return YambLogika.logikaYamb(request);
				}
				if(metode.fourOfaKind()) {
					return PokerLogika.logikaPoker(request);
				}
				if(metode.max()>=27) {
					return MaximumLogika.max(request);
				}
				if(metode.kenta()) {
					return KentaLogika.logikaKenta(request);
				}
				if(metode.threeOfaKind()) {
					return TrillingLogika.logikaTrilling(request);
				}
				if(metode.dupliPar()) {
					return TrillingLogika.logikaTrilling(request);
				}
				if(metode.full()) {
					return FullLogika.logikaFull(request);
				}
				if(YambUtils.isPlayable(request, 2,14)) {
					return new IgracResponse(true, null, new FieldData(2,14));
				}
			}
		}	
		return null;
	}
}
