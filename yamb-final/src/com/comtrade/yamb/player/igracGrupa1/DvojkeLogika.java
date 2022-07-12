package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class DvojkeLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	
	public static Response dvojke(Request request) { //metod koji vrsi logiku upisivanja dvojki
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(1)) {
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
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 2,3)) {
				int[] redosled = new int[] {0, 1, 4, 6, 5, 3, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 1, 2);
			}
			if(YambUtils.ucestalostBrojeva(request, 2,2) && YambUtils.isPlayable(request, 5, 1) && request.getMoveNumber()>70) {
				
				return new IgracResponse(false, metode.cuvajKockice(2), new FieldData(5,1));
			}
			else if(YambUtils.ucestalostBrojeva(request, 2,1) && request.getMoveNumber()>50) {
				int[] redosled = new int[] {0, 1, 4, 6, 5, 3, 2};
				return YambUtils.findResponseByPriorityPrvo(redosled, request, 1, 2);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(1)) {
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
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 2,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityDrugo(redosled, request, 1, 2);
			}
			else if(YambUtils.ucestalostBrojeva(request, 2, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(2), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(1)) {
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
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 2,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 1);
			}
			else if(YambUtils.ucestalostBrojeva(request, 2,2)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 1);
			}
		}
		return null;
	}

}
