package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class CetvorkeLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static PokerLogika pokerLogika=new PokerLogika();
	
	public static Response cetvorke(Request request) { //metod koji vrsi logiku upisivanja cetvorki
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(3)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(4)){
					return PeticeLogika.petice(request);
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
			if(YambUtils.ucestalostBrojeva(request, 4,2)) {
				int[] redosled = new int[] {6, 0, 4, 1, 3, 5, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 3, 4);
			}
			if(YambUtils.ucestalostBrojeva(request, 4,1) && request.getMoveNumber()>40) {
				int[] redosled = new int[] {0, 4, 1, 3, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 3, 4);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(3)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
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
			if(YambUtils.ucestalostBrojeva(request, 4,4)) {
				int[] redosled = new int[] {0, 4, 1, 3, 2};
				IgracResponse res = YambUtils.findResponseByPriorityDrugo(redosled, request, 3, 4);
				if(res != null) {
					return res;
				}
				if(YambUtils.isPlayable(request, 1,13) || YambUtils.isPlayable(request, 2,13) || YambUtils.isPlayable(request, 3,13) || YambUtils.isPlayable(request, 4,13) || YambUtils.isPlayable(request, 0,13)) {
					return PokerLogika.logikaPoker(request);
				}
				else{
					int[] redosledTrilling = new int[] {2, 3, 1, 4, 0};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 4, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(4), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(3)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
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
			if(YambUtils.ucestalostBrojeva(request, 4,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res = YambUtils.findResponseByPriorityTrece(redosled, request, 3);
				if (res != null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {2, 3, 1, 4, 0};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 4, 2)){
				int[] redosled = new int[] {0, 4, 1, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 3);
			}
		}
		return null;
	}
	
}
