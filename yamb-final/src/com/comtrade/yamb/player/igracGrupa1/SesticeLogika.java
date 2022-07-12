package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class SesticeLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static PokerLogika pokerLogika=new PokerLogika();
	static MinimumLogika minLogika=new MinimumLogika();
	
	public static Response sestice(Request request) { //metod koji vrsi logiku upisivanja sestica
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(5)) {
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
			if(YambUtils.ucestalostBrojeva(request, 6,3)) {
				int[] redosled = new int[] {6, 0, 1, 5, 4, 3, 2};
				IgracResponse res=YambUtils.findResponseByPriorityPrvo(redosled, request, 5, 6);
				if(res!=null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {0, 1, 2, 3, 4, 6, 5};
					return YambUtils.findResponseByPriorityPrvo(redosledTrilling, request, 11, 6);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 6, 2) && YambUtils.isPlayable(request, 5, 5) && request.getMoveNumber()>55){
				return new IgracResponse(false, metode.cuvajKockice(6), new FieldData(5,5));
			}
			else if(YambUtils.ucestalostBrojeva(request, 6, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(6), null);
			}
			else if(YambUtils.isPlayable(request, 5,11)) {
				if(YambUtils.ucestalostBrojeva(request, 6, 2)) {
					return new IgracResponse(false, metode.cuvajKockice(6), new FieldData(5,11));
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 6, 1)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityDrugo(redosled, request, 5, 6);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(5)) {
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
			if(YambUtils.ucestalostBrojeva(request, 6,4)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res=YambUtils.findResponseByPriorityDrugo(redosled, request, 5, 6);
				if(res!=null) {
					return res;
				}
				if(YambUtils.isPlayable(request, 0,13) || YambUtils.isPlayable(request, 1,13) || YambUtils.isPlayable(request, 2,13) || YambUtils.isPlayable(request, 3,13) || YambUtils.isPlayable(request, 4,13)) {
					return PokerLogika.logikaPoker(request);
				}
				else {
					int[] redosledTrilling = new int[] {0, 1, 2, 3, 4};
					return YambUtils.findResponseByPriorityDrugo(redosledTrilling, request, 11, 6);
				}	
			}
			else if(YambUtils.ucestalostBrojeva(request, 6, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(6), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(5)) {
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
			if(YambUtils.ucestalostBrojeva(request, 6,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res=YambUtils.findResponseByPriorityTrece(redosled, request, 5);
				if(res!=null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {2, 3, 1, 4, 0};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}

			}
			else if(YambUtils.ucestalostBrojeva(request, 6,2)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 5);
			}
		}
		return null;
	}
}
