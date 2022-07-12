package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class MaximumLogika {
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
	
	public static Response max(Request request) { //metod koji vrsi logiku upisivanja maximum-a
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(7)) {
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
			if(metode.max()>=26) {
				int[] redosledMax = new int[] {6, 3, 1, 5, 4, 0, 2};
				return YambUtils.findResponseByPriorityPrvoMax(redosledMax, request, 7);
			}
			else if(metode.max()>=16 && metode.max()<21) {
				if(YambUtils.isPlayable(request, 5,7)) {
					for(int i=5;i<=Constants.DICE_COUNT;i++) {
						if((YambUtils.ucestalostBrojeva(request, i,1) && YambUtils.ucestalostBrojeva(request, i, 2)) || (YambUtils.ucestalostBrojeva(request, i,2) && YambUtils.ucestalostBrojeva(request, i, 1))) {
							return new IgracResponse(false, metode.cuvajKockiceMax(), new FieldData(5,7));
						}
					}
				}
			}
			else if(YambUtils.isPlayable(request, 3,7) || YambUtils.isPlayable(request, 1,7) || YambUtils.isPlayable(request, 4,7) || YambUtils.isPlayable(request, 0,7) || YambUtils.isPlayable(request, 2,7)) {
				if(metode.max()>=16 && metode.max()<25) {
					for(int i=5;i<=Constants.DICE_COUNT;i++) {
						if((YambUtils.ucestalostBrojeva(request, i,1) && YambUtils.ucestalostBrojeva(request, i, 2)) || (YambUtils.ucestalostBrojeva(request, i,2) && YambUtils.ucestalostBrojeva(request, i, 1))) {
							return new IgracResponse(false, metode.cuvajKockice(i), null);
						}
					}
				}
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(7)) {
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
			if(metode.max()>=26) {
				int[] redosledMax = new int[] {3, 1, 4, 0, 2};
				return YambUtils.findResponseByPriorityDrugoMax(redosledMax, request, 7);
			}
			else if(metode.max()>=19 && metode.max()<25) {
				for(int i=5;i<=Constants.DICE_COUNT;i++) {
					if((YambUtils.ucestalostBrojeva(request, i,1) && YambUtils.ucestalostBrojeva(request, i, 2)) || (YambUtils.ucestalostBrojeva(request, i,2) && YambUtils.ucestalostBrojeva(request, i, 1))) {
						return new IgracResponse(false, metode.cuvajKockice(i), null);
					}
				}
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(7)) {
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
			if(metode.max()>=23) {
				int[] redosledMax = new int[] {3, 1, 4, 0, 2};
				return YambUtils.findResponseByPriorityTrece(redosledMax, request, 7);
			}
			else {
				if(metode.fiveOfaKind()) {
					return YambLogika.logikaYamb(request);
				}
				if(metode.kenta()) {
					return KentaLogika.logikaKenta(request);
				}
				if(metode.fourOfaKind()) {
					return PokerLogika.logikaPoker(request);
				}
				if(metode.threeOfaKind()) {
					return TrillingLogika.logikaTrilling(request);
				}
				if(metode.full()) {
					return FullLogika.logikaFull(request);
				}
				if(metode.dupliPar()) {
					return TrillingLogika.logikaTrilling(request);
				}
				if(YambUtils.isPlayable(request, 2,14)) {
					return new IgracResponse(true, null, new FieldData(2,14));
				}
			}
		}
		return null;
	}
	
}
