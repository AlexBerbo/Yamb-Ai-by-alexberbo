package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class TrojkeLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	
	
	public static Response trojke(Request request) { //metod koji vrsi logiku upisivanja trojki
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(2)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 3,2)) {
				int[] redosled = new int[] {6, 0, 1, 5, 4, 3, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 2, 3);
			}
			if(YambUtils.ucestalostBrojeva(request, 3,1) && request.getMoveNumber()>55) {
				int[] redosled = new int[] {6, 0, 1, 5, 4, 3, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 2, 3);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(2)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 3,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res = YambUtils.findResponseByPriorityDrugo(redosled, request, 2, 3);
				if (res != null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {2, 3, 1, 4, 0};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 3, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(3), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(2)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(3)){
					return CetvorkeLogika.cetvorke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(1)){
					return DvojkeLogika.dvojke(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 3,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res = YambUtils.findResponseByPriorityTrece(redosled, request, 2);
				if (res != null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {2, 3, 1, 4, 0};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 3,2)){
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 2);
			}
		}
		return null;
	}
	
}
