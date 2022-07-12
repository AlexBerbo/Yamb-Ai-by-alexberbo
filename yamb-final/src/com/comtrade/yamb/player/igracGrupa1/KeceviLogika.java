package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class KeceviLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	
	public static Response kecevi(Request request) { //metod koji vrsi logiku upisivanja jedinica
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(0)) {
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
			}
			if(YambUtils.ucestalostBrojeva(request, 1,2)) {
				int[] redosled = new int[] {0, 5, 4, 1, 6, 3, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 0, 1);
			}
			else if(YambUtils.ucestalostBrojeva(request, 1, 1)) {
				return new IgracResponse(false, metode.cuvajKockice(1), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(0)) {
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
			}
			if(YambUtils.ucestalostBrojeva(request, 1,3)) {
				int[] redosled = new int[] {0, 4, 1, 3, 2};
				return YambUtils.findResponseByPriorityDrugo(redosled, request, 0, 1);
			}
			else if(YambUtils.ucestalostBrojeva(request, 1, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(1), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(0)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(4)){
					return PeticeLogika.petice(request);
				}
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
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
			}
			if(YambUtils.ucestalostBrojeva(request, 1,3)) {
				int[] redosled = new int[] {0, 4, 1, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 0);
			}
			else if(YambUtils.ucestalostBrojeva(request, 1,2)) {
				int[] redosled = new int[] {0, 4, 1, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 0);
			}
		}	
		return null;
	}
}
