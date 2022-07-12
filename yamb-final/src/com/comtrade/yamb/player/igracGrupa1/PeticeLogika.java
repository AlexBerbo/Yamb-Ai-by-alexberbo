package com.comtrade.yamb.player.igracGrupa1;

import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.Response;

public class PeticeLogika {
	static YambKoloneBrojevi koloneBrojevi;
	static YambUtils utils;
	static YambMetode metode;
	static PokerLogika pokerLogika=new PokerLogika();
	
	public static Response petice(Request request) { //metod koji vrsi logiku upisivanja petica
		metode=new YambMetode(request);
		koloneBrojevi=new YambKoloneBrojevi(request, metode, utils);
		if(request.getThrowNumber()==Konstrakte.PRVO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(4)) {
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldPrvoBacanje(5)){
					return SesticeLogika.sestice(request);
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
			if(YambUtils.ucestalostBrojeva(request, 5,3)) {
				int[] redosled = new int[] {6, 0, 1, 5, 3, 4, 2};
				IgracResponse res=YambUtils.findResponseByPriorityPrvo(redosled, request, 4, 5);
				if(res!=null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {6, 5, 2, 3, 4, 0, 1};
					return YambUtils.findResponseByPriorityPrvo(redosledTrilling, request, 11, 5);
				}
			}
			else if (YambUtils.ucestalostBrojeva(request, 5, 2) && YambUtils.isPlayable(request, 5, 4) && request.getMoveNumber()>45){
				return new IgracResponse(false, metode.cuvajKockice(5), new FieldData(5,4));
			}
			else if(YambUtils.ucestalostBrojeva(request, 5, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(5), null);
			}
			else if(YambUtils.isPlayable(request, 5,11)) {
				if(YambUtils.ucestalostBrojeva(request, 5, 2)) {
					return new IgracResponse(false, metode.cuvajKockice(5), new FieldData(5,11));
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 5, 1) && request.getMoveNumber()>70) {
				int[] redosled = new int[] {0, 1, 3, 4, 2};
				return YambUtils.findResponseByPriorityDrugo(redosled, request, 4, 5);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.DRUGO_BACANJE) {
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(4)) {
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
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(5)){
					return SesticeLogika.sestice(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 5,4)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res=YambUtils.findResponseByPriorityDrugo(redosled, request, 4, 5);
				if(res!=null) {
					return res;
				}
				if(YambUtils.isPlayable(request, 0,13) || YambUtils.isPlayable(request, 1,13) || YambUtils.isPlayable(request, 2,13) || YambUtils.isPlayable(request, 3,13) || YambUtils.isPlayable(request, 4,13)) {
					return PokerLogika.logikaPoker(request);
				}
				else {
					int[] redosledTrilling = new int[] {2, 3, 4, 0, 1};
					return YambUtils.findResponseByPriorityDrugo(redosledTrilling, request, 11, 5);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 5, 2)) {
				return new IgracResponse(false, metode.cuvajKockice(5), null);
			}
		}
		else if(request.getThrowNumber()==Konstrakte.TRECE_BACANJE){
			if(YambKoloneBrojevi.isColumnPlayedForAllNumberFields(4)) {
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
				if(YambKoloneBrojevi.isColumnPlayableForNumberFieldDrugoiTreceBacanje(0)){
					return KeceviLogika.kecevi(request);
				}
			}
			if(YambUtils.ucestalostBrojeva(request, 5,3)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				IgracResponse res=YambUtils.findResponseByPriorityTrece(redosled, request, 4);
				if(res!=null) {
					return res;
				}
				else {
					int[] redosledTrilling = new int[] {2, 3, 1, 4, 0};
					return YambUtils.findResponseByPriorityTrece(redosledTrilling, request, 11);
				}
			}
			else if(YambUtils.ucestalostBrojeva(request, 5,2)) {
				int[] redosled = new int[] {0, 1, 4, 3, 2};
				return YambUtils.findResponseByPriorityTrece(redosled, request, 4);
			}
		}
		return null;
	}
}
